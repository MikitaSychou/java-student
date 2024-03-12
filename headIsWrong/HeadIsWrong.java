package headIsWrong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*
* You're at the zoo... all the meerkats look weird.
*  Something has gone terribly wrong - someone has gone and switched their heads and tails around!

Save the animals by switching them back.
* You will be given an array which will have three values (tail, body, head).
* It is your job to re-arrange the array so that the animal is the right way round (head, body, tail).

Same goes for all the other arrays/lists that you will get in the tests:
*  you have to change the element positions with the same exact logics

Simples!
*
* */

public class HeadIsWrong {
    public static void main(String[] args) {
        String[] arrStr = fixTheMeerkat(new String[]{ "bottom", "middle", "top" });
        System.out.println(Arrays.toString(arrStr));
    }

    public static String[] fixTheMeerkat(String[] arr) {
        List<String> strList = new ArrayList<>();
        for (int i = arr.length - 1; i >=0; i--) {
            strList.add(arr[i]);
        }
        return strList.toArray(arr);
    }
}
