package lfu;

import java.util.LinkedHashMap;
import java.util.Map;

public class LFUCache {

    private LinkedHashMap<Integer, Node> cache = new LinkedHashMap<>();

    private int capacity;

    public LinkedHashMap<Integer, Node> getCache() {
        return cache;
    }

    public void setCache(LinkedHashMap<Integer, Node> cache) {
        this.cache = cache;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public Node put(int key, String data) {
        Node temp;
        if (isCacheFilled()) {
            int entryKeyToBeRemoved = getKey();
            cache.remove(entryKeyToBeRemoved);

        }
        temp = new Node();
        temp.setData(data);
        temp.setFrequency(0);
        cache.put(key, temp);
        return temp;
    }


    public Node putIfAbsent(int key, String data) {
        Node temp = null;
        Node val = get(key);
        if(val == null) {
           temp = put(key, data); 
        }
        return temp;
    }


    public Node remove(int key) {
        if(cache.containsKey(key))  // попадание в кэш
        {
            return cache.remove(key);

        }
        return null;
    }

    
    public Node get(int key)
    {
        if(cache.containsKey(key))  // попадание в кэш
        {
            Node temp = cache.get(key);
            temp.getIncrementedFrequency();
            cache.put(key, temp);
            return temp;
        }
        return null;
    }


    public boolean contains(int key) {
        return cache.containsKey(key);
    }


    public int getKey()
    {
        int key = 0;
        int minFreq = Integer.MAX_VALUE;

        for(Map.Entry<Integer, Node> entry : cache.entrySet())
        {
            if(minFreq > entry.getValue().getFrequency())
            {
                key = entry.getKey();
                minFreq = entry.getValue().getFrequency();
            }
        }

        return key;
    }

    public boolean isCacheFilled()
    {
        return cache.size() == capacity;
    }
}
