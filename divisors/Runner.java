public class Runner {
    public static void main(String[] args) {
        long numberOfDivisors = numberOfDivisors(10);
        System.out.println(numberOfDivisors);
    }

    public static long numberOfDivisors(int n) {
        if(n < 0) {
            throw new IllegalArgumentException();
        }

        int count = 0;

        for (int i = 1; i <=n; i++) {
            if(n%i == 0) {
                count++;
            }
        }

        return count;

    }
}
