package utils;

import org.testng.annotations.Test;

import java.sql.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ExcelReader;
import utils.PropertyFileReader;

import java.sql.*;
import java.util.ArrayList;


public class FINALDBidVERIFY {



    public static class Dbconnection {

        PropertyFileReader prop=new PropertyFileReader();
        String DBENV=prop.getProperty("config","DbEnv");




        public   void  DBCONNECT(String ID) throws  ClassNotFoundException, SQLException {

            ExcelReader reader=new ExcelReader("src/test/resources/FXIDSDataSheet.xlsx");

            String username =reader.getCellData("DBDetails","username\n",2);
            String password =reader.getCellData("DBDetails","password\n",2);
            String dbUrl="jdbc:sqlserver://fortuneclouddb.database.windows.net;databasename=QA1";

            jdbc:sqlserver://fortuneclouddb.database.windows.net;databasename=QA1

            try {
                Connection connection = DriverManager.getConnection(dbUrl,username,password);
                System.out.println("Connected to microsoft sql server ");

               // String ID="'6201'";
                //"select FirstName from Guest where GuestID='6200';";
                String queryANU = "select FirstName from Guest where GuestID="+ID+";";
                String querySTE = "select FirstName from Guest where GuestID='6200';";

                String QUERY2= "select  SyncFCLTransDateTime\n" +
                        "from SSO_UserProperties\n" +
                        "WHERE ID='40563'";

                Statement stmt = connection.createStatement();
                ResultSet rs= stmt.executeQuery(queryANU);

                // While Loop to iterate through all data and print results
                while (rs.next()){
                    String Companyid = rs.getString(1);
                    // String Companyname = rs.getString(2);

                    // System. out.println(Companyid+ Companyname );

                    System.out.println(rs.getString(1));
                    // System.out.println(rs.getString(1));
                    String SERVERNAME="fortuneclouddb.database.windows.net";
                    String DBNAME="QA1";
                    String DBUNAME=username;
                    String PASSWORD=password;

                    String dbUrl1="jdbc:sqlserver://fortuneclouddb.database.windows.net;databasename=QA1";

                    String DBNEWURL="jdbc:sqlserver://"+SERVERNAME+";databasename=+DBNAME+";

                    //   System.out.println(DBNEWURL);

                    if(rs.wasNull())
                    {
                        System.out.println("ITS NULL");
                    }


                }

                //connection db connection
                connection.close();
            }
            catch (SQLException e)
            {
                System.out.println("oops there is error-please check username");
                e.printStackTrace();
            }

        }


        public static void main(String[] args) throws SQLException, ClassNotFoundException {
            Dbconnection dbconnection=new Dbconnection();
            dbconnection.DBCONNECT("6200");


        }

    }







}
