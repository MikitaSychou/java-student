public class Runner {

    // Sum of Cubes

    //    Write a function that takes a positive integer n,
    //    sums all the cubed values from 1 to n (inclusive), and returns that sum.
    //    Assume that the input n will always be a positive integer.
    //    Examples: (Input --> output)
    //    2 --> 9 (sum of the cubes of 1 and 2 is 1 + 8)
    //    3 --> 36 (sum of the cubes of 1, 2, and 3 is 1 + 8 + 27)
    public static void main(String[] args) {
        long sum = sumCubes(2);
        System.out.println(sum);
    }

    public static long sumCubes(long n)
    {
        long sumOfCubes = 0;
        for(int i = 1; i <=n; i++) {
            sumOfCubes += (long)Math.pow(i, 3);
        }
        return sumOfCubes;
    }
}
