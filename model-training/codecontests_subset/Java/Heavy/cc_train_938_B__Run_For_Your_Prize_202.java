import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt()-1;
        }
        int me = 0;
        int fr = 999999;
        int sec = 0;
        int j=0,k=n-1;
        while (j<n && a[j]-me<fr-a[j]) j++; 
        j--;
        while (k>=0 && fr-a[k]<a[k]-me) k--; 
        k++;
        if (j<0) {
            sec = fr-a[k];
        } else if (k>=n) {
            sec = a[j]-me;
        } else {
            if (a[j]-me<fr-a[k]) {
                sec = fr-a[k]; 
            } else {
                sec = a[j]-me;
            }
        }
        System.out.println(sec); 
    }

}