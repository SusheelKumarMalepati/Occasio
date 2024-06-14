Dependencies:
1.lombok
2.mysql driver
3.spring jpa
4.spring web
5.springboot dev tools
add dependency in pom.xml
<dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-jasper</artifactId>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>jstl</artifactId>
    </dependency>

edit application properties with mysql connection and jsp access
create folder webapp under main
folder WEB-INF under webapp
folder view under WEB-INF
in view we create jsp files

add index.jsp

create entity, repository, service, controller packages
User Crdentials for login