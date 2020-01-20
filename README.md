--------------------------------------------------------------------
Project Title: Spring boot + ElasticSearch CRUD Operation
--------------------------------------------------------------------

Tools And Technologies:
-----------------------
.Java 11
.Maven 4.0.0
.Spring Boot 2.0.1.RELEASE
.ElasticSearch 6.1.2


Installing software in windows
--------------------------------

Elasticsearch
----------------------------------------------

-> Download latest version of Elasticsearch from url https://www.elastic.co/downloads/elasticsearch download page and unzip it.
-> Run bin\elasticsearch.bat from command prompt.
-> By default, it will start at http://localhost:9200


Getting Started with Project Structure
---------------------------------------
1. Download and import the project 
2. clean and build the project 
3. Run ElasticSearchApplication.java file


Testing with Rest Api
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Info                              api url                          Request method type          Request                                                        Response
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Inserting  Employee        : http://localhost:8080/employee               Post                {"id": "2", "name": "Suresh", "age": 27, "salary": 20000}        record inserted
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Getting Employee           : http://localhost:8080/employee/{id}          Get                 {"id": "4", "name": "Ramesh", "age": 26, "salary": 27000}
-------------------------------------------------------------------------------------------------------- --------------------------------------------------------------------------
Updating Specific Employee : http://localhost:8080/employee/update        Put                 {"id": "8", "name": "Ganesh", "age": 29, "salary": 25000}         record updated
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Deleting Specific Employee : http://localhost:8080/employee/{id}          Delete                                                                                record deleted  
------------------------------------------------------------- ---------------------------------------------------------------------------------------------------------------------





































 




