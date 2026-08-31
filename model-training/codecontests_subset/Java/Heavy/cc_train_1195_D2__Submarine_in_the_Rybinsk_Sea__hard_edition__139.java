import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SubmarineintheRybinskSea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = 1;
        for (int i = 0; i < t; i++) {
            solve(sc, pw);
        }
        pw.close();
    }
    static int mod = 998244353;
    static void solve(Scanner in, PrintWriter out){
        int n = in.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        long[] muts = new long[25];
        muts[0] = 1;
        for(int i = 1; i < muts.length; i++){
            muts[i] = (muts[i - 1] * 10) % mod;
        }
//        System.out.println(Arrays.toString(muts));
        int[] cntLen = new int[12];
        for (int i = 0; i < n; i++) {
            cntLen[String.valueOf(arr[i]).length()]++;
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            String ss = String.valueOf(arr[i]);
            int len = ss.length();
            for (int j = 1; j < 12; j++) {
                if (cntLen[j] == 0) continue;
                long add = 0;
                for (int k = 0, l = 0, ii = 0; l < len; k++) {
                    if (k % 2 == 1 && ii < j){
                        ii++;
                        continue;
                    }
                    int v = ss.charAt((len - ++l)) - '0';
                    add = (add + (v * muts[k]) % mod) % mod;
                }
                add = (add * cntLen[j]) % mod;
                ans = (ans + add) % mod;
            }
            for (int j = 1; j < 12; j++) {
                if (cntLen[j] == 0) continue;
                long add = 0;
                for (int k = 0, l = 0, ii = 0; l < len; k++) {
                    if (k % 2 == 0 && ii < j){
                        ii++;
                        continue;
                    }
                    int v = ss.charAt(len - ++l) - '0';
                    add = (add + (v * muts[k]) % mod) % mod;
                }
                add = (add * cntLen[j]) % mod;
                ans = (ans + add) % mod;
            }
        }
        out.println(ans);
    }

    // Use this instead of Arrays.sort() on an array of ints. Arrays.sort() is n^2
    // worst case since it uses a version of quicksort. Although this would never
    // actually show up in the real world, in codeforces, people can hack, so
    // this is needed.
    static void ruffleSort(int[] a) {
        //ruffle
        int n=a.length;
        Random r=new Random();
        for (int i=0; i<a.length; i++) {
            int oi=r.nextInt(n), temp=a[i];
            a[i]=a[oi];
            a[oi]=temp;
        }

        //then sort
        Arrays.sort(a);
    }
}
