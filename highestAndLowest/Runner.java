import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {

  //  Highest and Lowest
//    In this little assignment you are given a string of space separated numbers,
//    and have to return the highest and lowest number.
//
//    highAndLow("1 2 3 4 5")  // return "5 1"
//    highAndLow("1 2 -3 4 5") // return "5 -3"
//    highAndLow("1 9 3 4 -5") // return "9 -5"

    public static void main(String[] args) {
        String result = highAndLow("1 9 3 4 -5");
        System.out.println(result);
    }

    public static String highAndLow(String numbers) {
        final Pattern pattern = Pattern.compile("-?\\d+");
        final Matcher matcher = pattern.matcher(numbers);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (matcher.find()) {
            int nextNumber = Integer.valueOf(matcher.group());
            if (nextNumber > max) {
                max = nextNumber;
            }
            if (nextNumber < min) {
                min = nextNumber;
            }
        }
        return max + " " + min;
    }
}
