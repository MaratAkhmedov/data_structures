package map;

import java.util.Objects;

public class HashEntry<K,V> {
    protected K key;
    protected V value;

    public HashEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public String toString(){
        return "( " + key + ", " + value + " )";
    }

    /**
     * two entries are identically if they have the same key
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashEntry<?, ?> hashEntry = (HashEntry<?, ?>) o;
        return Objects.equals(key, hashEntry.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
