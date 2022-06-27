# MyHealth New England WebApp

Welcome to my Capstone project for my TEKsystems Java Bootcamp!  The goal of this website is to make finding Health Care 
providers in the New England area more accessible.  By having one Website where you can go and search for healthcare providers
by the State that their in and find the right Health Care for you!

## Technical requirements:

<details> <summary>

### Standard Java Naming conventions

</summary><p>
Classes should be written in Pascal case 

Variables, methods, and URLs should be written in the camel case 

Files, including view files, should be written in snake case 

Packages should be written in lowercase, with each word separated by dots (.) 

Packages should include the name of your project and your name (e.g., “org.johndoe.myprojectname”)
</p>
</details>

<details> <summary>

### Core Java and Models
</summary><p>
Utilize Java classes with constant variables (i.e., variables that never change from their initial value). The value of these variables can be requested parameters, SQL queries used in the DAO, names of HTML pages, or URL patterns to forward a request to 

Have at least four models and corresponding tables in a relational database 

At least four models

A corresponding table in a relational database for each model 

Correct implementations 

Apply exception handling
</p>
</details>

<details><summary>

### Data, ORM, and Hibernate

</summary>
<p>
Use MariaDB as your DBMS

Include a schema diagram of the tables and the SQL you used for the database

The database configuration file must be set up correctly in your Spring application through “spring initializr” (application.properties) 

Include at least three custom queries 

Use Hibernate or Jakarta Persistence API (JPA) directly or through Spring Data JPA 

Your application should include examples for all four CRUD operations (Create, Read, Update, and Delete) 
</p>
</details>

<details><summary>

### Front-end Development

</summary>
<p>
Use CSS to style the Web pages. Use an external CSS stylesheet (internal styling may be used along with frameworks such as Bootstrap, but you must still include and utilize a custom CSS external file)

Your application should include six different views/pages

Use HTML to lay out the pages and Thymeleaf to make the pages dynamic. The application’s presentation must meet the general view requirements.

Use at least one JavaScript script linked from an external script file 
Include a navigation section that is included across multiple pages. 
</p>
</details>

<details><summary>

### Spring Framework

</summary>
<p>
Use Spring Boot to develop your project

Models should be annotated for binding using Spring data binding through Jakarta and/or Hibernate validation 

Include and implement at least two repositories and two service classes/interfaces 

Include at least two ways of creating a managed bean/object 

Use correct implementations of dependency injection with appropriate use of the @Autowired annotation 

Include at least one example of session management (Spring Security can be used for session management) 

Use Transaction and request/response logging (write log to a file) 

Include sign-up and login functionality with encrypted passwords using bcrypt (Spring Security will satisfy this requirement)
</p>
</details>

<details><summary>

### Unit Testing

</summary>
<p>
Test each query created in the repositories.

Test at least one method in each service class.

Include at least one parameterized test.
</p>
</details>

<details><summary>

### User Stories

</summary>
<p>
As a User, I want to Register for an account, so that I can use the features of the site.

As a User, I want to have an account, so that I am assured that my searches and potential are secure.

As a User, I want to Search for states, so that I can find Health Care Providers

As a User, I want to Search for Providers by their State, so that I can make sure that they're available in my area.

As a User, I want to have a HyperLink for the Providers website, so that I can learn more about to Health Care Provider.

As a User, I want to be able to update my email, so that I can change my login information in case I lose the email.

As a User, I want to be able to update my password, so that in case there is a security issue I'll be ok.

As a User, I want to be able to delete my account, so that I can get rid of any personal information on the website once I don't want to use it anymore.
</p>
</details>

##  TECHNOLOGIES USED:
- Java
- Spring Boot
- Spring Security
- Thymeleaf
- Spring Data
- Lombok
- Hibernate
- HTML
- CSS
- JavaScript
- Bootstrap
- MariaDB
