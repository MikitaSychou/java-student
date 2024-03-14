package catDogYear;

import java.util.Arrays;

public class CatDogRunner {
    public static void main(String[] args) {
        int[] humanYearsArray = ownedCatAndDog(56,64);
        System.out.println(Arrays.toString(humanYearsArray));
    }

    public static int[] ownedCatAndDog(final int catYears, final int dogYears) {
        int catHumanYear = catYears < 15 ? 0
                : catYears < 24 ? 1
                : catYears == 24 ? 2
                : (catYears - 24) / 4 + 2;

        int dogHumanYear = dogYears < 15 ? 0
                : dogYears < 24 ? 1
                : dogYears == 24 ? 2
                : (dogYears - 24) / 5 + 2;

        return new int[]{catHumanYear, dogHumanYear};
    }
}
