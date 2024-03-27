public class Runner {
    public static void main(String[] args) {
        boolean result = isAscOrder(new int[]{1,2,5,8,10});
        System.out.println(result);
    }

    public static boolean isAscOrder(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }
}
