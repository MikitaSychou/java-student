package simpleTasks;

import java.util.*;

public class SimpleTasks {
    public static void main(String[] args) {
        int intResult = stringToNumber("1234");
        System.out.println(intResult);

        String strResult = numberToString(123);
        System.out.println(strResult);

        double doubleResult = sum(new double[] {1, 5.2, 4, 0, -1});
        System.out.println(doubleResult);
    }

    // Convert a String to a Number!
    public static int stringToNumber(String str) {
        return Integer.valueOf(str);
    }

    // Convert a Number to a String!

    public static String numberToString(int num) {
        return Integer.toString(num);
    }

    // Sum Arrays

    public static double sum(double[] numbers) {
        return Arrays.stream(numbers).reduce(0, Double::sum);
    }
}
