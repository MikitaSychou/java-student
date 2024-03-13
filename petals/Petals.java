package petals;

public class Petals {

    public static void main(String[] args) {
        String petal = howMuchILoveYou(1);
        System.out.println(petal);
    }

    public static String howMuchILoveYou(int nb_petals) {

        String petalsArray[] = {
                "I love you",
                "a little",
                "a lot",
                "passionately",
                "madly",
                "not at all"
        };

        String currentPetal = null;

        for(int i = 0; i <= petalsArray.length -1; i++) {
              currentPetal = petalsArray[(nb_petals - 1) % 6];
        }
        return currentPetal;
    }
}
