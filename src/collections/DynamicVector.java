package collections;

import java.util.Arrays;

//add,get,getLast,getFirst
public class DynamicVector {
    private String[] array;

    public DynamicVector() {
        array = new String[10];
    }

    public DynamicVector(int size) {
        array = new String[size];
    }

    public void add(String incomingString){
        String[] newArray = new String[array.length + 1];
        for(int i = 0; i < array.length; i++){
            if (i == array.length - 1){
                newArray[i + 1] = incomingString;
            } else {
                newArray[i] = array[i];
            }
        }
        array = newArray;
    }

    public String getLast(){
        return array[array.length - 1];
    }
    public String getFirst(){
        return array[0];
    }

    @Override
    public String toString() {
        return "DynamicVector{" +
            "array=" + Arrays.toString(array) +
            '}';
    }
}
