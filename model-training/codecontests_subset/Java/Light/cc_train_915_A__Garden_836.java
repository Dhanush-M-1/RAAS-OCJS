import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n=read.nextInt();
        int k=read.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i]=read.nextInt();
        }
        Arrays.sort(arr);
        int j=n-1;
        while (k%arr[j]!=0){
            j--;
        }
        System.out.println(k/arr[j]);
    }
}
