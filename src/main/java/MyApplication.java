import utils.MyHashTable;

public class MyApplication {
    public static void main(String[] args) {
        MyHashTable<Integer, Integer> hash = new MyHashTable<>();
        hash.put(1, 1);
        hash.put(2, 1);
        hash.put(3, 1);
        hash.put(4, 1);
        hash.put(5, 1);
        hash.put(6, 1);
        hash.put(7, 1);
        System.out.println(hash.getSize());
        hash.put(8, 1);
        hash.put(9, 1);
        hash.put(10, 1);
        hash.put(11, 1);
        hash.put(12, 1);
        hash.put(13, 1);
        hash.put(14, 1);
        System.out.println(hash.getSize());



    }
}
