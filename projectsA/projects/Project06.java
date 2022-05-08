package gr.aueb.cf.testbed.projectsA.projects;

public class Project06 {

    public static void main(String[] args) {

        int[] arr =  {-2, 1, -3, 4,-1, 2, 1,-5, 4};


        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        int start = 0;
        int end = 0;
        int s = 0;

        for (int i=0; i<arr.length; i++) {
            maxEndingHere = maxEndingHere + arr[i];
            System.out.println();
            System.out.println("i "+i);

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = s;
                end = i;
            }

            if (maxEndingHere < 0) {

                maxEndingHere = 0;
                s = i +1;
            }
            System.out.println("start "+start);
            System.out.println("maxSoFar "+maxSoFar);
            System.out.println("maxEndingHere "+maxEndingHere);
            System.out.println("end "+end);
            System.out.println();
        }

        System.out.println("Maximum contiguous sum is "
                + maxSoFar);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);




    }




}
