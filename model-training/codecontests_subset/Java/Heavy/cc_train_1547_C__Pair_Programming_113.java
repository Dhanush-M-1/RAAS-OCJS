//package com.company;


import javax.print.attribute.standard.PrinterIsAcceptingJobs;
import javax.sound.midi.spi.SoundbankReader;
import java.io.*;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.text.CollationElementIterator;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main implements Runnable {
    int size[];
    static int e9 = 1000000007;
    int max = Integer.MIN_VALUE;
    long max1 = Long.MIN_VALUE;
    long min1 = Long.MAX_VALUE;
    long fib[][];
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
    int parent[];
    int rank[];
    ArrayList<ArrayList<Integer>> arrayLists;
    long fib1[][];
    long r[];
    int n;
    int m;
    long co=0;
    long size1[];
    long v[];
    int arr[][];
    int u=0;
    HashMap<Long,Long> hashMap=new HashMap<>();
    ArrayList<Pair> arrayList;
    public static void main(String[] args) throws IOException {
        new Thread(null,new Main(),"Main",1<<28).start();
    }

    public void run() {
        FastReader scanner = new FastReader();
//            Scanner scanner = new Scanner(System.in);
//            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        long t = scanner.nextLong();
        high:while (t-- > 0) {
            int k=scanner.nextInt();
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            int a[]=new int[n];
            int p[]=new int[m];
            for (int i = 0; i < n; i++) {
                int a1=scanner.nextInt();
                a[i]=a1;
            }
            for (int i = 0; i < m; i++) {
                int p1=scanner.nextInt();
                p[i]=p1;
            }
            int s1=0;
            int s2=0;
            int ans[]=new int[n+m];
            int u=0;
            while(s1<a.length&&s2<p.length){
                if(a[s1]<=p[s2]&&a[s1]<=k){
                    if(a[s1]==0){
                        k++;
                    }
                    ans[u]=a[s1];
                    s1++;
                    u++;
                }
                else if(p[s2]<=a[s1]&&p[s2]<=k){
                    if(p[s2]==0){
                        k++;
                    }
                    ans[u]=p[s2];
                    s2++;
                    u++;
                }
                else{
                    printWriter.println(-1);
                    continue high;
                }
            }
            while(s1<a.length){
                if(a[s1]==0){
                    k++;
                }
                if(a[s1]>k){
                    printWriter.println(-1);
                    continue high;
                }
                ans[u]=a[s1];
                s1++;
                u++;
            }
            while(s2<p.length){
                if(p[s2]==0){
                    k++;
                }
                if(p[s2]>k){
                    printWriter.println(-1);
                    continue high;
                }
                ans[u]=p[s2];
                s2++;
                u++;
            }
            for (int i = 0; i < (n+m); i++) {
                printWriter.print(ans[i]+" ");
            }
            printWriter.println();
        }
        printWriter.flush();
    }
    static long mod=1_000_000_007;
    public long lcm(long a,long b){
        return (a*b)/gcd(a,b);
    }
    public long mul(long a, long b) {
//        System.out.println(a+" "+b);
        return ((a)*(b));
    }
    public long fact(int x) {
        long ans=1;
        for (int i=2; i<=x; i++) ans=mul(ans, i);
        return ans;
    }
    public long fastPow(long base, long exp) {
        if (exp==0) return 1;
        long half=fastPow(base, exp/2);
        if (exp%2==0) return mul(half, half);
        return mul(half, mul(half, base));
    }
    public long modInv(long x) {
        return fastPow(x, mod-2);
    }
    public long nCk(int n, int k) {
        return mul(fact(n), mul(modInv(fact(k)), modInv(fact(n-k))));
    }
    public void parent(int n){
        parent=new int[n+1];
        size=new int[n+1];
        rank=new int[n+1];
        for (int i = 0; i <=n; i++) {
            parent[i]=i;
            rank[i]=0;
//            size[i]=1;
        }
    }
    public void union(int i,int j){
        int root1=find(i);
        int root2=find(j);
//            if(root1 != root2) {
//                parent[root2] = root1;
////                sz[a] += sz[b];
//            }
        if(root1==root2){
            return;
        }
        if(rank[root1]>rank[root2]){
            parent[root2]=root1;
            size[root1]+=size[root2];
        }
        else if(rank[root1]<rank[root2]){
            parent[root1]=root2;
            size[root2]+=size[root1];
        }
        else{
            parent[root2]=root1;
            rank[root1]+=1;
            size[root1]+=size[root2];
        }
    }
    public int find(int p){
        if(parent[p]!=p){
            if(parent[p]==-1){
                return parent[p];
            }
            parent[p]=find(parent[p]);
        }
        return parent[p];
    }
    public double dist(double x1,double y1,double x2,double y2){
        double e=(x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
        double e1=Math.sqrt(e);
        return e1;
    }
    public void make(int p){
        parent[p]=p;
        rank[p]=1;
    }
    Random rand = new Random();
    public void sort(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            int j = rand.nextInt(i + 1);
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        Arrays.sort(a, 0, n);
    }
    public long gcd(long a,long b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    //    public void dfs(ArrayList<Integer> arrayList){
//        for (int i = 0; i < arrayList.size(); i++) {
//            if(v1[arrayList.get(i)]==false){
//                v1[arrayList.get(i)]=true;
//                dfs(arrayLists.get(i));
//            }
//        }
//    }
    public double fact(double h){
        double sum=1;
        while(h>=1){
            sum=(sum%e9)*(h%e9);
            h--;
        }
        return sum%e9;
    }
    public long primef(double r){
        long c=0;
        long ans=1;
        long g=0;
        while(r%2==0){
            c++;
            r=r/2;
        }
        if(c>0){
            ans*=2;
        }
        c=0;
//            System.out.println(ans+" "+r);
        for (int i = 3; i <=Math.sqrt(r) ;i+=2) {
            g=0;
            while(r%i==0){
//                    System.out.println(i);
                c++;
                g++;
                r=r/i;
            }
            if(c>0){
                ans*=i;
            }
            c=0;
        }
        if(r>2){
            ans*=r;
        }
        return ans;
    }
    public long divisor(double r){
        long c=0;
//        if(n==3)
//            System.out.println(r+" "+n+" "+k+" "+"l");
        for (int i =2; i <=Math.sqrt(r); i++) {
            if(r%i==0){
                if(r/i==i){
                    c++;
                }
                else{
                    if(r/i<n){
                        c+=2;
                    }else{
                        c++;
                    }
                }
            }
        }
        return c;
    }
}
class Pair {
    long x;
    long y;
    int z;
    public Pair(long x,long y) {
        this.x = x;
        this.y = y;
//        this.z=z;
    }

    // @Override
//    public int hashCode() {
//        int hash = 37;
//        return this.x * hash + this.y;
//    }

    @Override
    public boolean equals(Object o1) {
        if (o1 == null || o1.getClass() != this.getClass()) {
            return false;
        }
        Pair o = (Pair) o1;
        if (o.x == this.x && o.y == this.y) {
            return true;
        }
        return false;
    }
}
class Sorting implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2) {
//        if(p1.y==p2.y){
//            return Long.compare(p1.x,p2.x);
//        }else {
        return Long.compare(p1.x, p2.x);
        // }
    }
}
class Edge{
    int s=0;
    int d=0;
    int c=0;
    public Edge(int s,int d,int c){
        this.s=s;
        this.d=d;
        this.c=c;
    }
}