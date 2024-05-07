package utils;

public class MyTestingClass {
    private int id;
    private String name;

    public MyTestingClass(String name){
        this(name, 0);
    }
    public MyTestingClass(String name, int id){
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode(){
        int hash = 0;
        for(char c : name.toCharArray()){
            hash = c + (31 * hash);
        }
        return hash;
    }
}
