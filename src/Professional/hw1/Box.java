package Professional.hw1;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits;

    Box(T... fruits) {
        this.fruits = new ArrayList<T>(Arrays.asList(fruits));
    }

    public void add(T... fruits) {
        this.fruits.addAll(Arrays.asList(fruits));
    }

    public void remove(T... items) {
        for (T item : items) this.fruits.remove(item);
    }

    private void clear() {
        fruits.clear();
    }

    private float getWeight() {
        if (fruits.size() == 0) return 0;
        float weight = 0;
        for (T fruit : fruits) {
            weight = weight + fruit.getWeight();
        }
        return weight;
    }

    boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    void shift(Box<? super T> box) {
        box.fruits.addAll(this.fruits);
        clear();
    }
}