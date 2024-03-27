import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Runner {

    // Smallest value of an array
    //    Write a function that can return the smallest value of an array or the index of that value.
    //    The function's 2nd parameter will tell whether it should return the value or the index.
    //
    //    Assume the first parameter will always be an array filled with at least 1 number and no duplicates.
    //    Assume the second parameter will be a string holding one of two values: 'value' and 'index'.
    //
    //    Arrays.findSmallest(new int[]{1,2,3,4,5}, 'value') // => 1
    //    Arrays.findSmallest(new int[]{1,2,3,4,5}, 'index') // => 0git

    public static void main(String[] args) {
        int result = findSmallest(new int[]{1,2,3,4,5}, "index");
        System.out.println(result);
    }

    public static int findSmallest( final int[] numbers, String toReturn ) {
       List<Integer> al = IntStream.of(numbers)
               .boxed()
               .collect(Collectors.toList());
       int minVal = Collections.min(al);

        if (toReturn == "value"){
            return minVal;

        } else {
            return al.indexOf(minVal);
        }
    }
}
