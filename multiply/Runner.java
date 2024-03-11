package multiply;

public class Runner {
    public static void main(String[] args) {
        System.out.println(multiply(3));
    }

    public static int multiply(int number) {
        int length = String.valueOf(number).replace("-", "").length();
        double result = number * Math.pow(5, length);
        return (int) result;
    }
}
