package ru.homeworks.abatsanov;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBookTest {
    private Map<String, List<Contact>> expected;
    private PhoneBook actual;
    private String[] groupName;
    private Contact contact;
    @BeforeEach
    public void setUp () {
        expected = new HashMap<>();
        actual = new PhoneBook();
        groupName = new String[]{"Футбол"};
        contact = new Contact("Tom", "55555");
    }

    @Test
    public void testAddGroups () {
        // given: initialized in setUp()
        // when:
        expected.put("Футбол", new ArrayList<>());
        actual.addGroups(groupName);
        // then:
        Assertions.assertEquals(expected.toString(), actual.toString());
    }
    @Test
    public void testAddContacts () {
        // given: initialized in setUp() +
        List<Contact> list = new ArrayList<>();
        list.add(contact);
        // when:
        expected.put("Футбол", list);
        actual.addGroups(groupName);
        actual.addContacts(contact, groupName);
        // then:
        Assertions.assertEquals(expected.toString(), actual.toString());
    }
    @Test
    public void testFindContactByPhoneNumber () {
        // given: initialized in setUp()
        // when:
        actual.addGroups(groupName);
        actual.addContacts(contact, groupName);
        Contact foundContact = actual.findContactByPhoneNumber("55555");
        // then:
        Assertions.assertEquals(contact.toString(), foundContact.toString());
    }
}
