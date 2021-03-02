package collections;

import java.util.Arrays;

//add,get,getLast,getFirst
public class CommonDynamicVector<E> {
    private Object[] array;

    public CommonDynamicVector() {
        array = new String[10];
    }

    public CommonDynamicVector(int size) {
        array = new Object[size];
    }

    public void add(E incomingString){
        Object[] newArray = new Object[array.length + 1];
        for(int i = 0; i < array.length; i++){
            if (i == array.length - 1){
                newArray[i + 1] = incomingString;
            } else {
                newArray[i] = array[i];
            }
        }
        array = newArray;
    }

    public Object getLast(){
        return array[array.length - 1];
    }
    public Object getFirst(){
        return array[0];
    }

    @Override
    public String toString() {
        return "DynamicVector{" +
            "array=" + Arrays.toString(array) +
            '}';
    }
}
