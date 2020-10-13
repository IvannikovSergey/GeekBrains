package homeWork6;

public class Cat extends Animal {


    public Cat(String name) {
        super(name);
    }

    @Override
    public void run(int a) {
        if (a >= 0 && a <= 200) {
            super.run(a);
        } else {
            System.out.println(name + " столько не пробежит");
        }
    }

    @Override
    public void swim(int b) {
        if (b > 0) {
            System.out.println(name + " не умеет плавать!");
        }
    }
}

