import java.sql.SQLOutput;
import java.util.*;



public class lottery {
    public static String alpha = "abcdefghijklmnopqrstuvwxyz";
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t= scan.nextInt();
        while(t-->0){
           int n =scan.nextInt();
           int m = scan.nextInt();
           String str = scan.next();
           int[] pref = new int[n];
           for(int i = 0; i<m; i++){
               pref[scan.nextInt()-1]++;
           }
           for(int i = n-1; i>0; i--){
               pref[i-1] += pref[i];
           }
           int[] ans = new int[26];
           for(int i = 0; i<n; i++){
               ans[alpha.indexOf(str.charAt(i))] += pref[i]+1;
           }
           for(int i : ans){
               System.out.print(i+" ");
           }
            System.out.println();


        }

    }
    static int GCD(int a, int b) {
        // Everything divides 0
        if (a == 0) return b;
        if (b == 0) return a;

        // base case
        if (a == b) return a;

        // a is greater
        if (a > b) return GCD(a-b, b);
        return GCD(a, b-a);
    }
    static int LCM(int a, int b){
        return (a*b)/(GCD(a,b));
    }

}