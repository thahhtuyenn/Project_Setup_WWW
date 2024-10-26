compileOnly('jakarta.servlet:jakarta.servlet-api:6.0.0')
  implementation 'org.jboss.weld.servlet:weld-servlet-core:5.1.1.Final'
  testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")

  // https://mvnrepository.com/artifact/org.projectlombok/lombok
  compileOnly 'org.projectlombok:lombok:1.18.24'
  annotationProcessor 'org.projectlombok:lombok:1.18.24'

  // https://mvnrepository.com/artifact/org.mariadb.jdbc/mariadb-java-client
  implementation 'org.mariadb.jdbc:mariadb-java-client:3.4.1'

  // JSP
  implementation 'jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:2.0.0'
  implementation 'org.glassfish.web:jakarta.servlet.jsp.jstl:2.0.0'

  // https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-core
  implementation 'org.hibernate.orm:hibernate-core:6.6.0.Final'



### persistence
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.2"
             xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd">
    <persistence-unit name="LeDonChung MariaDB">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        <properties>
            <!-- Thay đổi port và tên database-->
            <property name="jakarta.persistence.jdbc.url"
                      value="jdbc:mariadb://localhost:3306/ledonchung" />
            <property
                    name="jakarta.persistence.jdbc.user" value="root" />
            <property
                    name="jakarta.persistence.jdbc.password"
                    value="sapassword" />
            <property
                    name="jakarta.persistence.jdbc.driver"
                    value="org.mariadb.jdbc.Driver" />

            <property
                    name="jakarta.persistence.jdbc.dialect"
                    value="org.hibernate.dialect.MariaDBDialect" />

            <property
                    name="hibernate.show_sql" value="true" />
            <property
                    name="hibernate.format_sql" value="true" />
            <property
                    name="hibernate.hbm2ddl.auto" value="update" />
        </properties>
    </persistence-unit>

</persistence>



### context

<Context>
  <Resource name="LeDonChungMariaDB"
            auth="Container"
            type="javax.sql.DataSource"
            maxTotal="100"
            maxIdle="30"
            maxWaitMillis="10000"
            username="root"
            password="sapassword"
            driverClassName="org.mariadb.jdbc.Driver"
            url="jdbc:mariadb://localhost:3306/LeDonChung"
            factory="org.apache.tomcat.jdbc.pool.DataSourceFactory"/>

  <Resource name="BeanManager" auth="Container"
            type="jakarta.enterprise.inject.spi.BeanManager"
            factory="org.jboss.weld.resources.ManagerObjectFactory"/>
</Context>



### index

<%@ page language="java" contentType="text/html;charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<%
  response.sendRedirect(request.getContextPath() + "/home");
%>
<body>
</body>
</html>