import java.util.Arrays;
import java.util.Scanner;

public class CF1037B {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int se = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        Arrays.sort(arr);
        if(arr[n/2] == se){
            System.out.println(0);
        } else if(arr[n/2] > se){
            long ans = 0;
            int k = n/2;
            while(k >= 0 && arr[k] > se){
                ans += Math.abs(arr[k] - se);
                k--;
            }
            System.out.println(ans);
        } else {
            long ans = 0;
            int k = n/2;
            while(k < n && arr[k] < se){
                ans += Math.abs(arr[k] - se);
                k++;
            }
            System.out.println(ans);
        }
    }
}
