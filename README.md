Cat Card CLI Java Application & REST API

This command line application and REST API is built with Spring and Java to display and manage a cat card collection. The collection of data is stored in Postgres and an API is called on to touch the database. The main goal of this project is to understand the roles and connections between the client, API, server, and database for managing data.

Accomplished Objectives:

- Incorporate Spring Boot Core MVC framework
- Create a database in pgAdmin/Postgres
- Make a CLI program that takes in data from a user and be able to interact with the database and make the necessary HTTP calls to the server
- Apply correct logical branching to build CLI application 
- Make an HTTP GET, PUT, POST, and DELETE request to a RESTful web API service and process the response using RestTemplate
- Parse JSON into a Java object (deserialize) using the getForObject() method 
- Catch and handle errors thrown by RestTemplate using try/catch
- Show responses from API with specific HTTP status codes
- Create GET, POST, PUT, and DELETE controller actions to respond to incoming web requests 
- Connect a local client application to a locally running API
- Connect Java application to a SQL database using the DAO pattern, Spring JDBC, and SQL statements

Accomplished Challenges:

- Implement a REST API service that automatically generates a cat image url each time a new cat card is added to the database
- Implement a REST API service that automatically generates a cat fact each time a new cat card is added to the database

Planned Updates/Improvements:

- Create a ConsoleService class to minimize nested if statements in the CLI application
- Add a prompt to double check that the entered user’s cat card is indeed the card the user wants to delete before deleting it

Credits: https://www.techelevator.com/
