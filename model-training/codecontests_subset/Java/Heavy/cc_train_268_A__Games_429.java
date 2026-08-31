import java.util.Scanner;
import java.util.*;

public class Practice_ser3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=0;
       int [][]arr=new int[a][a];
        for (int i = 0; i < a; i++) {
            arr[i][0]= sc.nextInt();
            arr[i][1]= sc.nextInt();
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {

                //  System.out.println(arr[j]);
                // System.out.println(arr[i][j]);
                if (arr[i][0] == arr[j][1]) {
                    //System.out.println("n 1");
                    b++;
                }
              //  if (arr[i][1] == arr[j][0]) {
                   // b++;
              //  }
            }


        }
        System.out.println(b);



    }
}