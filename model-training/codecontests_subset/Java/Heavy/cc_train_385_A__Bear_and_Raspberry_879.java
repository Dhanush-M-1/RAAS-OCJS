import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;




public class RandomClass {

    static final Random random = new Random();

    public static void main(String args[]) throws Exception {

        FastReader fs = new FastReader();
        StringBuilder sb = new StringBuilder();


        int n =  fs.nextInt();
        int c = fs.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = fs.nextInt();
        }

        int l=0;
        int r = 1;

        int profit = arr[0]-arr[1]-c;
        int maxProfit = profit;
        while(r<n) {
            profit = arr[l++] - arr[r++] - c;
            if(profit>maxProfit) {
                maxProfit = profit;
            }
        }
        if(maxProfit>0)
        System.out.println(maxProfit);
        else
            System.out.println(0);





    }



    static int gcd(int a, int b)
    {
        return (a % b == 0) ?
                Math.abs(b) : gcd(b,a%b);
    }

    static boolean isPossible(int a,
                              int b, int c)
    {
        return (c % gcd(a, b) == 0);
    }


    //Fast Reader
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }


    static void ruffleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }

}