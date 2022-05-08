package gr.aueb.cf.testbed.projectsA.projects;

import java.io.*;
import java.util.*;

public class Project01 {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        int input;
        String fileDir = "";
        String fileSaveDir = "";
        int numbersInFile = 0;

        System.out.println("Welcome! Set the file paths and number size in the program");

        //MAKE SURE YOUR FILE PATHS ARE CORRECT
        fileDir = "C:\\Users\\30697\\Desktop\\49_random_numbers.txt";
        fileSaveDir = "C:\\Users\\30697\\Desktop\\49_random_numbers_filtered.txt";
        numbersInFile = 12;

        //CREATES NEW FILE FROM SCRATCH, UNCOMMENT TO RUN
        //createsNewTextFile(fileDir, numbersInFile);

        int[] data = arrayReadInit(fileDir, numbersInFile);
        PrintStream ps = new PrintStream(new FileOutputStream(fileSaveDir, true));

        System.out.println();
        System.out.println("Numbers in file:");
        arrayPrint(data);
        System.out.println();
        System.out.println("Sorted numbers in file:");

        Arrays.sort(data);
        arrayPrint(data);

        //sorted data list
        ArrayList<Integer> dataSorted = new ArrayList<>();

        for (int datum : data) {
            dataSorted.add(datum);
        }
        //System.out.println(dataSorted);

        int y = 6;
        int[] groupOf6 = new int[6];
        for (int i = 0; i <= dataSorted.size() - y; i++) {
            groupOf6[0] = dataSorted.get(i);
            for (int j = i + 1; j <= dataSorted.size() - y + 1; j++) {
                groupOf6[1] = dataSorted.get(j);
                for (int k = j + 1; k <= dataSorted.size() - y + 2; k++) {
                    groupOf6[2] = dataSorted.get(k);
                    for (int l = k + 1; l <= dataSorted.size() - y + 3; l++) {
                        groupOf6[3] = dataSorted.get(l);
                        for (int m = l + 1; m <= dataSorted.size() - y + 4; m++) {
                            groupOf6[4] = dataSorted.get(m);
                            for (int n = m + 1; n < dataSorted.size(); n++) {
                                groupOf6[5] = dataSorted.get(n);

                                if ((isEven(groupOf6)) && (isOdd(groupOf6)) &&
                                        (isContinuous(groupOf6)) && (isSameEnding(groupOf6)) && (isSameTen(groupOf6))) {


                                     for (int co = 0; co < groupOf6.length; co++){
                                      // System.out.print(groupOf6[co]+" ");
                                       ps.print(groupOf6[co]+" ");
                                     }
                                        //System.out.println();
                                        ps.println();
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    //Creates text file with random numbers 1-49
    public static void createsNewTextFile(String fileDir, int numbersInFile) throws FileNotFoundException {


        for (int i = 0; i < numbersInFile; i++) {
            int num = (int) (Math.random() * 49) + 1;
            //System.out.print(num + " ");
            PrintStream ps = new PrintStream(new FileOutputStream(fileDir, true), true);
            ps.print(num + " ");
            ps.close();

        }


    }

    //Reads ints from file and stores in array, returns the array
    public static int[] arrayReadInit(String fileDir, int arrayLength) throws FileNotFoundException {
        //READS FILE + CREATES ARRAY
        Scanner in = new Scanner(new File(fileDir));

        int[] data = new int[arrayLength];
        int i = 0;
        while (in.hasNextInt()) {
            data[i] = in.nextInt();
            i++;
        }

        return data;


    }

    //prints an array
    public static void arrayPrint(int[] inArray) {
        for (int item : inArray) {
            System.out.print(item + " ");
        }
    }

    //isEven
    public static boolean isEven(int[] arr) {
        int counter = 0;
        boolean result = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                counter++;
            }
        }

        if ((counter > 0) && (counter <= 4)) {
            result = true;
        }

        return result;
    }

    //isOdd
    public static boolean isOdd(int[] arr) {
        int counter = 0;
        boolean result = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                counter++;
            }
        }

        if ((counter > 0) && (counter <= 4)) {
            result = true;
        }

        return result;
    }

    //να περιέχει το πολύ 2 συνεχόμενους,
    public static boolean isContinuous(int[] arr) {

        boolean result = false;

        for (int i = arr.length - 1; i >= 1; i--) {
            if (arr[i] == arr[i - 1]) {
                result = true;
                break;
            }
        }

        return result;
    }

    //να περιέχει το πολύ 3 ίδιους λήγοντες,
    public static boolean isSameEnding(int[] arr) {
        int counter = 1;
        boolean result = false;

        for (int i = 1; i < arr.length; i++) {
            if ((arr[0] % 10) == (arr[i] % 10)) {
                counter++;
            }
        }

        if (counter <= 3) {
            result = true;
        }


        //System.out.println(counter);
        return result;


    }

    //να περιέχει το πολύ 3 αριθμούς στην ίδια δεκάδα.
    public static boolean isSameTen(int[] arr) {
        int counter = 1;
        boolean result = false;

        for (int i = 1; i < arr.length; i++) {
            if ((arr[0] / 10) == (arr[i] / 10)) {
                counter++;
            }
        }

        if (counter <= 3) {
            result = true;
        }



        return result;


    }





}




//        System.out.println("(1) To choose a file");
//        System.out.println("(2) To create a file with random numbers");
//        //System.out.println("(3) To load default values (Desktop Location/12 random numbers");
//        input = in.nextInt();
//
//        do {
//
//            switch (input) {
//                case 1:
//                    System.out.println("Enter the filepath of the read file: ");
//                    fileDir = in.next();
//                    System.out.println("Read file directory: " + fileDir);
//                    break;
//                case 2:
//                    System.out.println("Enter value of total numbers (min. 6 / max.49)");
//                    while ((numbersInFile < 6) || (numbersInFile > 49)) {
//                        numbersInFile = in.nextInt();
//                        System.out.println("Invalid number. Try again.");
//                    }
//                    fileDir = "C:\\Users\\30697\\Desktop\\49_random_numbers.txt";
//                    System.out.println("Read file directory: " + fileDir);
//                    break;
//                case 3:
//              break;
//default:
//        System.out.println("Invalid choice.");
//        break;
//        }
//
//        } while ((input<0) ||(input>2));