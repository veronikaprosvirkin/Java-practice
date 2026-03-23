package main;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Text");
        list.add(1);
    try {
        for (Object o : list) {
            String s = (String) o;
            System.out.println(s);
        }
    } catch (ClassCastException e){
        System.out.println("ClassCastException");
    }
        System.out.println("======================");

        List<String> list2 = new ArrayList<>();
        list2.add("Text");
        //list2.add(32);
        for (String s : list2) {
            System.out.println(s);
        }
    }
}
