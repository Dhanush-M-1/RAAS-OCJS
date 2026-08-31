import java.util.*;
import java.math.*;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0) {
            int[] arr = new int[3];
            for(int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            int val = Math.min(arr[2]/2, arr[1]);
            arr[1] -= val;
            arr[2] -= val * 2;
            if(arr[1] != 0) {
                int newVal = Math.min(arr[1]/2, arr[0]);
                arr[0] -= newVal;
                arr[1] -= newVal * 2;
                val += newVal;
            }
            System.out.println(val * 3);
        }
    }
}