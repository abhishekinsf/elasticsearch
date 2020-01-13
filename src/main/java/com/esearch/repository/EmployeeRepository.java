package com.esearch.repository;

import com.esearch.dbo.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author abhishek.k
 */
@Repository
public class EmployeeRepository {

    private static final String INDEX = "employee";
    private static final String TYPE ="employee";

    private RestHighLevelClient restHighLevelClient;

    private ObjectMapper objectMapper;

    public EmployeeRepository(RestHighLevelClient restHighLevelClient, ObjectMapper objectMapper) {
        this.restHighLevelClient = restHighLevelClient;
        this.objectMapper = objectMapper;
    }

    public Employee insert(Employee emp){
        Map<String, Object> dataMap = objectMapper.convertValue(emp, Map.class);
        IndexRequest indexRequest = new IndexRequest(INDEX, TYPE, emp.getId()).source(dataMap);
        try {
            restHighLevelClient.index(indexRequest);
        } catch (ElasticsearchException e) {
            e.getDetailedMessage();
        } catch (IOException ex) {
            ex.getLocalizedMessage();
        }
        return emp;
    }

    public Map<String, Object> getEmployeeById(String id){
        GetRequest getRequest = new GetRequest(INDEX, TYPE, id);
        GetResponse getResponse = null;
        try {
            getResponse = restHighLevelClient.get(getRequest);
        } catch (java.io.IOException e){
            e.getLocalizedMessage();
        }
        return getResponse.getSourceAsMap();
    }

    public Map<String, Object> updateEmployeeById(String id, Employee employee){
        UpdateRequest updateRequest = new UpdateRequest(INDEX, TYPE, id)
                .fetchSource(true);
        Map<String, Object> error = new HashMap<>();
        error.put("Error", "Unable to update Employee");
        try {
            String employeeJson = objectMapper.writeValueAsString(employee);
            updateRequest.doc(employeeJson, XContentType.JSON);
            UpdateResponse updateResponse = restHighLevelClient.update(updateRequest);
            return updateResponse.getGetResult().sourceAsMap();
        }catch (JsonProcessingException e){
            e.getMessage();
        } catch (java.io.IOException e){
            e.getLocalizedMessage();
        }
        return error;
    }

    public void deleteEmployeeById(String id) {
        DeleteRequest deleteRequest = new DeleteRequest(INDEX, TYPE, id);
        try {
            restHighLevelClient.delete(deleteRequest);
        } catch (java.io.IOException e){
            e.getLocalizedMessage();
        }
    }

}
