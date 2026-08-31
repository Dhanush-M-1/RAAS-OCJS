import java.io.*;
import java.util.*;

public class Main {
    static PrintWriter pw;
    static Scanner sc;
    static HashSet<Pair> hash;
    static ArrayList<Integer> list;
    static long ceildiv(long x, long y) { return (x + y - 1) / y; }
    static int mod(long x, int m) { return (int) ((x % m + m) % m); }
    public static long gcd(long x, long y) {return y == 0 ? x : gcd(y, x % y);}
    public static void main(String[] args) throws Exception {
        sc = new Scanner(System.in);
        pw = new PrintWriter(System.out);
        int n=sc.nextInt();
        int[] arr=sc.nextArr(n);
        double st=-1e4, end=1e4;
        double eps=1e-14;
        while(end-st>3*eps){
            double m1=st+(end-st)/3;
            double m2=end-(end-st)/3;
            double test1=test(m1, arr, n), test2=test(m2, arr, n);
            if(test1-eps>test2){
                st=m1+eps;
            }else if(test2-eps>test1){
                end=m2-eps;
            }else{
                st=m1;
                end=m2;
            }
        }
        pw.println(Math.min(Math.min(test(st+eps, arr, n), test(st+2*eps, arr, n)), test(st, arr, n)));
        pw.close();
    }
    static double test(double x, int[] arr, int n){
        double[] poor=new double[n];
        for(int i=0; i<n; i++)
            poor[i]=arr[i]-x;
        double[] max=new double[n], min=new double[n];
        max[0]=min[0]=poor[0];
        for(int i=1; i<n; i++)
            max[i]=Math.max(0, max[i-1])+poor[i];
        for(int i=1; i<n; i++)
            min[i]=Math.min(0, min[i-1])+poor[i];
        double ans=Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
            ans=Math.max(Math.max(Math.abs(max[i]), Math.abs(min[i])), ans);
        return ans;
    }
    static void freq(int n, int[] freq){
        for(int i=2; i<=n; i++)
            freq[least[i]]++;
    }
    static int[] least;
    static ArrayList<Integer> prime;
    static void linearsieve(int x){
        least=new int[x+1];
        prime=new ArrayList<Integer>();
        for(int i=2; i<x; i++){
            if(least[i]==0){
                least[i]=i;
                prime.add(i);
            }
            for(int y :prime) {
                if(i*y<=x)
                    least[i*y]=y;
                else break;
            }
        }
    }
    static HashSet<Integer> primefact(int x){
        HashSet<Integer> hash=new HashSet<Integer>();
        while(x>1){
            if(!hash.contains(least[x]))
                hash.add(least[x]);
            x/=least[x];
        }
        return hash;
    }
    static void printArr(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            pw.print(arr[i] + " ");
        pw.println(arr[arr.length - 1]);
    }
    static void printArr(long[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            pw.print(arr[i] + " ");
        pw.println(arr[arr.length - 1]);
    }
    static void printArr(Integer[] arr) {
        for (int i = 0; i < arr.length; i++)
            pw.print(arr[i] + " ");
        pw.println();
    }
    static void printArr(char[] arr) {
        for (int i = 0; i < arr.length; i++)
            pw.print(arr[i]);
        pw.println();
    }
    static void printArr(ArrayList list) {
        for (int i = 0; i < list.size(); i++)
            pw.print(list.get(i) + " ");
        pw.println();
    }
    static class Scanner {
        StringTokenizer st;
        BufferedReader br;
        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public int[] nextArr(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++)
                arr[i] = nextInt();
            return arr;
        }
        public Integer[] nextsort(int n) throws IOException{
            Integer[] arr=new Integer[n];
            for(int i=0; i<n; i++)
                arr[i]=nextInt();
            return arr;
        }
        public Pair nextPair() throws IOException{
            return new Pair(nextInt(), nextInt());
        }
        public Pair[] nextPairArr(int n) throws IOException{
            Pair[] arr=new Pair[n];
            for(int i=0; i<n; i++)
                arr[i]=new Pair(nextInt(), nextInt());
            return arr;
        }
        public boolean ready() throws IOException {
            return br.ready();
        }
    }
    static class Pair implements Comparable<Pair>{
        long x;
        long y;
        public Pair(long x, long y) {
            this.x=x;
            this.y=y;
        }
        public int hashCode() {
            return (int)(this.x*1000+this.y);
        }
        public int compareTo(Pair p){
            return (int)(this.x-p.x);
        }
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this.getClass() != obj.getClass()) {
                return false;
            }
            Pair p = (Pair) obj;
            return this.x==p.x && this.y==p.y;
        }
        public boolean equal(Pair p){
            if(this.x==p.x)
                return this.y==p.y;
            if(this.x==p.y)
                return this.y==p.x;
            else
                return false;
        }
        public Pair clone(){
            return new Pair(x, y);
        }
        public String toString(){
            return this.x+" "+this.y;
        }
        public void add(Pair p){
            x+=p.x;
            y+=p.y;
        }
        public Pair multiply(int x){
            return new Pair(x*this.x, x*this.y);
        }
    }
}
