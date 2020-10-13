package homeWork6;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void run(int a) {
        if (a >= 0 && a <= 500) {
            super.run(a);
        } else {
            System.out.println(name + " столько не пробежит");
        }
    }

    @Override
    public void swim(int b) {
        if (b >= 0 && b <= 10) {
            super.swim(b);
        } else {
            System.out.println(name + " столько не проплывет");
        }
    }
}
