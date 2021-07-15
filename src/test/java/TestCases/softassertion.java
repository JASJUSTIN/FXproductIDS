package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.DBconnectionUtils;
import utils.ExcelReader;

import java.sql.SQLException;

public class softassertion {

    SoftAssert softAssert = new SoftAssert();
    ExcelReader reader = new ExcelReader("src/test/resources/FXReservationMasterDataFile.xlsx");
    // public String NAME;


    @Test
    public void testassertion() {

        //  reader.addColumn("Scenarios","jesus");


        System.out.println("open browser");

        //  Assert.assertEquals(true,false);

        softAssert.assertEquals(true, false, "There is error 1 ");


        System.out.println("enter username ");

        System.out.println("enter password ");
        softAssert.assertEquals(true, false, "There is error 2 ");
    }


    @Test
    public void Test2() throws SQLException, ClassNotFoundException {

        Dbconnection db = new Dbconnection();
        //  db.DBCONNECT("40570");

        //  dbtest1 SASA=new dbtest1();
        //  SASA.Dbconnect("40570");

        //    String DATA1= SASA.Dbconnect("40570");
        System.out.println("JUSTIN" + "jesus");


        //  DBconnectionUtils db=new DBconnectionUtils();
        //  String DATA1=  db.Dbconnect("40570");
        //     System.out.println("JUSTIN"+DATA1);


        System.out.println("signin  ");

        System.out.println("validate title ");
        softAssert.assertEquals(true, true, "There is error 3");


        softAssert.assertAll();

        String creditlimit = "2000.00";
        float creditlimitfloat = Float.parseFloat(creditlimit);
        int CreditAmoutInt;
        CreditAmoutInt = Math.round(creditlimitfloat);
        System.out.println("JESUS JUSTIN " + CreditAmoutInt);

        int Ratwintamount = 2000;
        int mealintamount = 50;
        int addonintamount = 0;
        int taxintamount = 608;
        int total = 2658;


        //
        int Calculation = Ratwintamount + mealintamount + addonintamount + taxintamount;

        Assert.assertEquals(total, Calculation);







        String name = "jesus";
        String rev = "";

        for (int i = name.length() - 1; i >= 0; i--) {
            rev = rev + name.charAt(i);

        }

        System.out.println(rev);


        int[] jesusmarks = new int[]{22, 90, 87, 45};
        int temp;

        for (int i = 0; i < jesusmarks.length; i++) {
            for (int j = i; j < jesusmarks.length; j++) {
                if (jesusmarks[i] > jesusmarks[j]) {
                    temp = jesusmarks[i];
                    jesusmarks[i] = jesusmarks[j];
                    jesusmarks[j] = temp;
                    System.out.println(jesusmarks);
                }
            }
        }
        for (int a : jesusmarks) {
            System.out.println(a);
        }


        String[] duplicatename = {"jesus", "mary", "joseph", "anthony", "jesus"};


        for (int i = 0; i < duplicatename.length; i++) {
            for (int j = i + 1; j < duplicatename.length; j++) {
                if (duplicatename[i].equals(duplicatename[j])) {
                    System.out.println("DUPLICATE IS " + duplicatename[i]);
                }
            }
        }


        int[] duplicatenumber = {10, 89, 12, 14, 12};

        for (int i = 0; i < duplicatenumber.length; i++) {
            for (int j = i + 1; j < duplicatenumber.length; j++) {
                if (duplicatenumber[i] == (duplicatenumber[j])) {
                    System.out.println("DUPLICATE IS " + duplicatename[i]);
                }
            }
        }


        reader.setCellData("Scenarios", "jesus", 2, "JESUS");
        reader.setCellData("Scenarios", "jesus", 3, "JESUS");
        reader.setCellData("Scenarios", "jesus", 5, "JESUS");
        reader.setCellData("Scenarios", "jesus", 9, "JESUS");
        reader.setCellData("Scenarios", "jesus", 11, "JESUS");
        reader.setCellData("Scenarios", "jesus", 13, "JESUS");


    }
}



