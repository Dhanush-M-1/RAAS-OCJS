import java.util.Arrays;
import java.util.Scanner;

public class Codeforces {

    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), a[] = new int[n];
        int k = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
           k = Math.max(a[i],k);
            sum += a[i];
        }

        while (n*k <= 2*sum){
            k++;
        }
        System.out.println(k);
    }


}

