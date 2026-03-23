package main;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static <T> T firstOrNull(List<T> list2){
        if (!list2.isEmpty()){
            return list2.get(0);
        }
        else return null;
    }
    public static double sum(List<? extends Number> list2) {
        double sum = 0;
        for (Number n : list2) {
            if (n != null) sum += n.doubleValue();
        }
        return sum;
    }
    public static void addDefaultIds(List<? super Integer> list2){
        list2.add(1);
        list2.add(7);
        list2.add(10);
    }
    public static void main(String[] args) {
        List<String> letters = List.of("a", "b", "c");

        List<Double> doubles = List.of(1.4, 2.1, -2.9);

        ArrayList<Number> numbers = new ArrayList<>();
        addDefaultIds(numbers);

        System.out.println("First "+ firstOrNull(letters));
        System.out.println("first "+ firstOrNull(doubles));
        System.out.println("Sum "+ sum(doubles));
        System.out.println("List "+ numbers);

    }
}
