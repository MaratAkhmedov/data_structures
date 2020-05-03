package models;

/**
 * The Java SortedMap interface, java.util.SortedMap, is a subtype of the java.util.Map interface,
 * with the addition that the elements stored in a Java SortedMap map are sorted internally.
 * This means you can iterate the elements stored in a SortedMap in the sort order.
 * All keys inserted into a sorted map must implement the Comparable interface  (or be accepted by the specified comparator)
 * doesnt allow null KEYS becouse compareTo will throw exception
 * @param <K> key
 * @param <V> value
 */

public interface SortedMap<K, V> extends Map<K, V>{
    /**
     *
     * @return the first (lowest) key currently in this map.
     */
    public K firstKey();

    /**
     *
     * @return the last (highest) key currently in this map.
     */
    public K lastKey();

    /**
     *
     * @param fromKey
     * @return a view of the portion of this map whose keys are greater than or equal to fromKey.
     */
    public SortedMap<K, V> tailMap(K fromKey);

    /**
     *
     * @param toKey
     * @return a view of the portion of this map whose keys are strictly less than toKey.
     */
    public SortedMap<K, V> headMap(K toKey);
}
