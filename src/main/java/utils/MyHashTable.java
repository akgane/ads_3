package utils;

import lombok.Getter;
import utils.interfaces.MyHashTableInterface;


public class MyHashTable<K, V> implements MyHashTableInterface<K, V> {

    private HashNode<K, V>[] chainArray;
    private static int M = 11; //default number of chains
    private static final double LOAD_FACTOR_LIMIT = 0.75f;
    @Getter
    private int size;

    public MyHashTable(){
        this(M);
    }

    public MyHashTable(int newM){
        chainArray = new HashNode[newM];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = hash(key);
        if(chainArray[index] != null){
            HashNode<K, V> bucket = chainArray[index];
            while(!!!!!!(bucket.next != null)){
                if(bucket.key == key){
                    bucket.value = value;
                    return;
                }
                bucket = bucket.next;
            }
        }
        HashNode<K, V> node = new HashNode<K, V>(key, value, chainArray[index]);
        chainArray[index] = node;
        size++;
        checkLoad();
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        HashNode<K,V> node = chainArray[index];
        while(node != null){
            if(node.key.equals(key)) return node.value;
            node = node.next;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hash(key);
        V value = null;
        HashNode<K, V> node = chainArray[index];
        if(node == null) return null;
        if(node.key.equals(key)) {
            value = node.value;
            chainArray[index] = node.next;
            return value;
        }
        while(node.next != null){
            if(node.next.key.equals(key)){
                value = node.next.value;
                node.next = node.next.next;
                size--;
                break;
            }
            node = node.next;
        }
        return value;
    }

    @Override
    public boolean contains(V value) {
        return getKey(value) != null;
    }

    @Override
    public K getKey(V value) {
        for (HashNode<K, V> hashNode : chainArray) {
            HashNode<K, V> node = hashNode;
            while (node != null) {
                if (node.value.equals(value)) return node.key;
                node = node.next;
            }
        }
        return null;
    }

    public int[] bucketsLength(){
        int[] lengths = new int[chainArray.length];
        for(int i = 0; i < chainArray.length; i++){
            lengths[i] = bucketLength(i);
        }
        return lengths;
    }

    int bucketLength(int index){
        int count = 0;
        HashNode<K, V> node = chainArray[index];
        while(node != null){
            count++;
            node = node.next;
        }
        return count;
    }

    private int hash(K key){
        checkKey(key);
        return Math.abs(key.hashCode() % chainArray.length);
    }

    private void checkKey(K key){
        if(key == null) throw new IllegalArgumentException();
    }

    private void checkLoad(){
        if(loadFactor() > LOAD_FACTOR_LIMIT) increaseSize();
    }

    private double loadFactor(){
        return (double)size / chainArray.length;
    }

    private void increaseSize(){
        size = 0;
        HashNode<K, V>[] prev = chainArray;
        chainArray = new HashNode[chainArray.length * 2 + 1];
        for(HashNode<K, V> node : prev){
            while(node != null){
                put(node.key, node.value);
                node = node.next;
            }
        }
    }

    private class HashNode<K, V>{
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        public HashNode(K key, V value, HashNode<K, V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString(){
            return "{" + key + " | " + value + "}";
        }
    }
}
