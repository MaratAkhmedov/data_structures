package models;

import java.util.Set;

/**
 * the cost in find a key, get(K key), in the map is:
 * O(n) -> if we use LinkedList or Array
 * O(log n) -> if we use ordered array (binary search)
 * O(1) -> if we use HashTable, the special array
 * @param <K> key
 * @param <V> value
 */
public interface Map<K, V> {
    /**
     * insert the key-value in the map
     * @param key
     * @param value
     * @return the PREVIOUS valueof the map
     */
    public V put(K key, V value);

    /**
     * remove the key-value from the map
     * @param key
     * @return the value of the key or null if key doesnt exist
     */
    public V remove(K key);

    /**
     * get the value of the key
     * @param key the key of the map
     * @return the value of the specified key
     */
    public V get(K key);

    /**
     * check if the map is empty
     * @return true if map contains no key-value mappings
     */
    public boolean isEmpty();

    /**
     * get all the keys of the map
     * @return instance of Set (Collection which contains not duplicate elements and only 1 null element)
     *          with all the keys of the map
     */
    public Set<K> keySet();


}
