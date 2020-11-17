import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class DublicateWords {
    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();

        names.add("Привет");
        names.add("Hello");
        names.add("Java");
        names.add("Степь");
        names.add("Пока");
        names.add("Java");
        names.add("Привет");
        names.add("Java");
        names.add("Мир");
        names.add("Hello");

        System.out.println("Вся коллекция слов: "+names+"\n");

        Set<String> stringSet = new LinkedHashSet<>(names);
        System.out.println("Уникальные слова: "+stringSet+"\n");

        HashMap<String, Integer> dublicateWords = new HashMap<>();

        for (String i : names) {
            Integer  doubleName = dublicateWords.get(i);
            dublicateWords.put(i, doubleName == null ? 1 : doubleName + 1);
        }
        System.out.println(dublicateWords);
    }
}

