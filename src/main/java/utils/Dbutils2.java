package utils;

import java.sql.*;

public class Dbutils2{

    ExcelReader reader=new ExcelReader("src/test/resources/FXIDSDataSheet.xlsx");
    String username =reader.getCellData("DBDetails","username\n",2);
    String password =reader.getCellData("DBDetails","password\n",2);

    String dbUrl="jdbc:sqlserver://fortuneclouddb.database.windows.net;databasename=QA1";


    PropertyFileReader prop=new PropertyFileReader();
    String DBENV=prop.getProperty("config","DbEnv");

   public void DBenv(String dbenvironment)
   {

       if (dbenvironment.contains("QA1"))
       {
           Dbutils2 dbutils2=new Dbutils2();
           //dbutils2.Dbconnect()
       }

   }




    public String Dbconnect(String sql)
    {
        String ANSWER="";




        try {
            Connection connection = DriverManager.getConnection(dbUrl,username,password);
            System.out.println("Connected to microsoft sql server ");

            String query_only1=sql;


            Statement stmt = connection.createStatement();
            ResultSet rs= stmt.executeQuery(query_only1);

            // While Loop to iterate through all data and print results
            while (rs.next()){
                String Companyid = rs.getString(1);
                ANSWER = Companyid;


                if(rs.wasNull())
                {
                    ANSWER="iTS NULL";

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

        return ANSWER;
    }

}


