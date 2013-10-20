## Lab 01 - Getting to know Ike

### Objectives

During this lab you will learn:

* What kind of challenge in the testing landscape Arquillian is trying to solve? 
* What are the core functionalities of Arquillian.
* What is required for JUnit tests to be handled by Arquillian.
* How to define a deployment.
* How to run the test in GlassFish Embedded both using a build tool and directly from the IDE.

### Task

First step is to convert plain unit test based on mocks to Arquillian integration test.

You will need to do following: 
* Substite mocked implementation(link here) with real JPA repository
* Provide test data for your in-memory database to be used for testing, for instance using @@Before@ mechanism available in JUnit and interact with @EntityManager@ to seed the database
* Define a deployment package programmatically using **ShrinkWrap**
* Run the test from the command line using `mvn clean package`
* Run it directly from the IDE

The solution is available [here](link).