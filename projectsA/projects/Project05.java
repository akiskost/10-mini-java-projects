package gr.aueb.cf.testbed.projectsA.projects;

import java.util.Arrays;

public class Project05 {

    public static void main(String[] args) {

        int[] a = {0, 1, 4, 4, 4, 6, 7, 8, 8, 8, 8, 9};
        int key = 8 ;
        int[] result = getLowAndHighIndexOf(a,key);



        if (result[0] != 0) {
            System.out.println("MIN pos: "+result[0]+" Max pos: "+result[1]);
        } else {
            System.out.println("Key not found in arr.");
        }
    }



    public static int[] getLowAndHighIndexOf(int[] arr, int key) {

        int[] result = new int[2];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == key) {

                count++;
//                System.out.println("CCCCC "+count);

                for (int j = i; j < arr.length; j++) {

                    if (arr[j] == key) {
                        result[1] = j + 1;
                    }
                }

                result[0] = (result[1] - count) + 1;
            }
        }
        return result;
    }

}
