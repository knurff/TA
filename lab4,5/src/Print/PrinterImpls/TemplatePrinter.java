package Print.PrinterImpls;

import Print.Printer;
import com.company.SortTimePrintingStrategy.SortMethod;

import java.util.Arrays;

public class TemplatePrinter implements Printer {
    @Override
     public void printArr(int[] arr, SortMethod sortMethod) {
        String type = String.valueOf(sortMethod.getClass());
        String[] typeArray = type.split("[ .]");
        System.out.println(typeArray[typeArray.length - 1] + " " + arr.length +
                "-length sorted array example: " + Arrays.toString(arr));
    }
}
