package ru.geekbrains.lesson_2;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        task1();

        task2();

        task3();
        task4();
    }

    public static void task1(){
        System.out.println("task1");
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr1[i] == 1 ? 0 : 1;
        }
        printArr(arr1);
    }
    public static void task2(){
        System.out.println("task2");
        int[] arr2 = new int[8];
        arr2[0]=1;
        for (int i = 1; i < arr2.length; i++){
            arr2[i] = arr2[i-1]+3;
        }

        printArr(arr2);
    }
    public static void task3() {
        System.out.println("task3");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        int[] resultArr = task3a( arr3 );
        printArr( resultArr );
    }


    public static int[] task3a(int[] arr3){
        for (int i = 0; i < arr3.length; i++){
            if (arr3[i]<6){
                arr3[i]=arr3[i]*2;
            }
        }

    return arr3;
    }

    public static void task4(){
        System.out.println("task4");
        int[] arr4 = {1, 3, 11, 16, 777, 589};
        System.out.println("max:" + task4Max(arr4));
        System.out.println("max:" + task4Min(arr4));
    }
    public static int task4Max(int[] arr4) {
        int max = arr4[0];
        for (int i = 1; i < arr4.length; i++) {
            if (arr4[i] > max) {
                max = arr4[i];
            }
        }
        return max;
    }

    public static int task4Min(int[] arr4){
            int min = arr4[0];
            for (int i=1; i < arr4.length; i++){
                if (arr4[i] < min) {
                    min = arr4[i];
                }
            }
            return min;
    }

    public static void printArr(int[] arr) {
        for (int i=0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
