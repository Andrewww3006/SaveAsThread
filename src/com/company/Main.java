package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int id1 = 1;
        int[] intArray1 = new int[]{1,2,3};
        int id2 = 2;
        int[] intArray2 = new int[]{5,8,9};
        int id3 = 3;
        int[] intArray3 = new int[]{2,5,7};

        Thread myThread1 = new Thread(new SaveAsThread(id1, intArray1), "SaveAsThread1");
        myThread1.start();
        Thread myThread2 = new Thread(new SaveAsThread(id2, intArray2), "SaveAsThread2");
        myThread2.start();
        Thread myThread3 = new Thread(new SaveAsThread(id3, intArray3), "SaveAsThread3");
        myThread3.start();


    }
}