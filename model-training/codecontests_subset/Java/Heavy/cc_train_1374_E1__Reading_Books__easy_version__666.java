import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {







    public static void main(String[] args) {


        int n = fsca.nextInt() ;
        int k = fsca.nextInt() ;

        ArrayList<Integer> ones = new ArrayList<>() ;
        ArrayList<Integer> zero_one = new ArrayList<>() ;
        ArrayList<Integer> one_zero = new ArrayList<>() ;


        for (int i = 0; i <n ; i++) {
            int val = fsca.nextInt() ;
            int a = fsca.nextInt() ;
            int b = fsca.nextInt() ;

            if (a==1 && b == 1)
                ones.add(val) ;
            else if (a==1 && b ==0 )
                one_zero.add(val) ;
            else if (a == 0 && b==1)
                zero_one.add(val) ;
        }
        Collections.sort(ones);
        Collections.sort(zero_one);
        Collections.sort(one_zero);

        int min_size = Math.min(one_zero.size() , zero_one.size()) ;
        min_size = Math.min(min_size , k) ;
        long ans = 0 ;
        for (int i = 0; i <min_size ; i++) {
            ans += one_zero.get(i) + zero_one.get(i) ;
        }

        if (min_size < k){
            int rem = k - min_size ;
            int ptr = 0 ;
            while (rem-- > 0 && ptr < ones.size()){
                ans += ones.get(ptr) ;
                ptr++ ;
            }
            if (rem != -1){
                System.out.println(-1);
                return;
            }
            for (int i= min_size-1 ; i>=0 && ptr < ones.size() ; i--){
                int temp = one_zero.get(i) + zero_one.get(i) ;
                if (temp > ones.get(ptr)){
                    ans -= temp ;
                    ans += ones.get(ptr) ;
                    ptr++ ;
                }
            }

            System.out.println(ans);
        }
        else {
            int ptr = 0 ;
            for(int i = k-1 ; i >=0 && ptr < ones.size() ; i-- ){
                int temp = one_zero.get(i) + zero_one.get(i);
                if (temp > ones.get(ptr)){
                    ans -= temp ;
                    ans += ones.get(ptr) ;
                    ptr++ ;
                }
            }
            System.out.println(ans);
        }






















        fop.flush();
        fop.close();


    }
    /*-----------------------------------------------------------------------------------------------------------------------------------------------*/

    static PrintWriter fop = new PrintWriter(System.out);
    static FastScanner fsca = new FastScanner();


    static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    ;

    static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }


    static final Random random = new Random();

    static void ruffleSort(int[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }

    static void ruffleSort(long[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n);
            long temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }


    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[][] readMat(int n, int m) {
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    a[i][j] = nextInt();
            return a;
        }

        char[][] readCharMat(int n, int m) {
            char a[][] = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = next();
                for (int j = 0; j < m; j++)
                    a[i][j] = s.charAt(j);
            }
            return a;
        }


        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static void print(int a[], int n) {
        for (int i = 0; i < n; i++)
            fop.append((a[i]) + " ");
        // fop.append("\n") ;
    }

    static void print(long a[], int n) {
        for (int i = 0; i < n; i++)
            fop.append((a[i]) + " ");
        // fop.append("\n") ;
    }
}
        