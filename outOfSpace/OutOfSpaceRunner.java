import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OutOfSpaceRunner {
    public static void main(String[] args) {
        String[] words = spacey(new String[] {"i", "have", "no", "space"});
        System.out.println(Arrays.toString(words));
    }

    // Kevin is noticing his space run out!
    // Write a function that removes the spaces from
    // the values and returns an array showing the space decreasing.
    //For example, running this function on the array ['i', 'have','no','space']
    // would produce ['i','ihave','ihaveno','ihavenospace']

    public static String[] spacey(String[] array) {

        List<String> res = new ArrayList<>();
        String temp = array[0];

        for(int i = 1; i< array.length+1;i++) {
            res.add(temp);
            if(i < array.length) {
                temp = temp + array[i];
            }
        }
        return res.toArray(array);
    }
}
