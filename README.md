wildfly_mysql_driver
====================

Working example of a maven based java ee project for wildfly 8 with db driver and datasource autodeploy.
This demonstrates how to build an application which doesn't require you to manually deploy db drivers
or configure datasources by hand.

All you should have to do is adjusting these params in the head of pom.xml:

<mysql.username>DB_USER</mysql.username>
<mysql.password>PASSWORD_DB_USER</mysql.password>
<db.jdbc.url>jdbc:mysql://127.0.0.1:3306/DB_SCHEMA_NAME</db.jdbc.url>

Feel free to clone it to start your own java ee application.


happy coding,
volker
