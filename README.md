# Act-Test
Customers management Telefónica

<b>#Requirement</b>
<div style="text-align: justify;text-justify: inter-word;">
Se requiere un sistema para el registro de clientes, donde se guarde los datos generales y permita tener mas de una direccion o documento de identificacion, la cantidad de tipo documentos y direcciones quedaria a discrecion de quien ingresa la informacion. Se requiere - Pantalla donde permita la administracion de los clientes. - Servicio para consumir desde aplicaciones externas. - Auditoria en los cambios que se realicen sobre la informacion de los clientes. Reporte de los clientes en archivo de texto csv, txt generado desde un script. Consideraciones - Puede utilizar cualquier base de datos - Puede utilizar cualquier framework - Puede utilizar cualquier lenguaje de programacion. - Se requiere que el proyecto lo suban a un repositorio git publico.</div>

<br/>
<b>#Solution </b>
<br/>

<b>#Please follow this instruction to install:</b>

1. Download STS from: https://spring.io/tools
2. Download Tomcat 9 from: https://tomcat.apache.org/download-90.cgi 
3. Add server tomcat to STS
4. Git clone on any chapter: git clone https://github.com/chavezvigil/act-test.git 
5. Open proyect from STS
6. Right click on the proyect, then maven, then update proyect
7. Install mysql using the command: sudo apt update, sudo apt install mysql-server
8. Connect to mysql instance to create database
9. Create database using the command: CREATE DATABASE act;

![image](https://user-images.githubusercontent.com/2258381/146981348-54015375-5969-49ee-980b-62ef0d4bf795.png)

10. Run proyect on Tomcat

![image](https://user-images.githubusercontent.com/2258381/146980100-d5696389-e8b5-4d58-b00b-0d4ff7522276.png)

11. Spring framework will generate database based on the created entities (Tables column order is made by spring data framework, which will order by name ascending A-Z)

<b>#Please follow this instruction to do the unit test</b>

1. Find scr/test/java
2. Right click on test unit
3. Run as JUnit Test

![image](https://user-images.githubusercontent.com/2258381/146981812-f006874f-332b-4374-a751-a23f71a18c51.png)

4. Spring framework will insert data in database (Catalogs as "tipo persona" and "Tipo documentos")
![image](https://user-images.githubusercontent.com/2258381/146685553-264ecdaf-c1c1-4fda-8a7b-a950da42b5c6.png)

<b>#Please follow this instruction to management database:</b>

1. Download DBeaver community or any software to management databases: https://dbeaver.io/download/
2. Database design

![image](https://user-images.githubusercontent.com/2258381/146981086-c249a27d-f6fb-4477-b971-a9c848935d13.png)

3. SQL from DBeaver

![image](https://user-images.githubusercontent.com/2258381/146680912-2f80d9ce-ef96-4501-81cd-ce8f6501e8af.png)

<b>#Please follow this instruction to test the endpoint:</b>

1. Download insomnia or any software to request for web services restfull: https://insomnia.rest/download
2. Then create new request as "get request", then put url: http://localhost:8080/act/clientes

![image](https://user-images.githubusercontent.com/2258381/146801475-3ca3338d-deb7-4a70-9945-c02a5d9cfdaa.png)



