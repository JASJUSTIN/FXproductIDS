package TestCases;

import org.testng.annotations.Test;
import utils.ExcelReader;

public class excelsheet_inputs  {

    @Test
    public void testexcel() {

        ExcelReader reader = new ExcelReader("src/test/resources/FXReservationMasterDataFile.xlsx");

        int rows = reader.getRowCount("Createguest");
        int coloumn_number = reader.getColumnCount("Createguest");
        System.out.println(rows);

        for (int i = 0; i <= coloumn_number-1; i++) {
            //  String coloumn = reader.getCellData("Createguest", "Key\n", i);
            //  System.out.println("excel elemrtn is "+coloumn);

            //  int coloumncount=    reader.getColumnCount("Createguest");
            ///  String DATA=reader.getCellData("Createguest","Data 1\n",i);
            // System.out.println("excel elemrtn is "+DATA);

            //  reader.
            // System.out.println("coloumn name is " +coloumn_number);

            String COLOUMTITLE = reader.getCellData("Createguest", i, 1);

            System.out.println("JESUSCOLOUMNTITLE SI" + COLOUMTITLE);

        }
        String NAME="DOG";
if (NAME.equalsIgnoreCase("doG"))
{
    System.out.println("TWO STRING ARE EQUAL");
}
    }

}
