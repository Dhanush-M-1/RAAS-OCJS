import java.math.BigInteger;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int a[]=new int[n];
        int max = 1;
        int sum=0;
        for(int i=0;i<n;i++){
            a[i]=scanner.nextInt();
            if (a[i]>max){
                max=a[i];
            }
            sum+=a[i];
        }
        int k=max-1;
        int sumA=0;
        while (sumA<=sum) {
            k++;
            sumA=0;
            for (int i = 0; i < n; i++) {
                sumA += k - a[i];
            }
        }
        System.out.println(k);
    }
}
