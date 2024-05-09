package utils;

import utils.interfaces.MyBSTInterface;

public class MyBST<K extends Comparable<K>, V> implements MyBSTInterface<K,V> {
    private Node root;
    private int size;

    public MyBST(){
        root = null;
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value){
        if(node == null){
            node = new Node(key, value);
            return node;
        }
        if(node.key.compareTo(key) > 0) node.left = put(node.left, key, value);
        else node.right = put(node.right, key, value);
        return node;
    }

    @Override
    public V get(K key) {
        return get(root, key);
    }

    private V get(Node node, K key){
        if(node == null) return null;
        if(node.key.equals(key)) return node.value;
        if(node.key.compareTo(key) > 0) return get(node.left, key);
        return get(node.right, key);
    }

    @Override
    public void delete(K key) {

    }


    private class Node{
        private K key;
        private V value;
        private Node left, right;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}
