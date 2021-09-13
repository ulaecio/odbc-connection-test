Tabela de conteúdos
=================
<!--ts-->
   * [Sobre](#odbc-connection-test)
   * [Tabela de Conteudo](#Links-uteis)
   * [Instalação](#instalacao)
   * [Exemplos](#Spring-Boot-Connect-to-Oracle-Database-Examples)
      * [Pre Requisitos](#pre-requisitos)
      * [Local files](#local-files)
      * [Remote files](#remote-files)
      * [Multiple files](#multiple-files)
      * [Combo](#combo)
   * [Tests](#testes)
   * [Tecnologias](#tecnologias)
<!--te-->
# odbc-connection-test
Esse repositório foi criado para realização de teste de conexão com banco de Dados Oracle com Spring Boot via JDBC Template e JPA

# Spring Boot Connect to Oracle Database Examples

In this post, I’ll show you the steps and some code examples for connecting to Oracle database server and executing SQL statements in Spring Boot application. Basically, there are two common ways:
Connect to an Oracle database using Spring JDBC with JdbcTemplate API
Connect to an Oracle database using Spring Data JPA with Hibernate framework
Here are the steps which you need to follow in order to configure a Spring Boot project working with an Oracle database:
Add a dependency for Oracle JDBC driver that connects Java applications with an Oracle database server.
Configure data source properties for the database connection information
Add a dependency for Spring JDBC or Spring Data JPA, depending on your need:
Use Spring JDBC for executing plain SQL statements
Use Spring Data JPA for more advanced use, e.g. mapping Java classes to tables and Java objects to rows, and take advantages of the Spring Data JPA API.
Let’s go into the details below.
 
## 1. Declare dependency for Oracle JDBC Driver
Oracle JDBC driver is required at runtime, so you need to add the following dependency to your Maven projectfile:

    <dependency>
        <groupId>com.oracle.database.jdbc</groupId>
        <artifactId>ojdbc8</artifactId>
        <scope>runtime</scope>
    </dependency>
  
Here, I use ojdbc8 for JDK 8 with Oracle database 11g and 12c. For Oracle database 18c and 19c, use the artifactId ojdbc10.
 
## 2. Configure Data Source Properties
Next, configure some data source properties in the Spring Boot application configuration file (application.properties) as follows:

    spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
    spring.datasource.username=username
    spring.datasource.password=password
    
Here, the JDBC URL points to an instance of Oracle database server running on localhost.

## 3. Connect to Oracle Database with Spring JDBC
To use Spring JDBC, add the following dependency to your Maven project file:

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jdbc</artifactId>
    </dependency>

And below is code of a Spring Boot console program that illustrates how to use JdbcTemplate to execute a SQL Select statement:

    package net.codejava;

    import java.util.List;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.CommandLineRunner;
    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    import org.springframework.jdbc.core.BeanPropertyRowMapper;
    import org.springframework.jdbc.core.JdbcTemplate;

    @SpringBootApplication
    public class SpringJdbcTemplate2OracleApplication implements CommandLineRunner {

        @Autowired
        private JdbcTemplate jdbcTemplate;

        public static void main(String[] args) {
            SpringApplication.run(SpringJdbcTemplate2OracleApplication.class, args);
        }

        @Override
        public void run(String... args) throws Exception {
            String sql = "SELECT * FROM Students";

            List<Student> students = jdbcTemplate.query(sql,
                    BeanPropertyRowMapper.newInstance(Student.class));

            students.forEach(System.out :: println);
        }

    }
The Student class is a trivial POJO class with 3 fields id, name and email. Behind the scene, the JdbcTemplate creates database connection when necessary so you can focus on coding your business logic.
For details about using Spring JdbcTemplate, I recommend you to read this tutorial.
 
## 4. Connect to Oracle Database with Spring Data JPA
In case you need to use Spring Data JPA, add the following dependency to your project:

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    
With Spring Data JPA and Hibernate framework, you can also specify some additional properties as follows:

    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.Oracle10gDialect
    And code Java class acts as an entity mapping with the corresponding table in the database:

    package net.codejava;

    import javax.persistence.*;

    @Entity
    @Table(name = "customers")
    public class Customer {
        @Id
        @Column(name = "customer_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String email;

        // getters and setters go here...
    }
    
And declare a corresponding repository interface, as shown below:

    package net.codejava;

    import org.springframework.data.jpa.repository.JpaRepository;

    public interface CustomerRepository extends JpaRepository<Customer, Long> {

    }
    And then you can use this repository in a Spring MVC controller or business class as follows:

    @Controller
    public class CustomerController {
        @Autowired
        private CustomerRepository customerRepo;

        @GetMapping("/customers")
        public String listAll(Model model) {
            List<Customer> listCustomers = customerRepo.findAll();
            model.addAttribute("listCustomers", listCustomers);

            return "customers";
        }

    }

I recommend you to follow this article: Understand Spring Data JPA with Simple Example to learn more about Spring Data JPA.
Those are some code examples for connecting to Oracle database in Spring Boot. As you have seen, Spring Boot greatly simplifies the programming, and you can choose to use Spring JDBC or Spring Data JPA.
Watch the following video to see the coding in action:

 
### Related Articles:
Understand Spring Data JPA with Simple Example
Spring MVC with JdbcTemplate Example
Spring Boot - Spring Data JPA - MySQL Example
 

### About the Author:
Nam Ha Minh is certified Java programmer (SCJP and SCWCD). He started programming with Java in the time of Java 1.4 and has been falling in love with Java since then. Make friend with him on Facebook and watch his Java videos you YouTube.

## Links-uteis
https://www.codejava.net/frameworks/spring-boot/connect-to-oracle-database-examples
https://www.youtube.com/watch?v=CCqVKz6RRLs&t=1665s

## Como fazer um bom READ-me
https://blog.rocketseat.com.br/como-fazer-um-bom-readme/
