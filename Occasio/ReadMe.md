Dependencies:
1.lombok
2.mysql driver
3.spring jpa
4.spring web
5.springboot dev tools
add dependency in pom.xml
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui -->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.5.0</version>
</dependency>
<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger2 -->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.5.0</version>
</dependency>
and change the version of parent class to 2.5.2

edit application properties with mysql connection and jsp access
create folder webapp under main
folder WEB-INF under webapp
folder view under WEB-INF
in view we create jsp files

add index.jsp

create entity, repository, service, controller packages
User Crdentials for login
