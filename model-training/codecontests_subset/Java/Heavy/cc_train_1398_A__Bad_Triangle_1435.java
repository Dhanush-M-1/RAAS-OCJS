import java.util.*;
public class BadTriangle {
    static void solve(int[] arr, int length) {
        for(int i = 0; (i+2) < length; i++) {
            if((arr[i]+arr[i+1]) <= arr[length-1]) {
                // System.out.println((i+1)+' '+(i+2)+' '+length);
                System.out.print(i+1);
                System.out.print(" ");
                System.out.print(i+2);
                System.out.print(" ");
                System.out.println(length);
                return;
            }
        }
        System.out.println(-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t!=0) {
            int length = sc.nextInt();
            if(length<3) {
                System.out.println(-1);
                t--;
                continue;
            }
            int arr[] = new int[length];
            for(int i = 0; i< length; i++) {
                arr[i] = sc.nextInt();
            }
           solve(arr, length);
            t--;
        }
    }
}
