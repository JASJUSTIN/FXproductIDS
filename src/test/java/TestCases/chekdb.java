package TestCases;

import com.sun.jdi.PathSearchingVirtualMachine;
import org.testng.annotations.Test;
import utils.DBconnectionUtils;
import utils.EnvironmentUtils;
import utils.PropertyFileReader;

import java.sql.*;

public class chekdb {


    public static void main(String[] args) {
        chekdb chekdb=new chekdb();
        String SQL="select FirstName from Guest where GuestID= ";
        String IID="6200";
        String MERGE=SQL+IID;
       System.out.println(MERGE);

    }
        public String Dbconnect(String sql,String DBID)
        {
            String ANSWER="";




            DBconnectionUtils dBconnectionUtils=new DBconnectionUtils();
            String DBURL=dBconnectionUtils.dbpath("QA1");

            // String dbUrl="jdbc:sqlserver://fortuneclouddb.database.windows.net;databasename=QA1";

            try {
                Connection connection = DriverManager.getConnection(DBURL,"fortunecloudadmin","374ydr962y4_swHh");
                System.out.println("Connected to microsoft sql server ");

          /*  String query = "SELECT CompanyID,CompanyName\n" +
                    "FROM Company\n" +
                    "WHERE CompanyName='Makemytrip.Com' ;";

            String QUERY2null= "select  SyncFCLTransDateTime\n" +
                    "from SSO_UserProperties\n" +
                    "WHERE ID='40563'";*/

                String query_only1=sql;

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





