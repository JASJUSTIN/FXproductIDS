package TestCases;

import java.lang.reflect.Array;
import java.util.Arrays;

public class arrayreverse {
    public static void main(String[] args) {


        int numbers[]=new int []{23,45,67,98,12};



        //print original array
        for (int i=0;i<numbers.length;i++)
        {

            // print in same line
          //  System.out.println(Arrays.toString(numbers));
            System.out.println(numbers[i]+" ");
        }
      // System.out.println();

        System.out.println("jESUS aRRAY IN REVERSE");
        for (int i=numbers.length-1;i>=0;i--)
        {
            if ((numbers[i]%2!=0))
            {
                //printing odd numbers
                System.out.println(numbers[i]);
            }
           else
            {
                System.out.println(numbers[i]);
            }
        }


    }

}
