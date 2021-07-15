package TestCases;

import org.testng.annotations.Test;
import utils.ExcelReader;

public class excel {

    ExcelReader reader=new ExcelReader("src/test/resources/FXReservationMasterDataFile.xlsx");



    String title=reader.getCellData("CreateGuestforSC","Title\n",2);
    String fname=reader.getCellData("CreateGuestforSC","Firstname\n",2);


    @Test
    public void testName() {

        System.out.println(title);
        System.out.println(fname);

    }
}
