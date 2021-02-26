# revenueTracker

The project is based on Java language.
The following frameworks and technologies were used
1. Spring Boots
2. Rest API
3. JPA
4. MySQL

------------------------------------------------------
The rest endpoints
1. POST: http://localhost:8085/revenues/new     for creating a new revenue type
2. GET: http://localhost:8085/revenues/all      for viewing all revenue tyepes
3. GET: http://localhost:8085/revenues/tax/1    for viewing the revenue type with id =1

Errors or exception are caught by RevenueTypeNotFoundException exception handlers

All end points carefully tested using POSTMAN
