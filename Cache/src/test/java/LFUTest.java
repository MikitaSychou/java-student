import lfu.LFUCache;
import lfu.Node;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LFUTest {

        @Test
        public void cacheSize_EqualsTo_cacheCapacity() {
        LFUCache lfuCache = new LFUCache(3);

        lfuCache.put(1, "Data 1");
        lfuCache.put(2, "Data 2");
        lfuCache.put(3, "Data 3");

        assertTrue(lfuCache.getCache().size() == lfuCache.getCapacity());
    }


        @Test
        public void lastElementIsDeleted_WhenCacheSize_MoreThanCacheCapacity() {
                LFUCache lfuCache = new LFUCache(3);

                lfuCache.put(1, "Data 1");
                lfuCache.put(2, "Data 2");
                lfuCache.put(3, "Data 3");
                lfuCache.put(4, "Data 4");

                assertFalse(lfuCache.getCache().size() > lfuCache.getCapacity());
                assertFalse(lfuCache.contains(1));
        }

        @Test
        public void checkThat_LastRetrievedElement_isIncremented() {
                LFUCache lfuCache = new LFUCache(3);

                lfuCache.put(1, "Data 1");
                lfuCache.put(2, "Data 2");
                lfuCache.put(3, "Data 3");

                Node actualNode = lfuCache.get(3);

                assertTrue(actualNode.getFrequency() == 1);
        }

        @Test
        public void checkThat_LeastFrequentElement_isRemoved() {
                LFUCache lfuCache = new LFUCache(3);

                Node node1;
                Node node2;
                Node node3;

                lfuCache.put(1, "Data 1");
                lfuCache.put(2, "Data 2");
                lfuCache.put(3, "Data 3");

                lfuCache.get(1);
                node1 = lfuCache.get(1);

                lfuCache.get(2);
                node2 = lfuCache.get(2);

                node3 = lfuCache.get(3);

                assertTrue(node1.getFrequency() == 2);
                assertTrue(node2.getFrequency() == 2);
                assertTrue(node3.getFrequency() == 1);

                lfuCache.put(4, "Data 4");

                assertTrue(lfuCache.contains(1));
                assertTrue(lfuCache.contains(2));
                assertFalse(lfuCache.contains(3));
        }


        @Test
        public void check_ThatElement_IsRemoved() {
                LFUCache lfuCache = new LFUCache(3);

                lfuCache.put(1, "Data 1");
                lfuCache.put(2, "Data 2");
                lfuCache.put(3, "Data 3");

                lfuCache.remove(1);

                assertFalse(lfuCache.contains(1));
                assertTrue(lfuCache.getCache().size() < lfuCache.getCapacity());
        }


        @Test
        public void check_ThatTheKey_ThatIsAlreadyPresent_IsNotAdded() {
                LFUCache lfuCache = new LFUCache(3);

                lfuCache.put(1, "Data 1");
                lfuCache.put(2, "Data 2");
                lfuCache.put(3, "Data 3");

                lfuCache.putIfAbsent(3, "Data 4");


                assertNotEquals("Data 4", lfuCache.get(3).getData());
        }
}
