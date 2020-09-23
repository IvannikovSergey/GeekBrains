package homeWork1;

public class JavaApp {
    public static void main(String[] args) {
        byte b = 100;
        short s = 200;
        int i = 10;
        long l = 20L;
        float f = 20.0f;
        double d = 30.0;
        char c = 'c';
        boolean bool = true;
        String st = "Hello";

        System.out.println(summ(1.0f, 2.0f, 100.0f, 4.0f));
        System.out.println(isInRange(12, 5));
        positiveOrNegative(-20);
        System.out.println(isNegativeOrPositive(-10));
        userName("Сергей");
    }

    public static int summ(float a, float b, float c, float d) {
        return (int) (a * (b + (c / d)));
    }

    public static boolean isInRange(int a, int b) {
        int c = a + b;
        if (c >= 10 && c <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void positiveOrNegative(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean isNegativeOrPositive(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void userName(String name) {
        System.out.println("Привет, " + name + "!");
    }
}
