**_<=== This application is a simple CRUD user management system ===>_<br><br>**

**Database installation guide**
1. Download and install the latest available version of MySql Database.<br>
Download link: https://dev.mysql.com/downloads/

2. After installation, you must execute the commands in the 'Mysql Command Line Client' in this order:<br>
1.1. `CREATE DATABASE users_db;`<br>
1.2. `USE users_db;`<br>
1.3. `CREATE TABLE users
(user_id INT AUTO_INCREMENT PRIMARY KEY, 
fname VARCHAR(50) NOT NULL, 
lname VARCHAR(50) NOT NULL, 
email VARCHAR(50) NOT NULL);`<br><br>

**Application installation guide**
1. Download and unzip Apache Tomcat Server 9 (or later).<br>
Download link: https://tomcat.apache.org/download-90.cgi

2. Download and unzip the latest available version of Apache Maven.<br>
Download link: https://maven.apache.org/download.cgi
_<p>\*on windows you need to add maven to the path variable: 
https://stackoverflow.com/questions/45119595/how-to-add-maven-to-the-path-variable<p>_

3. Clone the JdbcWebApp project from the GitHub repository.<br>

4. Using any text editor, open the file `JdbcWebApp/src/main/java/connection/MySqlJdbcConnection.java` 
and override the variables<br> 
`private static final String URL = "jdbc:mysql://localhost:3306/users_db?ServerTimezone=UTC";`<br>
`private static final String USER = "root";`<br>
`private static final String PASSWORD = "root";`<br>
to your values.

5. Run the command line or terminal in the root of the project and type the command `mvn package`, 
then go to the folder `target` formed by the maven and copy the file `JdbcWebApp-1.0-SNAPSHOT.war` 
into the folder `apache-tomcat/webapps` from there.<br>

6. Run Tomcat Server using `apache-tomcat/bin/startup.bat` or `apache-tomcat/bin/startup.sh` 
and in the browser, go to `localhost:8080/users`.


