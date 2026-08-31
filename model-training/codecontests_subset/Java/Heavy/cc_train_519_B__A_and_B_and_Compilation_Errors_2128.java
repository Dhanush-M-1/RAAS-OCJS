import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int s1 = 0, s2 = 0, s3 = 0;
        for(int i = 0; i<n; i++){
            a[i] = sc.nextInt();
            s1 += a[i];
        }
        for(int i = 0; i<n-1; i++){
            b[i] = sc.nextInt();
            s2 += b[i];
        }
        
        for(int i = 0; i<n-2; i++){
            c[i] = sc.nextInt();
            s3 += c[i];
        }
        System.out.println(s1-s2);
        System.out.println(s2-s3);
        
    }
}