package org.example;

import java.util.Map;
import java.util.logging.Logger;

class PriorityQueue {
    Logger logger = Logger.getLogger("com.api.jar");
    private Node rootNode = null;

    public void add(String key, int value) {
        Node newNode = new Node(key, value);
        int flag = 0;
        if (rootNode == null) {
            rootNode = newNode;
        } else if (value >= rootNode.getValue()) {
            newNode.setNext(rootNode);
            rootNode = newNode;
        } else {
            Node temp = rootNode;
            while (temp.getNext() != null) {
                if (value >= temp.getNext().getValue()) {
                    newNode.setNext(temp.getNext());
                    temp.setNext(newNode);
                    flag = 1;
                    break;
                }
                temp = temp.getNext();
            }
            if (flag == 0) {
                temp.setNext(newNode);
            }
        }
    }

    public void sorted(Map<String, Integer> frequency) {
        for (Map.Entry<String, Integer> m : frequency.entrySet()) {
            add(m.getKey(), m.getValue());
        }
    }

    public void print() {
        Node temp = rootNode;
        while (temp != null) {
            logger.info(temp.getKey() + " : " + temp.getValue());
            temp = temp.getNext();
        }
    }
}
