package gr.aueb.cf.testbed.projectsA.projects;

public class Project07 {

    public static void main(String[] args) {

        int[][] arr1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] arr2;
        int[][] arr3;



        System.out.println("1st arr1 elem ="+arr1[0][0]);
        System.out.println("arr2 = arr using shallowCopy");
        arr2 = shallowCopy(arr1);
        System.out.println("1st arr2 elem ="+arr2[0][0]);
        System.out.println("1st arr2 elem replaced with value 20");
        arr2[0][0] = 20;
        System.out.println("1st arr1 elem ="+arr1[0][0]);
        System.out.println("1st arr2 elem ="+arr2[0][0]);
        System.out.println("oh no, how did that happen?!. Let's reset. arr1[0][0] = 1;");
        arr1[0][0] = 1;

        System.out.println();

        System.out.println("1st arr1 elem ="+arr1[0][0]);
        System.out.println("arr3 = arr using deepCopy");
        arr3 = deepCopy(arr1);
        System.out.println("1st arr3 elem ="+arr3[0][0]);
        System.out.println("1st arr3 elem replaced with value 20");
        arr3[0][0] = 20;
        System.out.println("1st arr1 elem ="+arr1[0][0]);
        System.out.println("1st arr3 elem ="+arr3[0][0]);
        System.out.println("cool, now works!");

    }








    public static int[][] deepCopy(int[][] arr) {
        int[][] returnedArray = new int[arr.length][]; //Deep copy

        for (int i =0; i< arr.length;i++) {
            returnedArray[i] = new int[arr[i].length];

            for (int j =0; j< arr[i].length;j++){
                returnedArray[i][j] = arr[i][j];
            }
        }
        return returnedArray;
    }






    public static int[][] shallowCopy(int[][] arr) {

        int[][] returnedArray = arr;

        return returnedArray;
    }

}







