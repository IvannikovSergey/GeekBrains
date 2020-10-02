package homeWork3;

import java.util.Random;
import java.util.Scanner;

class guessGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int guessNumber = random.nextInt(10);
        do {
            int userNumber = -1;
            int countGuess = 3;
            System.out.println("Угадайте загаданное число от 0 до 9: ");
            System.out.println("У Вас есть 3 попытки");
            while (countGuess != 0 && userNumber != guessNumber) {
                userNumber = sc.nextInt();
                if (userNumber < guessNumber) {
                    countGuess--;
                    System.out.println("Загаданное число больше");
                    System.out.println("У вас осталось " + countGuess + " попыток");
                } else if (userNumber > guessNumber) {
                    countGuess--;
                    System.out.println("Загаданное число меньше");
                    System.out.println("У вас осталось " + countGuess + " попыток");
                } else {
                    System.out.println();
                }
            }
            System.out.println("Вы " +
                    ((userNumber == guessNumber) ? "выиграли! Поздравляем!" : "к сожалению проиграли. " + "Загаданное число: " + guessNumber));
            System.out.println();
            System.out.println("Вы хотите сыграть еще раз? Нажмите 1 - Да и 0 - Нет");
        } while (sc.nextInt() == 1);
    }
}
