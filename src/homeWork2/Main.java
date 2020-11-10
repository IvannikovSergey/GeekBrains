package homeWork2;

public class Main {
    public static void main(String[] args) {
        String[][] arr = new String[][]{{"1", "0", "0", "1"}, {"0", "1", "1", "0"}, {"0", "1", "1", "0"}, {"1", "0", "0", "1"}};

        try {
            try {
                int result = MyArray.sumElementsOfArray(arr);
                System.out.println("Сумма элементов массива равна: " + result);

            } catch (MyArraySizeException e) {
                System.out.println("Ошибка! Размер массива превышен!");
            }
        } catch (MyArrayDataException e) {
            System.out.println("Неправильное значение элемента массива в ячейке: " + e.i + "x" + e.j);
        }
    }
}
