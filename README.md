# Mapping In Hibernet

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
