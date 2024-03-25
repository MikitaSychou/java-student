public class MoreThanZeroRunner {

    //More than Zero?
//    Correct this code so that it takes one argument, x, and
//    returns "x is more than zero" if x is positive (and nonzero),
//    and otherwise, returns "x is equal to or less than zero."
//    In both cases, replace x with the actual value of x.
    public static void main(String[] args) {
            String result = corrections(-1);
        System.out.println(result);
    }

    public static String corrections(int x) {
        return (x > 0) ? x + " is more than zero."
                : x + " is equal to or less than zero.";
    }
}
