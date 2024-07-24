package com.company;
import java.io.FileWriter;
import java.io.IOException;

public class SaveAsThread implements Runnable{
    private int id;
    private int[] intArray;
    SaveAsThread(int id, int[] intArray) {
        this.id = id;
        this.intArray = intArray;

    }
    public int[] getIntArray(){
        return intArray;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        try(FileWriter writer = new FileWriter("IntArrays" + id + ".bin", false))
        {
            // запись всей строки
            for (int j : intArray) writer.write(j + ",");

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        System.out.println(Thread.currentThread().getName()+" finished");
    }
}
