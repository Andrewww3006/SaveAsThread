package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int id1 = 1;
        int[] intArray1 = new int[]{1,2,3};
        int id2 = 2;
        int[] intArray2 = new int[]{5,8,9};
        int id3 = 3;
        int[] intArray3 = new int[]{2,5,7};

        SaveAsThread myThread1 = new SaveAsThread("SaveAsThread1", id1, intArray1);
        SaveAsThread myThread2 = new SaveAsThread("SaveAsThread2", id2, intArray2);
        SaveAsThread myThread3 = new SaveAsThread("SaveAsThread3", id3, intArray3);
        //Thread myThread1 = new Thread(new SaveAsThread(id1, intArray1), "SaveAsThread1");
        myThread1.start();
        //Thread myThread2 = new Thread(new SaveAsThread(id2, intArray2), "SaveAsThread2");
        myThread2.start();
        //Thread myThread3 = new Thread(new SaveAsThread(id3, intArray3), "SaveAsThread3");
        myThread3.start();
        ArrayList<SaveAsThread> threadArrayList = new ArrayList<>();
        threadArrayList.add(myThread1);
        threadArrayList.add(myThread2);
        threadArrayList.add(myThread3);
        Thread reporterThread = new Thread(new Reporter(threadArrayList), "ReporterThread");
        reporterThread.start();



    }
}
