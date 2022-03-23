

# Ekea- Spring Boot Project
A full stack application which is an electronics shop where customers can purchase electronics. This project was completed using Bootstrap template, Thymeleaf, html and css on front end. Spring boot, Spring, Spring security, MVC, ORM, CRUD, Hibernate and MySQL were used for managing back end and database.

## Technologies:

* ## Spring Security
The project used spring security to enhance the overall security of the application. By using spring security, Employee Authentication, Form based authentication, role based features, employee logout, customer membership sign up.

* ## Java
As the project was developed using spring boot, all the classes were written in Java following MVC pattern. Using OOP, ORM and DAO pattern, the project classes were divided in different packages. This helped in clearly going through files and making changes as well as fixing bugs.

* ## Thymeleaf

As the project used a <a href="https://startbootstrap.com/template/shop-homepage">Bootstrap template </a>, Thymeleaf was used to complete the views for the MVC model of the application. Using Thymeleaf helped in using data from back end as well as sending data to the back end. Custom forms for employee authentication and user sign up were also made using thymeleaf. Thymeleaf also helped in **reducing the code** by  using tags like ```th:for``` for iterations on objects passed from backend.


* ## Hibernate

As the project used the ORM model, Hibernate helped in implementing JPA and persisting data in mysql relational databases. Java objects called entities were mapped to database records. This also helped in implementing CRUD features with entities like employeee, customer and products.


* ## Spring REST

Spring REST helped in handling HTTP requests in the controllers. Annotations like ```@RequestMapping, @GetMapping, @PostMapping, @DeleteMapping``` helped in handling form submissions for employee authentication, handling page requests and implementing CRUD features for admin level roles in employees.

* ## Spring Boot

  
Spring boot helped in making this project a standalone project as well as getting started with the project as it helped in getting starter dependencies for the project. Few dependencies used to get started were Spring Web, Spring Security, Thymeleaf, Spring Data JPA, MySQL Driver and Spring Boot Devtools. 

* ## MySQL

MySQL was used for designing relational databases for the project. Queries were performed from Java methods to perform CRUD fetures on the database tables. Tables that were made in the database were: Employee table, Customer table, Product table, Users table and Authorities table. Workbench was used for viewing tables and queries.

<p align="center">
    <img src="https://i.imgur.com/6LsO1zy.png"/>
 </p>

## Challenges 
Few challenges faced while completing the project were:
1. Implementing employee role based login.
2. Implementing custom error form and diverting all incorrect request to the page.
3. Persisting username in the cookies after user completes the user membership so the user is not asked to sign up again if the user is using same device.


## Starting Up
After brainstorming the project and designing wireframes for the project using the bootstrap template, the project was divided into two parts:

1. Customer side:
*  Customer could view the product catalogue
*  Add to cart the product
*  View the cart 
*  Become a member of the Ekea store.

<p align="center">
    <img width="700" height="400" src="https://github.com/Apurv-T/Ekea/blob/main/readme%20gif/customer_front_end.gif"/>
 </p>

2. Employee side
* Employee are able to login and logout with their respective credentials.
* Employee had three roles: admin, manager and employees.
* Roles helped in deciding the actions that can be performed by employees.
* Employees can also view list of products and employees.
<p align="center">
    <img width="700" height="400" src="https://github.com/Apurv-T/Ekea/blob/main/readme%20gif/employeeEkea.gif"/>
 </p>


