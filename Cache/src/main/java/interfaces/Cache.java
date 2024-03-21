package interfaces;

public interface Cache<K, V> {

    boolean contains(K key);

    V delete(K key);

    V get(K key);

    V put(K key, V value);

    V putIfAbsent(K key, V value);

}



