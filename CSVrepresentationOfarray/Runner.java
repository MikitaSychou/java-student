package CSVrepresentationOfarray;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        String resultString = toCsvText(new int[][] {
                { 0, 1, 2, 3, 45 },
                { 10,11,12,13,14 },
                { 20,21,22,23,24 },
                { 30,31,32,33,34 } });

        System.out.println(resultString);
    }

    public static String toCsvText(int[][] array){
        StringBuilder sb = new StringBuilder();
        for(int[] s1 : array){
            String newString = Arrays.toString(s1);
            sb.append(newString.replaceAll("\\[|]"," ")).append(System.lineSeparator());
        }
        sb.setLength(sb.length() - 1);
        return sb.toString().replaceAll(" ","");
    }
}

