import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public  class Solution {

    static  class pair implements  Comparable<pair> {
        int a , b   ;
        pair(int a, int b  ){
            this.a = a;
            this.b = b ;

        }


        @Override
        public int compareTo(pair o) {
            if (this.a == o.a)
                return this.b - o.b ;
            return  - (this.a - o.a) ;
        }
    }

    public static void main(String[] args) {

        int n = fsca.nextInt();
        pair a[] = new pair[n] ;
        for (int i = 0; i <n ; i++) {
            a[i] = new pair(fsca.nextInt(), i) ;
        }

        Arrays.sort(a);
        int m = fsca.nextInt();
        while (m-- > 0){
            int k = fsca.nextInt();
            int pos = fsca.nextInt() - 1 ;
            ArrayList<Integer> list = new ArrayList<>() ;
            for (int i = 0; i <k ; i++) {
                list.add(a[i].b) ;
            }
            Collections.sort(list);
            for (int i = 0; i <k ; i++) {
                if (list.get(pos) == a[i].b){
                    fop.append(a[i].a + "\n") ;
                    break;
                }
            }


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
    static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

   // Arrays.sort() takes o(n^2) time to sort when array is reverse sorted
   // so always shuffle the array before sorting
    static final Random random = new Random();
    static void ruffleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i]; a[i] = temp;
        }
        Arrays.sort(a);
    }
    static void ruffleSort(long[] a) {
        int n = a.length;
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

        // int array input
        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }
        // long array input
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

}