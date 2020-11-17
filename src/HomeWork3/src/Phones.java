import java.util.HashMap;
import java.util.HashSet;

class PhoneBook {
    public static void main(String[] args) {

        Phones phoneBook = new Phones();

        phoneBook.add("Ivanov", 1234567, 0, 0,0);
        phoneBook.add("Petrov", 1111111, 2222222, 3333333,0);
        phoneBook.add("Petrov", 4444444, 5555555, 6666666,7777777);
        phoneBook.add("Sidorov", 2323232, 5454545, 8787877,0);

        System.out.println(phoneBook.phoneBook1);

        phoneBook.get("Petrov");
    }
}

class Phones {

    HashMap<String, HashSet<Integer>> phoneBook1;

    Phones() {
        this.phoneBook1 = new HashMap<>();
    }

    void add(String name, int num1, int num2, int num3, int num4) {
        HashSet<Integer> phoneBook = phoneBook1.getOrDefault(name, new HashSet<>());
        phoneBook.add(num1);
        phoneBook.add(num2);
        phoneBook.add(num3);
        phoneBook.add(num4);

        phoneBook1.put(name, phoneBook);
    }

    void get(String name) {

        System.out.println("Контакт " + name + ": " + phoneBook1.getOrDefault(name, new HashSet<>()));
    }
}
