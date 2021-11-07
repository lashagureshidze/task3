package com.epam.task3.recipient.utils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MessageDB {

    private static final List<String> db = Collections.synchronizedList(new LinkedList<>());

    public static void addMessage(String message) {
        db.add(message);
    }

    public static List<String> getAndClearMessages() {
        List<String> copy = new LinkedList<>(db);
        db.clear();
        return copy;
    }
}
