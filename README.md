# Act-Test
Administración de clientes telefónica

#Please follow this instruction to install:

1. Download STS from: https://spring.io/tools
2. Download Tomcat 9 from: https://tomcat.apache.org/download-90.cgi 
3. Add server tomcat to STS
4. Git clone on any chapter: git clone https://github.com/chavezvigil/act-test.git 
5. Open proyect from STS
6. Right click on the proyect, then maven, then update proyect
7. Install mysql using the command: sudo apt update, sudo apt install mysql-server
8. Connect to mysql instance to create database
9. Create database using the command: CREATE DATABASE act;

![image](https://user-images.githubusercontent.com/2258381/146680689-dc59d512-c192-4737-ab97-43cf50f68151.png)

10. Run proyect on Tomcat

![image](https://user-images.githubusercontent.com/2258381/146679846-4766fbc6-fcb0-48b8-b380-09224166c242.png)

11. Spring framework will generate database based on the created entities

#Please follow this instruction to test the endpoint:

1. Download insomnia or any software to request for web services restfull: https://insomnia.rest/download
2. Then create new request as "get request, then put url: http://localhost:8080/act/clientes

![image](https://user-images.githubusercontent.com/2258381/146679679-b4cf77f3-0fa0-4ffb-9bc1-6877010c9328.png)


