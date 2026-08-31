import java.util.Arrays;
import java.util.Scanner;

public class CodeForce_915A {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n,l;
        n = sc.nextInt();
        l = sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        for(int i=n-1;i>-1;i--){
            if(l % arr[i] ==0 ){
                System.out.println(l/arr[i]);
                break;
            }
        }
    }
}