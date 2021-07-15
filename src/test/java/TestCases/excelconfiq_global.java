package TestCases;

import org.testng.annotations.Test;
import utils.ExcelReader;

import java.io.Reader;

public class excelconfiq_global {


    // private static ExcelReader reader;

    ExcelReader reader = new ExcelReader("src/test/resources/FXReservationMasterDataFile.xlsx");
    int rowcountofDblogindetails = reader.getRowCount("DbloginDetails");

    String USERNAME = reader.getCellData("DbloginDetails", "username\n", 2);
    String PASSWORD = reader.getCellData("DbloginDetails", "password\n", 2);

    public  static void main(String[] args) {

        excelconfiq_global excelconfiq_global = new excelconfiq_global();
        ExcelReader reader = new ExcelReader("src/test/resources/FXReservationMasterDataFile.xlsx");
        String Databasename = reader.getCellData("EnvironmentDetails", "Value\n", 6);
        String DBSERVERNAME=excelconfiq_global.Dbservername(Databasename);
        String JESUS = excelconfiq_global.Dbusername(Databasename);
        String JESUSPASSWORD=excelconfiq_global.Dbpassword(Databasename);

        System.out.println("SERVERNAME IS "+DBSERVERNAME);
              System.out.println("USERNAME IS "+JESUS);
        System.out.println("DBPASSWORD IS "+JESUSPASSWORD);
      //  System.out.println("JESUS" + JESUS);

        //  System.out.println();
     //   System.out.println(JESUS);
      //  String[] parts = JESUS.split(" ");
     //   String part1 = parts[0];
     //   String part2 = parts[1];
      //  System.out.println(part1);
      //  System.out.println(part2);




    }

    public String Dbservername(String NAMEOFDB) {

        // excelconfiq_global excelconfiq_global = new excelconfiq_global();
        //  String JESUS = excelconfiq_global.Dbname(Databasename);

        String ANSWER2="";


        // System.out.println(USERNAME);
        // System.out.println(PASSWORD);

        for (int i = 2; i <= rowcountofDblogindetails; i++) {
            String dBNAMES = reader.getCellData("DbloginDetails", "Dbname\n", i);
            if (dBNAMES.contains(NAMEOFDB)) {


                String servername = reader.getCellData("DbloginDetails", "Servername\n", i);
                // String PASSWORD = reader.getCellData("DbloginDetails", "password\n", i);


                //  System.out.println("JESUS UNAME AND PASSWORD IS" + "" + USERNAME + "" + PASSWORD);
                ANSWER2 = servername;
                //  ANSWER3=PASSWORD;
                break;

            }
        }
        return ANSWER2;
    }




    public String Dbusername(String NAMEOFDB) {

       // excelconfiq_global excelconfiq_global = new excelconfiq_global();
      //  String JESUS = excelconfiq_global.Dbname(Databasename);
        String ANSWER1 = "";
        String ANSWER3="";


        // System.out.println(USERNAME);
        // System.out.println(PASSWORD);

        for (int i = 2; i <= rowcountofDblogindetails; i++) {
            String dBNAMES = reader.getCellData("DbloginDetails", "Dbname\n", i);
            if (dBNAMES.contains(NAMEOFDB)) {


                String USERNAME = reader.getCellData("DbloginDetails", "username\n", i);
               // String PASSWORD = reader.getCellData("DbloginDetails", "password\n", i);


              //  System.out.println("JESUS UNAME AND PASSWORD IS" + "" + USERNAME + "" + PASSWORD);
                ANSWER1 = USERNAME;
              //  ANSWER3=PASSWORD;
                break;

            }
        }
        return ANSWER1;
    }


    public String Dbpassword(String NAMEOFDB) {

        // excelconfiq_global excelconfiq_global = new excelconfiq_global();
        //  String JESUS = excelconfiq_global.Dbname(Databasename);

        String ANSWER3="";


        // System.out.println(USERNAME);
        // System.out.println(PASSWORD);

        for (int i = 2; i <= rowcountofDblogindetails; i++) {
            String dBNAMES = reader.getCellData("DbloginDetails", "Dbname\n", i);
            if (dBNAMES.contains(NAMEOFDB)) {


               // String USERNAME = reader.getCellData("DbloginDetails", "username\n", i);
                String PASSWORD = reader.getCellData("DbloginDetails", "password\n", i);


                //  System.out.println("JESUS UNAME AND PASSWORD IS" + "" + USERNAME + "" + PASSWORD);
               // ANSWER1 = USERNAME;
                 ANSWER3=PASSWORD;
                break;

            }
        }
        return ANSWER3;
    }













    //   public String dbunameandpassword(String databasename)
    // {
    //    reader.setCellData("")
    //}


   /* @Test
    public void testName() {

        //   System.out.println(Databasename);
        //  System.out.println(rowcountofDblogindetails);


        for (int i = 2; i <= rowcountofDblogindetails; i++) {
            String dBNAMES = reader.getCellData("DbloginDetails", "Dbname\n", i);
            //  System.out.println(dBNAMES);
*/
        }


