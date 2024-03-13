package combineNames;

public class CombineNames {
    public static void main(String[] args) {
        String combined = combineNames("James", "Stevens");
        System.out.println(combined);
    }

    public static String combineNames(String first,String last) {
        final String DELIMITER = " ";
        StringBuilder sb = new StringBuilder();
        sb.append(first)
                .append(DELIMITER)
                .append(last);
        return sb.toString();
    }
}
