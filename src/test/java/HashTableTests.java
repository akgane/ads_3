import utils.MyHashTable;
import utils.MyTestingClass;
import utils.Student;
import utils.Utilities;

public class HashTableTests {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        for(int i = 0; i < 10000; i++){
            table.put(Utilities.testingClassGenerator(i), Utilities.studentGenerator(i));
        }

        int[] buckets = table.bucketsLength();
        int counter = 0;
        for(int i : buckets) if(i != 0){
            System.out.print(i + ", ");
            counter++;
        }
        System.out.printf("\nFilled buckets: %d", counter);
        System.out.printf("\nFilled buckets percentage: %.2f%%", (counter * 100f / buckets.length));
        System.out.printf("\nTotal buckets: %d", buckets.length);
    }
}
