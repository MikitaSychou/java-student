public class ShortestWordRunner {

    // Shortest Word

    // Simple, given a string of words, return the length of the shortest word(s).
    //String will never be empty and you do not need to account for different data types.


    public static void main(String[] args) {
        int resultLength = findShort("bitcoin take over the world maybe who knows perhaps");
        System.out.println(resultLength);
    }

    public static int findShort(String s) {
        String[] stringArray = s.split(" ");

        int minLength = s.length();

        for(int i = 0; i< stringArray.length; i++) {
            if(stringArray[i].length() < minLength) {
                minLength = stringArray[i].length();
            }
        }
        return minLength;
    }
}
