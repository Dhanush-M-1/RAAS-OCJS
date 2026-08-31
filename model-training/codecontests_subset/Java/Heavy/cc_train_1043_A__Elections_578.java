import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class A {

    private void work() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();
        int[] a = new int[n];
        int k = 0;
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            if(a[i] > k) k = a[i];
        }
        sc.close();
        while(losing(a, k)) k++;
        System.out.println(k);
    }

    private boolean losing(int[] a, int k){
        int v0 = 0;
        int v1 = 0;
        for(int i = 0; i < a.length; i++){
            v0 += a[i];
            v1 += k - a[i];
        }

        return v0 >= v1;
    }

    public static void main(String[] args) {
        new A().work();
    }
}
