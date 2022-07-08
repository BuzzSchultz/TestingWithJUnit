package ru.homeworks.abatsanov;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class MissedCalls {
    final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("EEE, dd-MM-yyyy ' в ' HH:mm:ss");
    private Map<LocalDateTime, String> missedCalls = new TreeMap<>();

    public void createMissedCall(String phoneNumber) {
        missedCalls.put(LocalDateTime.now(), phoneNumber);
    }

    public String toString(PhoneBook phoneBook) {
        System.out.printf("Пропущенные вызовы:%n");
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<LocalDateTime, String> missedCall : missedCalls.entrySet()) {
            Contact contact = phoneBook.findContactByPhoneNumber(missedCall.getValue());
            sb
                    .append("\t")
                    .append(missedCall.getKey().format(formatter))
                    .append("\t")
                    .append("Вам звонил - ")
                    .append(contact != null ? contact.getName() : missedCall.getValue())
                    .append("\n");
        }
        return sb.toString();
    }
}

