
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),s=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        long sum=0;
        for(int i=0;i<n;i++){
            if(i<n/2){
                if(arr[i]>s) sum = sum + Math.abs(s-arr[i]);
            }
            else if(i==n/2){
                sum = sum + Math.abs(s-arr[i]);
            }
            else{
                if(arr[i]<s) sum = sum +Math.abs(s-arr[i]);
            }
        }
        System.out.println(sum);

    }
}