package gr.aueb.cf.testbed.projectsA.projects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Project03 {
    public static void main(String[] args) throws IOException {

        int bufSize = 8192;
        int len = 0;
        int n = 0;

        char[] buf = new char[bufSize];
        //PLEASE FIX PATH BEFORE RUNNING
        String filePath = "C:\\Users\\30697\\Desktop\\words.txt";
        BufferedReader bf = new BufferedReader(new FileReader(filePath));
        StringBuilder sb = new StringBuilder();


        int[][] chars = new int[256][2];
        //Array fill with zeros
//        for (int[] row : chars) {
//            Arrays.fill(row, 0);
//        }

        //Read from Bufferead until reaches bufsize
        while ((n = bf.read(buf,0,bufSize)) != -1) {
            sb.append(buf, 0, n);
            len +=n;
        }
        //System.out.println(sb.length());

        int counter = 0;
        for (int i=0; i< sb.length(); i++) {
            for (int j=0; j < chars.length; j++) {
                if (((int)(sb.charAt(i)) == chars[j][0])) {
                    chars[j][1]++;
                    break;
                } else if (chars[j][0] == 0){
                    chars[counter][0] = sb.charAt(i);
                    chars[counter][1]++;
                    counter++;
                    break;
                } else {
                }
            }

        }

            Arrays.sort(chars, (a1, a2) -> a2[0] - a1[0]);

        for (int i=0; i< chars.length; i++) {
            System.out.println("Character: "+(char)chars[i][0] +" | ASCII: "+chars[i][0] + " | Count: " + chars[i][1]);
        }


    }


}



