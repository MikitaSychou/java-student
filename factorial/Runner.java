public class Runner {
    public static void main(String[] args) {
        int result = factorial(5);
        System.out.println(result);
    }

    public static int factorial(int n) {
        if (n < 0 || n >=12) {
            throw new IllegalArgumentException();
        } else if(n == 1 || n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }

    }
}
