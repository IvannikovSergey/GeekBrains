package HW5;

public class Array {

    private static final int size = 10000000;
    private static final int n = 2; //
    private static final int h = size / n;
    private static final float[] arr = new float[size];

    public static void main(String[] args) {
        Array myArray = new Array();
        myArray.firstArr();
        myArray.secondArr();
    }

    private static void fill(float[] arr, float v) {
    }


    private void secondArr() {

        Thread[] threads = new Thread[n];


        Array.fill(arr, 1.0f);
        long a = System.currentTimeMillis();


        float[][] newArr = new float[n][h];
        for (int i = 0; i < n; i++) {
            System.arraycopy(arr, i * h, newArr[i], 0, h);
        }

        long split = System.currentTimeMillis();
        System.out.println("Время разделения массива " + (split - a) + " мсек");


        for (int i = 0; i < n; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> calcSecondArr(newArr, finalI));
            threads[i].start();
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long concat = System.currentTimeMillis();


        for (int i = 0; i < n; i++) {
            System.arraycopy(newArr[i], 0, arr, i * h, h);
        }
        long end = System.currentTimeMillis();
        System.out.println("Время склейки массива " + (end - concat) + " мсек");
        System.out.println("Время выполнения второго метода " + (end - a) + " мсек");
    }


    private void calcSecondArr(float[][] arr, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < h; i++) {
            arr[n][i] = (float) (arr[n][i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long end = System.currentTimeMillis();
        System.out.println("Время выполнения " + (n + 1) + "-го потока " + (end - start) + " мсек");
    }

    private void firstArr() {

        Array.fill(arr, 1.0f);
        long a = System.currentTimeMillis();


        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long end = System.currentTimeMillis();
        System.out.println("Время выполнения первого метода " + (end - a) + " мсек");
    }
}
