import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class CSES{
    static long mod = 1000000007;
    static boolean check(int n){
        for(int i=2;i*i<=n;i++){
            if(n%i==0)return false;
        }
        return  true;
    }
    public static void main(String[] args) throws IOException {
        FastScanner s=new FastScanner();
        int t1 = s.nextInt();
//        int t1 =1;
        while(t1-->0){
            int n = s.nextInt();
            int m = s.nextInt();
            int[] a =new int[n];
            int[] b = new int[m];
            int[] cnt = new int[1005];
            Arrays.fill(cnt,0);
            for(int i=0;i<n;i++){
                a[i]  =s.nextInt();
                cnt[a[i]]++;
            }
            int k=-1,v=0;
            boolean f=true;
            for(int i=0;i<m;i++){
                b[i]  =s.nextInt();
                if(cnt[b[i]]>=1){
                    k=1;
                    v=b[i];
                    f=false;
                }
            }
            if(k==-1) System.out.println("NO");
            else{
                System.out.println("YES");
                System.out.println(k+" "+v);
            }
        }
    }

    static long gcd(long a, long b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int gcd(int a, int b)throws IOException{return (b==0)?a:gcd(b,a%b);}

    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }
    static void sort(long[] a) {
        ArrayList<Long> l=new ArrayList<>();
        for (long i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }
    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}