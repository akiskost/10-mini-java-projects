package gr.aueb.cf.testbed.projectsA.projects;

import java.util.Arrays;

public class Project04 {

    public static void main(String[] args) {

        int[][] parkTime = {{1012, 1136}, {1317, 1417}, {1015, 1020}};
        int[][] parkTime2 = new int[6][2];
        int pos = 0;
        int maxCars = 0;

        for (int i = 0; i < parkTime.length; i++) {
            for (int j = 0; j < parkTime[i].length; j++) {
                if (j == 0) {
                    parkTime2[pos][0] = parkTime[i][0];
                    parkTime2[pos][1] = 1;
                } else {
                    parkTime2[pos][0] = parkTime[i][1];
                    parkTime2[pos][1] = 0;
                }
                pos++;
            }
        }

        Arrays.sort(parkTime2, (a1,a2) -> a1[0] - a2[0] );

        for (int i = 0; i < parkTime2.length; i++) {
            for (int j = 0; j < parkTime2[i].length; j++) {

                System.out.print(parkTime2[i][j]+" ");
            }
            System.out.println();
        }



        for (int i = 0; i < parkTime2.length; i++) {
            if ((parkTime2[i][1] == 1) && (parkTime2[i++][1] == 1)) {
                maxCars++;
            }
        }
        System.out.println("MAX CARS: " + maxCars);
    }
}

