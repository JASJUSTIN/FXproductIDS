package utils;

import com.mongodb.DB;

import java.sql.*;

public class DBconnectionUtils {


    PropertyFileReader prop=new PropertyFileReader();
    String DBENV=prop.getProperty("config","DbEnv");
    ExcelReader reader=new  ExcelReader("src/test/resources/FXReservationMasterDataFile.xlsx");
    String Databasenamefromexcel = reader.getCellData("EnvironmentDetails", "Value\n", 6);
    EnvironmentUtils environmentUtils=new EnvironmentUtils();
    String servernameofdatabase=environmentUtils.Dbservername(Databasenamefromexcel);
    String Usernameofdatabase  =environmentUtils.Dbusername(Databasenamefromexcel);
    String Passwordofdatabase  =environmentUtils.Dbpassword(Databasenamefromexcel);


    public String dbpath(String dbnamefromexcel)
    {
        String DBURL="";
        String DBNEWURL="jdbc:sqlserver://"+servernameofdatabase+";databasename="+dbnamefromexcel+"";
        DBURL=DBNEWURL;
        return DBURL;
    }







    public String Dbconnect(String sql,String DBId)
    {
        String ANSWER="";




        DBconnectionUtils dBconnectionUtils=new DBconnectionUtils();
        String DBURL=dBconnectionUtils.dbpath(Databasenamefromexcel);

       // String dbUrl="jdbc:sqlserver://fortuneclouddb.database.windows.net;databasename=QA1";

        try {
            Connection connection = DriverManager.getConnection(DBURL,Usernameofdatabase,Passwordofdatabase);
            System.out.println("Connected to microsoft sql server ");

          /*  String query = "SELECT CompanyID,CompanyName\n" +
                    "FROM Company\n" +
                    "WHERE CompanyName='Makemytrip.Com' ;";

            String QUERY2null= "select  SyncFCLTransDateTime\n" +
                    "from SSO_UserProperties\n" +
                    "WHERE ID='40563'";*/

             String query_only1=sql+DBId;

       String FIRSTNAME="select FirstName from Guest\n" +
               "where GuestID='6200'";



         //   String query_only="select LoginID from SSO_UserProperties\n" +
                    //"WHERE ID= '"+data+"'";


            Statement stmt = connection.createStatement();
            ResultSet rs= stmt.executeQuery(query_only1);

            // While Loop to iterate through all data and print results
            while (rs.next()){
                String Companyid = rs.getString(1);
                //String Companyname = rs.getString(2);

                //System. out.println(Companyid);
                ANSWER = Companyid;

                // System.out.println(rs.getString(1));
                //    System.out.println(rs.getString(1));
                if(rs.wasNull())
                {
                    // System.out.println("ITS NULL");
                    ANSWER="iTS NULL";


                }


            }

            //connection db connection
            connection.close();
        }
        catch (SQLException e)
        {
            System.out.println("oops there is error-please check username/password");
            e.printStackTrace();
        }

        return ANSWER;
    }

}


