package ru.homeworks.abatsanov;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String[] groupNames = {"Семья", "Работа", "Футбол"};
    static int actionNumber;
    static String userInput;
    static Scanner scanner = new Scanner(System.in);
    static List<String> actionsList = Arrays.asList(
            "1. Создать пропущенный вызов",
            "2. Вывести на экран пропущенные вызовы",
            "3. Вывести телефонный справочник на экран",
            "0. Выход");

    private static void fillMyPhoneBook(PhoneBook phoneBook) {
        phoneBook.addContacts(new Contact("Tom", "111"),
                "Работа", "Футбол");
        phoneBook.addContacts(new Contact("Jim", "222"),
                "Работа");
        phoneBook.addContacts(new Contact("Kate", "333"),
                "Семья");
        phoneBook.addContacts(new Contact("Bob", "444"),
                "Семья", "Футбол");
        phoneBook.addContacts(new Contact("Bill", "555"),
                "Футбол");
        phoneBook.addContacts(new Contact("Sam", "666"),
                "Работа", "Футбол");
        phoneBook.addContacts(new Contact("Ann", "777"),
                "Работа");
        phoneBook.addContacts(new Contact("John", "888"),
                "Работа", "Футбол");
        phoneBook.addContacts(new Contact("Ray", "999"),
                "Футбол");
    }

    static boolean hasInputOnlyDigits(String str) {
        return str.matches("[\\d]+");
    }

    static void printInputError() {
        System.out.println(
                "Введено некорректное значение, попробуйте еще раз!");
    }

    public static void main(String[] args) {
        PhoneBook myPhoneBook = new PhoneBook();
        MissedCalls missedCallsList = new MissedCalls();
        myPhoneBook.addGroups(groupNames);
        fillMyPhoneBook(myPhoneBook);

        while (true) {
            System.out.println("Выберите действие:");
            for (String action : actionsList) {
                System.out.println(action);
            }
            userInput = scanner.nextLine();
            if (!hasInputOnlyDigits(userInput)) {
                printInputError();
            } else {
                actionNumber = Integer.parseInt(userInput);
                switch (actionNumber) {
                    case 0:
                        System.out.println("Спасибо за внимание!");
                        scanner.close();
                        return;
                    case 1:
                        System.out.println(
                                "Введите номер телефона пропущенного вызова:");
                        userInput = scanner.nextLine();
                        missedCallsList.createMissedCall(userInput);
                        break;
                    case 2:
                        System.out.println(missedCallsList.toString(myPhoneBook));
                        break;
                    case 3:
                        myPhoneBook.printPhoneBook();
                        break;
                    default:
                        printInputError();
                        break;
                }
            }
        }
    }
}

