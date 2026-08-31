//============================================================================
/*				"There is nothing that can take the pain away.
      But eventually you will find a way to live with it.
				There will be nightmares.
	  And every day when you wake up, it will be the first thing you think about.
				Until one day, it will be the second thing."
*/
// Author      : Murad
// Online Judge: Codeforces.cpp & Atcoder.cpp
// Description : Problem name
//============================================================================
/* Riven && Vladimir && Ekko */
import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int n=in.nextInt(),k=in.nextInt();
        PriorityQueue<Integer>alic=new PriorityQueue<>();
        PriorityQueue<Integer>bob=new PriorityQueue<>();
        PriorityQueue<Integer>both=new PriorityQueue<>();
        long ans=0;
        for(int i=0;i<n;i++)
        {
            int t=in.nextInt(),a=in.nextInt(),b=in.nextInt();
            if(a==1 && b==0)
                alic.add(t);
            else if(a==0 && b==1)
                bob.add(t);
            else if(a== 1 &&b==1)
                both.add(t);
        }
        int cnta=(int)both.size()+(int)alic.size();
        int cntb=(int)both.size()+(int)bob.size();
        if (cnta < k || cntb < k){
            out.println(-1);
        }
        else{
            cnta=0;
            cntb=0;
            int aidx=0,bidx=0;
            while (both.isEmpty()==false){
                int total=0;
                int fialic=0,fibob=0;
                if(alic.isEmpty()==false) {
                    fialic=alic.peek();
                    total += fialic;
                }
                else total+=1000000000;
                if(bob.isEmpty()==false){
                    fibob=bob.peek();
                    total+=fibob;
                }else total+=1000000000;
                int mo=both.peek();
                if(total<mo){
                    ans += total;
                    alic.poll();
                    bob.poll();
                    cnta++;
                    cntb++;
                }
                else{
                    ans += mo;
                    cnta++;
                    cntb++;
                    both.poll();
                }
                if (cnta >= k&&cntb >= k)break;
            }
            while (!alic.isEmpty() && cnta<k) {
                int fia=alic.peek();
                ans +=fia;
                alic.poll();
                cnta++;
            }
            while (!bob.isEmpty() && cntb < k) {
                int fib=bob.peek();
                ans +=fib;
                bob.poll();
                cntb++;
            }
            out.println(ans);
        }
        out.flush();
    }
    static class Pair<C, I extends Number> implements Comparable<Pair<C, Number>> {
        long value;
        long idx;
        Pair(long v, long i)
        {
            value = v;
            idx = i;
        }

        @Override
        public int compareTo(Pair<C, Number> p) {
            return (int)(value - p.value);
        }
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
        public long[] readLongArray(int n) {
            long[] x = new long[n];
            for (int i = 0; i < n; i++) {
                x[i] = nextLong();
            }
            return x;
        }
        public int[] readIntArray(int n) {
            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = nextInt();
            }
            return x;
        }
    }
    static class NumberTheory{
        public static long gcd(long a,long b){
            long c;
            while (a != 0) {
                c = a;
                a = b % a;
                b = c;
            }
            return b;
        }
    }
    //Relatively Prime :- if diffrence between two number is equal to 1
}