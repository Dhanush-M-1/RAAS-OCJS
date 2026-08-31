import java.util.*;
import java.lang.*;

public class C{
    
    public static Scanner sc = new Scanner(System.in);

    public static void compute(int m, int n, String s, int p[]) {
        char arr[] = s.toCharArray();
        int alpha[] = new int[26];
        int pref[] = new int[m];
        for(int j=0; j<n; j++){
                ++pref[p[j]-1];
        }
        for (int i=m-1; i>0; --i) {
			pref[i-1] += pref[i];
        }
        
        for(int i=0; i<m; i++){
            alpha[arr[i]-97] += pref[i];
            alpha[arr[i]-97]++;
        }

        printArray(alpha);
    }

    public static void printArray(int alpha[]) {
        for(int i=0; i<26; i++){
            System.out.print(alpha[i]+" ");
        }
    }
    
    public static void main(String[] args) {
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            int m = sc.nextInt();
            int n = sc.nextInt();
            String s = sc.next();
            int p[] = new int[n];
            for(int j=0; j<n; j++){
                p[j] = sc.nextInt();
            }
            compute(m,n,s,p);
            System.out.print("\n");
        }

    }
}