package lru;

import interfaces.Cache;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> implements Cache<K, V> {

    private Map<K, V> map;

    public LRUCache(int limit) {
        map = new LinkedHashMap<>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldestEntry) {
                return super.size() > limit;
            }
        };
    }


    @Override
    public boolean contains(K key) {
        return map.containsKey(key);
    }

    @Override
    public V delete(K key) {
        return map.remove(key);
    }

    @Override
    public V get(K key) {
        return map.get(key);
    }

    @Override
    public V put(K key, V value) {
        return map.put(key, value);
    }

    @Override
    public V putIfAbsent(K key, V value) {
        return map.putIfAbsent(key, value);
    }
}
