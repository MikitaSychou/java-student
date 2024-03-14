package letters;

public class LettersRunner {
    public static void main(String[] args) {
        String currentString = gimmeTheLetters("f-o");
        System.out.println(currentString);

    }

    public static String gimmeTheLetters(String s){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        char first_char = s.charAt(0);
        if(Character.isUpperCase(first_char)) {
            alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
        }
        char last_char = s.charAt(s.length() - 1);
        int first_index = alphabet.indexOf(first_char);
        int last_index = alphabet.indexOf(last_char);

        return alphabet.substring(first_index, last_index + 1);
    }
}
