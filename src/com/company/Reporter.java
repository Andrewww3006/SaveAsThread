package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reporter implements Runnable{
    ArrayList<SaveAsThread> threadArrayList = new ArrayList<>();
    private Object SaveAsThread;

    public Object getSaveAsTread(){
        return SaveAsThread;
    }
    public void setThreadArrayList(ArrayList<SaveAsThread> threadArrayList) {
        this.threadArrayList=threadArrayList;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " started");
        try(FileWriter writer = new FileWriter("Reporter.bin", false))
        {

            // запись всей строки
            for (SaveAsThread j : threadArrayList) {
               Thread.currentThread().
                       writer.write(k + ",");
            }

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        System.out.println(Thread.currentThread().getName()+" finished");

    }
}
