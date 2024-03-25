import java.util.Arrays;

public class SumOfSingles {

    // Sum of array singles
    // In this Kata, you will be given an array of numbers
    // in which two numbers occur once and the rest occur only twice.
    // Your task will be to return the sum of the numbers that occur only once.
    //For example, repeats([4,5,7,5,4,8]) = 15 because only the numbers 7 and 8 occur once,
    // and their sum is 15. Every other number occurs twice.

    public static void main(String[] args) {
        int result = repeats(new int[]{4,5,7,5,4,8});
        System.out.println(result);
    }

    public static int repeats(int [] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
        {
            int count = 0;
            for (int j = 0; j < arr.length; j++)
                if (arr[i] == arr[j])
                    count++;

            if (count == 1)
                sum+=arr[i];
        }
        return sum;
    }
}
