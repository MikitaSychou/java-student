package multiply;

public class Runner {
    public static void main(String[] args) {
        
         // Jack really likes his number five: the trick here is that you have to multiply each number by 5 raised
        //to the number of digits of each numbers, so, for example:
        //   3 -->    15  (  3 * 5¹)
        //  10 -->   250  ( 10 * 5²)
        // 200 --> 25000  (200 * 5³)
        //   0 -->     0  (  0 * 5¹)
        //  -3 -->   -15  ( -3 * 5¹)
        
        System.out.println(multiply(3));
    }

    public static int multiply(int number) {
        int length = String.valueOf(number).replace("-", "").length();
        double result = number * Math.pow(5, length);
        return (int) result;
    }
}
