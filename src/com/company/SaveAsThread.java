package com.company;
import java.io.FileWriter;
import java.io.IOException;

public class SaveAsThread extends Thread{
    private int id;
    private int[] intArray;
    SaveAsThread(String name, int id, int[] intArray) {
        super(name);
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
            for (int j : intArray){
                writer.write(j + ",");
                getIntArray();
            }


            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        System.out.println(Thread.currentThread().getName()+" finished");
    }
}
