# Hibernet Mapping
## What is Mapping ?? How to perform Mapping

Hibernate is a framework that provides some abstraction layer, meaning that the programmer does not have to worry about the implementations, Hibernate does the implementations for you internally like Establishing a connection with the database, writing queries to perform CRUD operations, etc. It is a java framework that is used to develop persistence logic. Persistence logic means storing and processing the data for long use. More precisely Hibernate is an open-source, non-invasive, lightweight java ORM(Object-relational mapping) framework to develop objects that are independent of the database software and make independent persistence logic in all JAVA, JEE. <br>

Hibernate mappings are one of the key features of hibernate. they establish the relationship between two database tables as attributes in your model. which allows you to easily navigate the associations in your model and criteria queries. <br>

You can establish either unidirectional or bidirectional i.e you can either model them as an attribute on only one of the associated entities or both. it will not impact your database mapping tables, but it defines how to use the relationship in your model and criteria queries.

The relationship that can be established between entities are-

* **one to one** — it represents the one to one relationship between two tables.
* **one to many/many to one** — it represents the one to many relationship between two tables.
* **many to many** — it represents the many to many relationship between two tables.
-----
### Basic Annotations

* @Entity: Marks a class as an entity (a persistent Java class).
* @Table: Specifies the table name in the database to which the entity is mapped.
* @Id: Denotes the primary key of the entity.
* @GeneratedValue: Defines how the primary key value is generated.
* @Column: Specifies the column name and constraints in the table.

----
### What is one-to-one mapping?
One to one represents that a single entity is associated with a single instance of the other entity. An instance of a source entity can be at most mapped to one instance of the target entity. We have a lot of examples around us that demonstrate this one-to-one mapping.

Eg - One person has one passport, a passport is associated with a single person.

In database management systems one-to-one mapping is of two types-

1. One-to-one unidirectional
2. One-to-one bidirectional

#### Annotations:

* @OneToOne: Defines a one-to-one association between two entities.
* @JoinColumn: Specifies the foreign key column.
   
### One-to-one unidirectional

In this type of mapping one entity has a property or a column that references to a property or a column in the target entity. 

### One-to-one bidirectional

In one-to-one bidirectional relationship, there are corresponding fields of persistence capable class type on both sides of the relationship. The field type is the type of the persistence capable class on the other side.

In the relational model, there is a foreign key on one of the sides. There must be a unique constraint for the foreign key column.

----

### What is one-to-many mapping?

A one-to-many relationship is a relationship where one entity is related to multiple instances of another entity.

In database management systems one-to-many mapping is of two types-

1. One-to-many unidirectional
2. One-to-many bidirectional

#### Annotations:

* @OneToMany: Defines a one-to-many association.
* @JoinColumn: Specifies the foreign key column.

### One-to-many unidirectional

In this type of association, only the source entity has a relationship field that refers to the target entity. We can navigate this type of association from one side.

### One-to-many bidirectional

In this type of association, each entity (i.e. source and target) has a relationship field that refers to each other. We can navigate this type of association from both sides.

----

### What is Many-to-Many Mapping ?

Many-To-Many relationship exists when two entities are linked in such a way that one entity has many (collections) of the other entity and vice versa. 

Example : Consider the relationship between a student and a teacher. Students are taught by many Teachers, and each Teacher has a class of many Students.

#### Annotations:

* @ManyToMany: Defines a many-to-many association.
* @JoinTable: Specifies the join table.



-----
## How To Perform the Mapping ??
##### 1st Step 
Create a Maven Project

** How to create Maven Project **

* Go to file 
* New 
* Select Maven Project 
* Check the Simple project 
* Give file location 
* Click on Next 
* Give GroupId which is package name 
* Give ArtifactId which is Project Name 
* Finish

*If got any error in the Maven Project*

* Right click on the Maven Project 
* Click on Maven 
* Update 
* Check the checkbox of force update
* Next

##### 2nd Step

Add the Persistence code in the pom.xml file within dependencies tag.

** How to add the persistence code **

* Search [Maven Repository](https://mvnrepository.com/) 
* Then search for **Mysql Connector** and click on the result with high usages 
* Click on the version with high usage 
* Copy the dependency codes 
* Add to the pom.xml file.
* Then search for **Hibernate core** and click on the result with high usages 
* Click on the version with high usage 
* Copy the dependency codes 
* Add to the pom.xml file.

		<dependencies>
	  		<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
			<dependency>
			    <groupId>mysql</groupId>
			    <artifactId>mysql-connector-java</artifactId>
			    <version>8.0.28</version>
			</dependency>
			<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
			<dependency>
			    <groupId>org.hibernate</groupId>
			    <artifactId>hibernate-core</artifactId>
			    <version>5.6.15.Final</version>
			</dependency>
  		</dependencies>
  
  ##### 3rd Step

* Create a folder inside the subdirectory of src/main/resources named **'META-INF'**.
* Create a file inside that folder named **'persistence.xml'**.
* Add these persistence code written down in that file with proper table name,path name, password.


	 	<?xml version="1.0" encoding="UTF-8"?><persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
	  http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd" version="2.1">
		<persistence-unit name="Dev">
		<provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
		<shared-cache-mode>ENABLE_SELECTIVE</shared-cache-mode>      <!-- for caching -->  
		<properties>
			<property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
			<property name="javax.persistence.jdbc.url"  value="jdbc:mysql://localhost:3306/schema_name" />
			<property name="javax.persistence.jdbc.user" value="user_name" />
			<property name="javax.persistence.jdbc.password" value="password" />
			<property name="hibernate.show_sql" value="true" />
			<property name="hibernate.hbm2ddl.auto" value="update" />
			<property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect"/>
		</properties>
		</persistence-unit>
		</persistence>
