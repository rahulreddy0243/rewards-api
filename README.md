**<h1>REWARDS API**

**<h2>API to retrieve reward points for a given customer**</h2>

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase. A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction (e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points). Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total.

NOTE:
------
 1. Used In memory H2 DB for schema definitions and to store customer information and transactions.
 2. Centralized Exception Handling.
 3. API can be accessed via postman or swagger-ui at http://localhost:8080/customers/{customerId}/rewardPoints.
 4. Rest API contract can be accessed at http://localhost:8080/swagger-ui.html or at http://localhost:8080/v2/api-docs.
