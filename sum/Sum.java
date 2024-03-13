package sum;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Sum {
    public static void main(String[] args) {
        int res = sum(new int[] { 1, 1, 11, 2, 3 });
        System.out.println(res);
    }

    public static int sum(int[] numbers) {
        if (numbers == null || numbers.length <= 1) {
            return 0;
        }

        Deque<Integer> deque = Arrays.stream(numbers)
                .boxed()
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));
        deque.removeFirst();
        deque.removeLast();

        return deque.stream().reduce(0, Integer::sum);
    }
}
