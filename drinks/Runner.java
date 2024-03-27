public class Runner {

    // Responsible Drinking

//    "1 beer"  -->  "1 glass of water"
//    because you drank one standard drink
//
//"1 shot, 5 beers, 2 shots, 1 glass of wine, 1 beer"  -->  "10 glasses of water"
//    because you drank ten standard drinks

    public static void main(String[] args) {
        String result = hydrate("1 shot, 5 beers, 2 shots, 1 glass of wine, 1 beer");
        System.out.println(result);
    }

    public static String hydrate(String drinkString) {
        int count;
        int sum = 0;
        for (int i = 0; i < drinkString.length(); i++) {
            if (Character.isDigit(drinkString.charAt(i))) {
                count = Integer.parseInt(String.valueOf(drinkString.charAt(i)));
                sum += count;
            }
        }

        return (sum == 1) ? sum + " glass of water" : sum + " glasses of water";
    }
}
