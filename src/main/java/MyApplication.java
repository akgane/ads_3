import utils.MyBST;

public class MyApplication {
    public static void main(String[] args) {
        MyBST<Integer, Integer> bst = new MyBST<Integer, Integer>();

        bst.put(12, 91);
        bst.put(54, 86);
        bst.put(12, 71);
        bst.put(26, 63);
        bst.put(84, 23);
        bst.put(16, 84);
        bst.put(6, 7);

        System.out.println(bst.get(12));
        System.out.println(bst.get(16));
        System.out.println(bst.get(6));
    }
}
