
package createcustomerordersderbydatabase;

import java.sql.*;


public class CreateCustomerOrdersDerbyDatabase 
{

    //MySQL is a Database Management System
    //SQL - Structured Query Language
    
    public static void main(String[] args)
    {
        //This whole code is to form the URL.
        String dbProtocol = "jdbc:derby:"; //Java Database Connectivity
        String dbDirectory = "E:/CIS3306 - Business Programming II/CreateCustomerOrdersDerbyDatabase/";
        String dbName = "CustomerOrders";
        String connectionCreateURL = dbProtocol + dbDirectory + dbName + ";create=true";
        String shutDownURL = dbProtocol + ";shutdown=true";
        
        //Create Statement for the Customer Table
        String createStatementCustomer = "CREATE TABLE Customer "
                                        +"(CustomerNumber INTEGER PRIMARY KEY, "
                                        +"CustomerFirstName VARCHAR(20), "
                                        +"CustomerLastName VARCHAR(20))";
        
        //Create Statement for the Item Table
        String createStatementItem = "CREATE TABLE Item "
                                    +"(CustomerNumber INTEGER, "
                                    +"ItemName VARCHAR(20), "
                                    +"ItemCost INTEGER)";
        
        try
        {
            //Connects to Database
            Connection connection1 = DriverManager.getConnection(connectionCreateURL, "Admin", "MuCis");
            //Object to process SQL statements
            Statement statement1 = connection1.createStatement();
            
            statement1.execute(createStatementCustomer);
            statement1.execute(createStatementItem);
            
            //Shuts down database
            DriverManager.getConnection(shutDownURL);
        }
        catch(SQLException e)
        {
            System.out.println(e.toString());
        }
    }
    
}
