package map;


import java.util.*;

/**
 * You can GET and PUT the element in constant cost O(1)
 * if equals and hashcode() are implemented in the correct way
 * @param <K> key
 * @param <V> value
 */

public class HashMap<K, V> implements models.Map<K, V> {
    // Una Tabla Hash TIENE UNA cte...
    /** El valor (float) del factor de carga de una Tabla Hash (valor por
     *  defecto que tiene en la clase java.util.HashMap) */
    public static final double loadFactor = 0.75;

    // TIENE UN array de Listas Con PI de EntradaHash<C, V>:
    // - elArray[h] representa una cubeta, o lista de colisiones asociadas
    //   al indice Hash h
    // - elArray[h] contiene la referencia a la Lista Con PI donde se
    //   encuentran todas las Entradas cuya Clave tiene un indice Hash h
    protected LinkedList<HashEntry<K, V>>[] theArray;

    // TIENE UNA talla que representa el numero de Entradas almacenadas
    // en una Tabla Hash o, si se prefiere, en sus cubetas
    protected int size;

    @SuppressWarnings("unchecked")
    public HashMap(int capacity) {
        theArray = new LinkedList[capacity];
        //Arrays.fill(theArray, new LinkedList<HashEntry<K, V>>()); not the same
        for (int i = 0; i < theArray.length; i++) {
            theArray[i] = new LinkedList<HashEntry<K,V>>();
        }
        size = 0;
    }


    // Devuelve el indice Hash de la Clave c de una Entrada, i.e. la cubeta
    // en la que se debe encontrar la Entrada de clave c
    // **** SIN ESTE METODO NO SE TIENE UNA TABLA HASH, SOLO UN ARRAY ****
    /**
     * @param key
     * @return the position in which one we will put the element
     */
    public int indexFor(K key) {
        int indexHash = key.hashCode() & (this.theArray.length - 1);
        //if (indiceHash < 0) { indiceHash += this.theArray.length; }
        return indexHash;
    }



    /**
     * insert the key-value in the map
     *Con indexFor averiguamos la cubeta a la que tenemos que insertarlo
     * (if key is null we put key at the frist bucket of array),
     * recorremos la cubeta para saber si otra entrada con la misma clave,
     * si esta entrada existe, la sustituimos y devolvemos el valor pasado
     * si no existe, insertamos al final de la cubeta el valor que hay q insertar
     * @param key
     * @param value
     * @return the PREVIOUS valueof the map
     */
    @SuppressWarnings("unchecked")
    @Override
    public V put(K key, V value) {
        int position;
        if(key == null) {
            position = 0;
        }
        else {
            position = indexFor(key);
        }
        LinkedList<HashEntry<K,V>> l = theArray[position]; //the bucket that has list we are looking for
        V oldValue = null;
        HashEntry<K, V>  search= new HashEntry<K, V>(key, value);
        int index = l.indexOf(search);
        //si no hay insertamos al final
        if(index == -1) {
            size++;
            l.addLast(search);
            // size / theArray.length == current loadFactor
            if (((double)size)/theArray.length > loadFactor) { rehashing(); }
        }
        else {
            //si lo encontramos en la cubera, lo sustituimos y devolmemos el valor anterior
            oldValue = l.remove(index).value;
            l.add(index, search);
        }

        return oldValue;
    }

    /**
     * 1) duplicate the theArray
     * 2) get all the entries from the old array
     * 3) rewrite all entries in new array
     */
    @SuppressWarnings("unchecked")
    public void rehashing() {
        LinkedList<HashEntry<K, V>>[] oldArray = theArray;
        theArray = new LinkedList[theArray.length * 2];
        size = 0;

        for (int i = 0; i < theArray.length; i++) {
            theArray[i] = new LinkedList<HashEntry<K,V>>();
        }

        for (int i = 0; i < oldArray.length; i++) {
            LinkedList<HashEntry<K, V>> l = oldArray[i];

            for (HashEntry<K, V> entry : l) {
                put(entry.key, entry.value);
            }
        }
    }

    /**
     * remove the key-value from the map
     * 1) buscamos la cubeta que hay que eliminar
     * 2) buscamos dentro de la cubeta el elemento que hay que eliminar
     * 3) si la encontramos, la eliminamos y devolmemos el valor, si no la encontramos devolvemos null
     * @param key
     * @return the value of the key or null if key doesnt exist
     */
    @Override
    public V remove(K key) {
        int position = indexFor(key);
        LinkedList<HashEntry<K, V>> l = theArray[position];
        HashEntry<K, V> entry = new HashEntry<K, V>(key, null);
        int index = l.indexOf(entry);
        if(index == -1) {
            return null;
        }
        else {
            //si lo encontramos, lo borramos y actualizamos size
            size--;
            return l.remove(index).value;
        }
    }

    /**
     * 1) obtenemos la pos. en la cubeta
     * 2) buscamos la clave
     * 3) la devolvemos (o null)
     *
     * @param key the key of the map
     * @return the value of the specified key
     */
    @Override
    public V get(K key) {
        V value = null;
        LinkedList<HashEntry<K, V>> l = theArray[indexFor(key)];
        HashEntry<K,V> entry = new HashEntry<K, V>(key, null);
        int index = l.indexOf(entry);
        if(index == - 1)
            return null;
        else
            return l.get(index).value;
    }

    /**
     * check if the map is empty
     *
     * @return true if map contains no key-value mappings
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * get all the keys of the map
     *
     * @return instance of Set (Collection which contains not duplicate elements and only 1 null element)
     * with all the keys of the map
     */
    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<K>();
        for (int i = 0; i < theArray.length; i++) {
            LinkedList<HashEntry<K, V>> l = theArray[i];
            for (HashEntry<K, V> entry: l) {
                set.add(entry.key);
            }
        }
        return set;
    }
}
