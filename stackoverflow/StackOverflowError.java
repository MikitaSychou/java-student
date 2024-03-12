public class StackOverflowError {

    // StackOverflowError
    public static void main(String[] args) {
        printNumber(1);
    }

    public static void printNumber(int number) {
        final String MESSAGE = "Number must be greater than zero";
        if(number <= 0) {
            throw new IllegalArgumentException(MESSAGE);
        } else {
            printNumber(++number);
        }
    }
}
