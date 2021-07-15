package utils;

public class EnvironmentUtils {

    ExcelReader reader = new ExcelReader("src/test/resources/FXReservationMasterDataFile.xlsx");

    int rowcountofDblogindetails = reader.getRowCount("DbloginDetails");

    public String Dbservername(String NAMEOFDB) {

        String Dbservername="";

        for (int i = 2; i <= rowcountofDblogindetails; i++) {

            String dBNAMES = reader.getCellData("DbloginDetails", "Dbname\n", i);
            if (dBNAMES.contains(NAMEOFDB)) {
                String servername = reader.getCellData("DbloginDetails", "Servername\n", i);
                Dbservername = servername;
                break;

            }
        }
        return Dbservername;
    }


    public String Dbusername(String NAMEOFDB) {

        String Dbusername = "";

        for (int i = 2; i <= rowcountofDblogindetails; i++) {
            String dBNAMES = reader.getCellData("DbloginDetails", "Dbname\n", i);
            if (dBNAMES.contains(NAMEOFDB))
            {
                String dbusername = reader.getCellData("DbloginDetails", "username\n", i);
                Dbusername = dbusername;
                break;

            }
        }
        return Dbusername;
    }


    public String Dbpassword(String NAMEOFDB) {

        String dbpassword="";

        for (int i = 2; i <= rowcountofDblogindetails; i++)
        {
            String dBNAMES = reader.getCellData("DbloginDetails", "Dbname\n", i);
            if (dBNAMES.contains(NAMEOFDB)) {
                String databasepassword = reader.getCellData("DbloginDetails", "password\n", i);
                dbpassword=databasepassword;
                break;

            }
        }
        return dbpassword;
    }











}
