package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Node{
     public String key;
     public int value;
     public Node next = null;
     public Node(String key, int value){
         this.key = key;
         this.value = value;
     }
}

class PriorityQueue{
    private Node rootNode  = null;

    public void add(String key, int value){
        Node newNode = new Node(key, value);
        int flag = 0;
        if (rootNode == null){
            rootNode = newNode;
        }else if (value >= rootNode.value){
            newNode.next = rootNode;
            rootNode = newNode;
        } else{
            Node temp = rootNode;
            while(temp.next != null){
                if(value >= temp.next.value){
                    newNode.next = temp.next;
                    temp.next = newNode;
                    flag = 1;
                    break;
                }
                temp = temp.next;
            }
            if (flag == 0){
                temp.next = newNode;
            }
        }
    }
    public void sorted(HashMap<String, Integer> frequency){
        for (Map.Entry m : frequency.entrySet()) {
            add((String)m.getKey(), (int)m.getValue());
        }
    }

    public void print(){
        Node temp = rootNode;
        while(temp != null){
            System.out.println(temp.key + " " + temp.value);
            temp = temp.next;
        }
    }
}
public class Frequency {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Tringapps-User11\\Frequency-Assignment6.txt");
        Scanner words = new Scanner(file);
        int count = 0;
        HashMap<String, Integer> freqCount = new HashMap<>();
        while(words.hasNext()){
            String word = words.next();
            if (freqCount.containsKey(word)) {
                freqCount.put(word, freqCount.get(word) + 1);
            }else{
                freqCount.put(word, 1);
            }
            count += 1;
        }
        System.out.println("Total word count : " + count);
        PriorityQueue q = new PriorityQueue();
        q.sorted(freqCount);
        System.out.println("Printing sorted queue");
        q.print();
    }
}