public class Runner {

    // Power of two

    // Complete the function power_of_two/powerOfTwo
    // (or equivalent, depending on your language) that determines if a given non-negative integer is a power of two.

    public static void main(String[] args) {
        boolean isPowerOfTwo = isPowerOfTwo(1024);
        System.out.println(isPowerOfTwo);
    }

    public static boolean isPowerOfTwo(long n) {
        if (n < 0) {
            return false;
        }
        String binaryStr = Long.toBinaryString(n);
        return binaryStr.lastIndexOf('1') == 0;
    }
}
