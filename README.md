wildfly_mysql_driver
====================

Working example of a maven based java ee project for wildfly 8 with db driver and datasource autodeploy.
This demonstrates how to build an application which doesn't require you to manually deploy db drivers
or configure datasources by hand.

All you should have to do is adjusting these params in the head of pom.xml:

&lt;mysql.username&gt;DB_USER&lt;/mysql.username&gt;
&lt;mysql.password&gt;PASSWORD_DB_USER&lt;/mysql.password&gt;
&lt;db.jdbc.url&gt;jdbc:mysql://127.0.0.1:3306/DB_SCHEMA_NAME&lt;/db.jdbc.url&gt;

Feel free to clone it to start your own java ee application.


happy coding,
volker
