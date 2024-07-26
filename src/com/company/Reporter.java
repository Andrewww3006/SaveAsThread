package com.company;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class Reporter implements Runnable{
    private  ArrayList<SaveAsThread> threadArrayList = new ArrayList<>();
    Reporter(ArrayList<SaveAsThread> threadArrayList){
        this.threadArrayList = threadArrayList;
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
                //j.start();
                for (int k: j.getIntArray())
                writer.write(k + ",");
                writer.write("\n");

            }

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        System.out.println(Thread.currentThread().getName()+" finished");

    }
}
