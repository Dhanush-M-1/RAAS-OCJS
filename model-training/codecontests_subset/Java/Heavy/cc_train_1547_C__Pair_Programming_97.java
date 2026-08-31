import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test{

        static FastReader scan;

        static void solve(){
            scan.nextLine();
            int k=scan.nextInt();
            int n=scan.nextInt();
            int m=scan.nextInt();

            int []a=new int[n];
            int []b=new int[m];
            ArrayList<Integer>ans=new ArrayList<>();

            for(int i=0;i<n;i++){
                a[i]=scan.nextInt();
            }
            for(int i=0;i<m;i++){
                b[i]=scan.nextInt();
            }

            

            int tempk=k;

            int x=0;
            int y=0;

            while(x<n||y<m){
                /*if(x<n)
                System.out.println(a[x]);
                if(y<m)
                System.out.println(b[y]);*/
                if(x<n&&a[x]==0){
                    tempk++;
                    ans.add(0);
                    x++;
                }
                else
                if(y<m&&b[y]==0){
                    tempk++;
                    ans.add(0);
                    y++;
                }
                else
                if(x<n&&a[x]<=tempk){
                    ans.add(a[x]);
                    x++;
                }
                else
                if(y<m&&b[y]<=tempk){
                    ans.add(b[y]);
                    y++;
                }
                else{
                    System.out.println(-1);
                    return;
                }
            }

            for(int i=0;i<ans.size();i++){
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();




        }

        public static void main (String[] args) throws java.lang.Exception{
            scan=new FastReader();
            int t=scan.nextInt();
            while(t-->0){
                solve();                  
            }
        }

        static class FastReader {
            BufferedReader br;
            StringTokenizer st;

            public FastReader()
            {
                br = new BufferedReader(
                    new InputStreamReader(System.in));
            }

            String next()
            {
                while (st == null || !st.hasMoreElements()) {
                    try {
                        st = new StringTokenizer(br.readLine());
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return st.nextToken();
            }

            int nextInt() { return Integer.parseInt(next()); }

            long nextLong() { return Long.parseLong(next()); }

            double nextDouble() { return Double.parseDouble(next()); }

            String nextLine()
            {
                String str = "";
                try {
                    str = br.readLine();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                return str;
            }
        }

        static class Pair implements Comparable<Pair>{
            long wt;
            long idx;
            Pair(long x,long y){
                this.wt=x;
                this.idx=y;
            }
            @Override
            public int compareTo(Pair x){
                return (int)(this.wt-x.wt);
            }

            public String toString(){
                return "( "+wt+" "+idx+" )";
            }
        }        

        static void printLong(long []arr){
            for(long x:arr)System.out.print(x+" ");
        }

        static void printInt(int []arr){
            for(int x:arr)System.out.print(x+" ");
        }

        static void scanInt(int []arr){
            for(int i=0;i<arr.length;i++){
                arr[i]=scan.nextInt();
            }
        }

        static void scanLong(long []arr){
            for(int i=0;i<arr.length;i++){
                arr[i]=scan.nextLong();
            }
        }

        static long gcd(long a, long b){
            if (b == 0)
                return a;
            
            return gcd(b, a % b);
        }   

        static long power(long x, long y, long mod){
            long res = 1; 
        
            x = x % mod; 
         
            if (x == 0)
              return 0; 
         
            while (y > 0){              
                if ((y & 1) != 0)
                res = (res * x) % mod;
              
                y = y >> 1; 
                x = (x * x) % mod;
            }
                return res;
        }

        static long add(long a,long b,long mod){
            a = a % mod; 
            b = b % mod; 
            return (((a + b) % mod) + mod) % mod;
        }

        static long sub(long a, long b,long mod){
            a = a % mod; 
            b = b % mod; 
            return (((a - b) % mod) + mod) % mod;
        }

        static long mul(long a, long b,long mod){
            a = a % mod; 
            b = b % mod; 
            return (((a * b) % mod) + mod) % mod;
        }
        

        static long mminvprime(long a, long b,long mod) {
            return power(a, b - 2,mod);
        }
}
