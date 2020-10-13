package homeWork6;

public class Animal {
    String name;
    int runDistance;
    int swimDistance;

    public Animal(String name) {
        this.name = name;
    }

    public void run(int a) {
        this.runDistance = a;
        System.out.println(name + " пробежал " + runDistance + " метров");

    }

    public void swim(int b) {
        this.swimDistance = b;

        System.out.println(name + " проплыл " + swimDistance + " метров");
    }
}

