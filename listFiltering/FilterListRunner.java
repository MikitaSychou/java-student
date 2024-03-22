import java.util.List;
import java.util.stream.Collectors;

public class FilterListRunner {

//    List Filtering
//
//    In this kata you will create a function that takes a list of non-negative
//    integers and strings and returns a new list with the strings filtered out.
//    Example Kata.filterList(List.of(1, 2, "a", "b")) => List.of(1,2)
//        Kata.filterList(List.of(1, "a", "b", 0, 15)) => List.of(1,0,15)
    public static void main(String[] args) {
        List<Object> integers = filterList(List.of(1, "a", "b", 0, 15));
        System.out.println(integers);
    }

    public static List<Object> filterList(final List<Object> list) {
        return list.stream()
                .filter((el) -> el.getClass() == Integer.class)
                .collect(Collectors.toList());
    }
}
