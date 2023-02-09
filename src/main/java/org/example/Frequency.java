package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Node{
     private String key;
     private int value;
     private Node next = null;
     public Node(String key, int value){
         this.key = key;
         this.value = value;
     }

     public String getKey(){
         return key;
     }

     public int getValue(){
         return value;
     }
     public void setNext(Node next){
         this.next = next;
     }

     public Node getNext(){
         return next;
     }
}

class PriorityQueue{
    private Node rootNode  = null;

    public void add(String key, int value){
        Node newNode = new Node(key, value);
        int flag = 0;
        if (rootNode == null){
            rootNode = newNode;
        }else if (value >= rootNode.getValue()){
            newNode.setNext(rootNode);
            rootNode = newNode;
        } else{
            Node temp = rootNode;
            while(temp.getNext() != null){
                if(value >= temp.getNext().getValue()){
                    newNode.setNext(temp.getNext());
                    temp.setNext(newNode);
                    flag = 1;
                    break;
                }
                temp = temp.getNext();
            }
            if (flag == 0){
                temp.setNext(newNode);
            }
        }
    }
    public void sorted(Map<String, Integer> frequency){
        for (Map.Entry<String, Integer> m : frequency.entrySet()) {
            add(m.getKey(), m.getValue());
        }
    }

    public void print(){
        Node temp = rootNode;
        while(temp != null){
            System.out.println(temp.getKey() + " : " + temp.getValue());
            temp = temp.getNext();
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