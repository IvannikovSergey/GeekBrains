package Professional.hw1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer[] array = new Integer[6];

        array[0] = 15;
        array[1] = 35;
        array[2] = 40;
        array[3] = 60;
        array[4] = 88;
        array[5] = 44;

        System.out.println("Исходный массив: " + Arrays.toString(array));
        swapElements(array, 0, 5);
        System.out.println("Массив, после замены местами: " + Arrays.toString(array));

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();

        Box<Apple> box1 = new Box<>(apple1, apple2);
        Box<Orange> box2 = new Box<>(orange1, orange2, orange3, orange4);
        box1.add(apple3);
        box2.add(orange1);

        System.out.println(box1.compare(box2));
        if (box1.compare(box2)) {
            System.out.println("Коробки равны по весу");
        } else System.out.println("Коробки не равны по весу");

        Box<Apple> box3 = new Box<>();
        box1.shift(box3);
    }

    private static void swapElements(Object[] array, int num1, int num2) {
        Object t = array[num1];
        array[num1] = array[num2];
        array[num2] = t;
    }
}