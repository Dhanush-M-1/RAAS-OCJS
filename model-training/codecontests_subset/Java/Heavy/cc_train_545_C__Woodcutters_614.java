import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main{
    public static void read(long[] a,int n) throws IOException{for (int i=0;i<n;i++){a[i]=Reader.nextLong();}}
    public static String print(int[] a,int n,String c){String A=""; for (int i : a){ A+=i+c;} return A;}
    public static String send(String a,String b){ if (a.charAt(0)==b.charAt(0)){ if (a.equals("R")){ return "B";}else if(a.equals("B")){ return "G";}else{ return "R";}}
                                                  else{ if (a.equals("R") && b.equals("B") || a.equals("B") && b.equals("R")){ return "G";}else if (a.equals("R") && b.equals("G") || a.equals("G") && b.equals("R")){ return "B";}else { return "R";}}
                                                }
    public static int solve(int[] x,int[] h,int i,int n,int l,int r,int[] Arr){
        
        if (i==n){
            return 0;
        }
        else if (Arr[i]!=-1){
            return Arr[i];
        }
        else{
            int a = l<x[i]-h[i] && x[i-1]<x[i]-h[i] ? solve(x,h,i+1,n,x[i],r,Arr)+1:0;
            int b = r>x[i]+h[i] && x[i]+h[i]<x[i+1] ? solve(x,h,i+1,n,x[i]+h[i],r,Arr)+1:0;
            int c = solve(x,h,i+1,n,l,r,Arr);
            Arr[i] = Math.max(Math.max(a, b),c);
            return Arr[i];
        }
    }
    public static void main(String[] args) throws IOException{
        Reader scan = new Reader();
        scan.init(System.in);
        OutputStream output = System.out;
        PrintWriter out = new PrintWriter(output);
        int n = scan.nextInt();
        int[] x = new int[n];
        int[] h = new int[n];
        int[] Arr = new int[n];
        for (int i=0;i<n;i++){
            x[i] = scan.nextInt();
            h[i] = scan.nextInt();
            Arr[i] = -1;
        }
        if (n<=2){
            out.println(n);
        }
        else{
            int l = x[0];
            int r = x[n-1];
            out.println(2+solve(x, h,1, n-1, l, r, Arr));
        }
        out.close();
    }
}
class Comp implements Comparator<String>{
    public int compare(String a,String b){
        return (b.length()-a.length());
    } 
}
class dsu{
    int[] arr;
    dsu(int N){
        arr = new int[N];
        for (int i=0;i<N;i++){
            arr[i] = i;
        }
    }
    public void joint(int A,int B){
        int a = find(A);
        int b = find(B);
        arr[a] = b;
    }
    public int find(int A){
        while(A!=arr[A]){
            A = arr[A];
        }
        return A;
    }
}
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }
    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}