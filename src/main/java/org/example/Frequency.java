package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Logger;

public class Frequency {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger("com.api.jar");
        String filePath = "" + "C:/Users/Tringapps-User11/Frequency-Assignment6.txt";
        File file = new File(filePath);
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
        String s = "Total word count : " + count;
        logger.info(s);
        PriorityQueue q = new PriorityQueue();
        q.sorted(freqCount);
        logger.info("Printing sorted queue");
        q.print();
    }
}