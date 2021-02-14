##### What program it is?

this is program about employess CRUD using jdbctemplate and thymeleaf. theres couple of depedency that i use in this program : 

1. mysql connector = for the database
2. jdbctemplate = for the sql query
3. thymeleaf = for html view

and other depedency that you can see in pom.xml



##### How to use

1. make mysql database and name it as "hospital" (without quote)

2. make table name "employeess" (without quote)

3. make 5 field as follow :

   id, int(10), primary key

   name, varchar(100)

   jabatan, varchar(100)

   golongan, int(5)

   gaji, float

4. now go to application propertise,  and change data url database, username, password sama as your mysql setting



##### how to use(other way)

1. i'm include sql file named hospital.sql in same place as readme.md
2. you can import it to your mysql database

