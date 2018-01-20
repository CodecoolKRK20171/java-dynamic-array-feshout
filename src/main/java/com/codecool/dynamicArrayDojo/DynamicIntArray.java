package com.codecool.dynamicArrayDojo;

import java.lang.reflect.Array;

public class DynamicIntArray {

    private static int[] intArray;

    public DynamicIntArray() {
        this.intArray = new int[0];
    }

    public DynamicIntArray(int size) {
        this.intArray = new int[size];
    }


    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (int number : this.intArray)
            sb.append(" " + number);

        return sb.toString();
    }

    public void add(int number) {

        int[] newArray = new int[intArray.length + 1];

        for (int i = 0; i < intArray.length ; i++) {
            newArray[i] = intArray[i];
        }
        newArray[intArray.length] = number;

        this.intArray = newArray;
    }

    public void remove(int index) {

        checkIndex(index);
        int [] newArray = removeValue(index);

        this.intArray = newArray;
    }

    public void insert(int index, int value) {

        if(index >= intArray.length){
            add(value);
        } else {
            int[] newArray = insertValue(index, value);
        this.intArray = newArray;
        }
    }

    private void checkIndex(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index >= intArray.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private int[] removeValue(int index){

        int[] newArray = new int[intArray.length -1];

        for (int i = 0; i < index; i++) {
            newArray[i] = intArray[i];
        }

        for (int i = index; i < newArray.length ; i++) {
            newArray[i] = intArray[i+1];
        }
        return newArray;
    }

    private int[] insertValue(int index, int value) {

        int [] newArray = new int[intArray.length + 1];

        for (int i = 0; i < index; i++) {
            newArray[i] = intArray[i];
        }
        newArray[index] = value;
        for (int i = index; i < intArray.length ; i++) {
            newArray[i+1] = intArray[i];
        }
        return newArray;
    }
}
