
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class JavaApplication24 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int[] arr = new int[a];
        int[] arr2 = new int[a - 1];

        for (int i = 0; i < a; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < a - 1; i++) {
            arr2[i] = in.nextInt();

        }
        Arrays.sort(arr);
        Arrays.sort(arr2);
        int i;
        for (i = 0; i < a - 1; i++) {
            if (arr2[i] != arr[i]) {
                System.out.println(arr[i]);
                break;
            }
        }
        if (i == arr2.length) {
            System.out.println(arr[arr.length - 1]);
        }
        arr=arr2;
        arr2 = new int[a - 2];
       
        for (i = 0; i < a - 2; i++) {
            arr2[i] = in.nextInt();

        }
         Arrays.sort(arr2); 
        for (i = 0; i < a - 2; i++) {
            if (arr2[i] != arr[i]) {
                System.out.println(arr[i]);
                break;
            }
        }
        if (i == arr2.length) {
            System.out.println(arr[arr.length - 1]);
        }
    }

}
