package lost;

import java.util.Arrays;

public class LostWithoutMap {
    public static void main(String[] args) {
        int arrDoubled[] = map(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(arrDoubled));
    }

        public static int[] map(int[] arr) {
        return Arrays.stream(arr)
                .map(el -> el * 2)
                .toArray();

    }
}
