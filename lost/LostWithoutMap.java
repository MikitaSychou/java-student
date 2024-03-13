package lost;

import java.util.Arrays;

public class LostWithoutMap {
    public static void main(String[] args) {
        int arrDoubled[] = map(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(arrDoubled));
    }

        public static int[] map(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            arr[i] += arr[i];
        }
        return arr;
    }
}
