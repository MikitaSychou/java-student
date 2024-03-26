public class Fibonacci {

    // Fibonacci

    public static void main(String[] args) {
            long fibonacci = fib(1);
        System.out.println(fibonacci);
    }

    public static long fib (int n){
        long a = 0;
        long b = 1;
        long next = 0;

        if(n == 1) {
            return b;
        }

        for (int i = 2; i <= n; ++i) {
            next = a + b;
            a = b;
            b = next;
        }

        return next;
    }
}
