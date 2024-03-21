import lru.LRUCache;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class LRUTest {

       @Test
        public void cacheElements_ArePresent() {
           LRUCache<Integer, String> lruCache = new LRUCache<>(3);
           lruCache.put(1, "Dima");
           lruCache.put(2, "Igor");
           lruCache.put(3, "Olga");

           assertEquals("Dima", lruCache.get(1));
           assertEquals("Igor", lruCache.get(2));
           assertEquals("Olga", lruCache.get(3));
       }

       @Test
       public void addElementToCacheToTheNumberOfSize_WhenAddOneMoreElement_ThenLeastRecentlyElementWillBeRemoved() {
           LRUCache<Integer, String> lruCache = new LRUCache<>(3);
           lruCache.put(1, "Dima");
           lruCache.put(2, "Igor");
           lruCache.put(3, "Olga");
           lruCache.put(4, "Vlad");

           assertFalse(lruCache.contains(1));
       }

       @Test
    public void putThePair_ToTheCache_IfAbsent() {
           LRUCache<Integer, String> lruCache = new LRUCache<>(3);
           lruCache.put(1, "Dima");
           lruCache.put(2, "Igor");
           lruCache.putIfAbsent(3, "Olga");

           assertEquals("Olga", lruCache.get(3));
       }

       @Test
        public void thePairInNotPut_ToTheCache_Because_ItIsPresent() {
           LRUCache<Integer, String> lruCache = new LRUCache<>(3);
           lruCache.put(1, "Dima");
           lruCache.put(2, "Igor");
           lruCache.putIfAbsent(2, "Sergey");

           assertNotEquals("Sergey", lruCache.get(2));
       }
}
