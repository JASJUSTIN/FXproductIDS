package TestCases;

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;

public class mixarray {


    public static void main(String[] args) {

        Object[] object = {"A",12 ,45, 89, 90};

        Object[] TICKET={"B",12,34,35,56};

        List<Object> list = new ArrayList<Object>();
        list.add("A");
        list.add(12);
        list.add(45);
        list.add(89);

        System.out.println(list);


        for (int i=0;i<object.length;i++)
        {
            for (int j=0;j< TICKET.length;j++)
            {
                if (object[i]==TICKET[j])
                {

                    System.out.println("JESUS SAME NUMBER IS "+object[i]);
                }



            }




        }


    }







}


//CONDITIONS
// LETTER AND 4 NUMBERT=S  Rs. 73,630,932.40
//4 Numbers Correct       Rs. 1,000,000
// 3 numbers and letter 100000
//any 3 number correct 2000
//letter and 2 number 1000
// any 2 numbers 100
// letter and any number 40
// any number 20
// letter correct 20

