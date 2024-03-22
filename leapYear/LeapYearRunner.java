import java.time.Year;

public class LeapYearRunner {

//    In this kata you should simply determine, whether a given year is a leap year or not.
//    In case you don't know the rules, here they are:
//    Years divisible by 4 are leap years,
//    but years divisible by 100 are not leap years,
//    but years divisible by 400 are leap years.
//    Tested years are in range 1600 ≤ year ≤ 4000.
    public static void main(String[] args) {
        boolean isLeapYear = isLeapYear(2020);
        System.out.println("Is Year leap: " + isLeapYear);
    }

    public static boolean isLeapYear(int year) {
        Year firstYear = Year.of(year);
        return firstYear.isLeap();
    }
}
