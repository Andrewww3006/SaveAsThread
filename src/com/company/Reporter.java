package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reporter<ArrayListList> implements Runnable{
    ArrayList<Thread> threadArrayList = new ArrayList<>();

    public void setThreadArrayList(ArrayList<Thread> threadArrayList) {
        this.threadArrayList=threadArrayList;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " started");
        try(FileWriter writer = new FileWriter("Reporter.bin", false))
        {
            // запись всей строки
            for (Thread j : threadArrayList) writer.write(j + ",");

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        System.out.println(Thread.currentThread().getName()+" finished");

    }
}
