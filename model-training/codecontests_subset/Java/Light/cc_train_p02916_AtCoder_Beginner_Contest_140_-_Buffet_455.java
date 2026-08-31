import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n-1];

        for (int i=0; i<n; i++) a[i] = sc.nextInt()-1;
        for (int i=0; i<n; i++) b[i] = sc.nextInt();
        for (int i=0; i<n-1; i++) c[i] = sc.nextInt();


        long sum = 0;

        int z = -10;

        for (int i=0; i<n; i++){
            int j = a[i];
            sum += b[j];
            if (z+1==j){
                sum += c[j-1];
            }
            z = j;
        }
        System.out.println(sum);


    }
}