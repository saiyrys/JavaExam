import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    public static void main(String[] args) {

        Map<String, List<String>> phoneBook = new HashMap<>();


        addContact(phoneBook, "Иванов", "123-456-789");
        addContact(phoneBook, "Петров", "111-222-333");
        addContact(phoneBook, "Иванов", "999-888-777");
        addContact(phoneBook, "Сидоров", "555-666-777");

        List<Map.Entry<String, List<String>>> sortedContacts = sortByPhoneCount(phoneBook);

        for (Map.Entry<String, List<String>> entry : sortedContacts) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void addContact(Map<String, List<String>> phoneBook, String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    }

    private static List<Map.Entry<String, List<String>>> sortByPhoneCount(Map<String, List<String>> phoneBook) {
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        Collections.sort(entries, (entry1, entry2) ->
                Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        return entries;
    }
}
