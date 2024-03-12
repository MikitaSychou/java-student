package heapCollapse;

import java.util.ArrayList;
import java.util.List;

public class HeapCollapse {

    // OutOfMemoryError

    public static void main(String[] args) {
        emptyMemory();
    }

    public static void emptyMemory() {

        List<Integer> integerList = new ArrayList<>();

        while (true) {
            integerList.add(1000);
        }
    }
}
