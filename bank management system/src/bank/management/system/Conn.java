
package bank.management.system;
import java.sql.*;
//Register the driver
//create connection
//Create Statement
//Execute query
//close conection
public class Conn {
    
   static Connection c;
   Statement s;
   /*
   Two instance variables are defined: 
   c of type Connection to hold the database connection and s of type Statement to hold a statement 
   object that will be used to execute SQL queries.
   */
    public Conn(){
    //Mysql is a external entity so error can occur in run time
    //so using exceptional handling
    try{
        //Register the driver
        //Class.forName(com.mysql.cj.jdbc.Driver);
        c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","upayan05");
        //Create Statement
        s=c.createStatement();
    }catch(Exception e){
        System.out.println(e);
    }
    
    }
}/*
 the DriverManager.getConnection() method is used to establish a connection to a MySQL database. 
breaking down the parameters being passed to this method:

"jdbc:mysql:///bankmanagementsystem": This is the JDBC URL that specifies the protocol (jdbc:mysql:) and the database URL (//hostname/database). 
In this case, the database name is bankmanagementsystem. Note that there's no hostname provided, so the connection will be made to the local machine.

"root": This is the username used to authenticate with the database. In this case, "root" is used, which is a common username for administrative access.

"upayan05": This is the password associated with the provided username. It's used for authentication.

The DriverManager.getConnection() method returns a Connection object (c in this case), which represents the established connection to the database. 
This connection can be used to interact with the database.
*/

/*
After successfully establishing the connection, the code creates a Statement object (s) using the createStatement() method of the Connection class.
The Statement object is used to execute SQL queries against the database.

With this Statement object, you can use methods like executeQuery(), executeUpdate(),
and others to interact with the database by sending SQL queries and receiving results.
*/
