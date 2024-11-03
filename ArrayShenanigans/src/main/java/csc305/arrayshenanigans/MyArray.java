package csc305.arrayshenanigans;

import java.util.ArrayList;

public class MyArray {
    private ArrayList<Integer> vals;

    public MyArray() {}

    public MyArray(ArrayList<Integer> vals) {
        this.vals = vals;
    }

    public ArrayList<Integer> getVals() {
        return vals;
    }

    public void setVals(ArrayList<Integer> vals) {
        this.vals = vals;
    }

    public void merge(){}

    @Override
    public String toString() {
        return "MyArray{" +
                "vals=" + vals +
                '}';
    }
}
