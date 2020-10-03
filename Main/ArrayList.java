package Main;

public class ArrayList<T> {

    private Object[] objects;
    private int length;
    private int arraySize = 10;

    public ArrayList(){
        objects = new Object[arraySize];
    }

    public void add(T data){
        objects[length++] = data;
    }


    public void size() {
    }
}
