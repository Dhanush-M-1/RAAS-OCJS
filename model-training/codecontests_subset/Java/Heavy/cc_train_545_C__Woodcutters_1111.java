//package credit;


import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
    static boolean v[];
    static int ans[];
    int size[];
    static int count=0;
    static int dsu=0;
    static int c=0;
    static int e9=1000000007;
    int min=Integer.MAX_VALUE;
    int max=Integer.MIN_VALUE;
    long max1=Long.MIN_VALUE;
    long min1=Long.MAX_VALUE;
    boolean aBoolean=true;
    boolean y=false;
    long m=0;
    static boolean t1=false;
        static class FastReader
        {
            BufferedReader br;
            StringTokenizer st;

            public FastReader()
            {
                br = new BufferedReader(new
                        InputStreamReader(System.in));
            }

            String next()
            {
                while (st == null || !st.hasMoreElements())
                {
                    try
                    {
                        st = new StringTokenizer(br.readLine());
                    }
                    catch (IOException  e)
                    {
                        e.printStackTrace();
                    }
                }
                return st.nextToken();
            }

            int nextInt()
            {
                return Integer.parseInt(next());
            }

            long nextLong()
            {
                return Long.parseLong(next());
            }

            double nextDouble()
            {
                return Double.parseDouble(next());
            }

            String nextLine()
            {
                String str = "";
                try
                {
                    str = br.readLine();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                return str;
            }
        }
        int parent[];
        int rank[];
        int n=0;
        ArrayList<ArrayList<Integer>> arrayLists;
        boolean v1[];
        static boolean t2=false;
        boolean r=false;
        int fib[][];
        int fib1[];
        int min3=Integer.MAX_VALUE;
        public static void main(String[] args) throws IOException {
            Main g = new Main();
            g.go();
        }
        public void go() throws IOException {
            FastReader scanner=new FastReader();
//            Scanner scanner = new Scanner(System.in);
//            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
//            String s;
            PrintWriter printWriter = new PrintWriter(System.out);
            int t=1;
            for (int i = 0; i < t; i++) {
                int n=scanner.nextInt();
                long c[]=new long[n];
                long h1[]=new long[n];
                long sum=0;
                for (int j = 0; j < n; j++) {
                    long x=scanner.nextInt();
                    long h=scanner.nextInt();
                    h1[j]=h;
                    c[j]=x;
                }
                if(n>1)
                sum+=2;
                else
                    sum=1;
                boolean r=false;
                for (int j = 1; j <n-1; j++) {
                    if(h1[j]<(c[j]-c[j-1])){
                        sum++;
                    }else if(h1[j]<(c[j+1]-c[j])) {
                        sum++;
                        c[j]=c[j]+h1[j];
                    }
                }
                printWriter.println(sum);
            }
            printWriter.flush();
        }
    static final int mod=1_000_000_007;
    public long mul(long a, long b) {
        return a*b;
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
//    public void sieve(int n){
//        fib=new int[n+1];
//        fib[1]=-1;
//        fib[0]=-1;
//        for (int i =2; i*i<=n; i++) {
//            if(fib[i]==0)
//            for (int j =i*i; j <=n; j+=i){
//                fib[j]=-1;
////                System.out.println("l");
//            }
//        }
//    }
        public void parent(int n){
            for (int i = 0; i < n; i++) {
                parent[i]=i;
                rank[i]=1;
                size[i]=1;
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
               parent[p]=find(parent[p]);
           }
           return parent[p];
//            if(parent[p]==-1){
//                return -1;
//            }
//            else if(parent[p]==p){
//                return p;
//            }
//            else {
//                parent[p]=find(parent[p]);
//                return parent[p];
//            }
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
        public void dfs(ArrayList<Integer> arrayLists1){
            for (int i = 0; i < arrayLists1.size(); i++) {
                if(v1[arrayLists1.get(i)]==false){
                    System.out.println(arrayLists1.get(i));
                    v1[arrayLists1.get(i)]=true;
                    count++;
                    dfs(arrayLists.get(arrayLists1.get(i)));
                }
            }
        }
        private void dfs2(ArrayList<Integer>[]arrayList,int j,int count){
            ans[j]=count;
            for(int i:arrayList[j]){
                if(ans[i]==-1){
                    dfs2(arrayList,i,count);
                }
            }
        }
        private void dfs3(ArrayList<Integer>[] arrayList, int j) {
            v[j]=true;
            count++;
            for(int i:arrayList[j]){
                if(v[i]==false) {
                    dfs3(arrayList, i);
                }
            }
        }
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
                while(r%i==0){
//                    System.out.println(i);
                    c++;
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
            for (int i = 1; i <=Math.sqrt(r); i++) {
                if(r%i==0){
                    if(r/i==i){
                        c++;
                    }
                    else{
                        c+=2;
                    }
                }
            }
            return c;
        }
}
class Pair{
    int x;
    int y;
    double z;
    public Pair(int x,int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public int hashCode() {
        int hash =37;
        return this.x * hash + this.y;
    }
    @Override
    public boolean equals(Object o1){
        if(o1==null||o1.getClass()!=this.getClass()){
            return false;
        }
        Pair o=(Pair)o1;
        if(o.x==this.x&&o.y==this.y){
            return true;
        }
        return false;
    }
}
class Sorting implements Comparator<Pair> {
    public int compare(Pair p1,Pair p2){
//        if(p1.x==p2.x){
//            return -1*Double.compare(p1.y,p2.y);
//        }
//        else {
            return Double.compare(p1.x, p2.x);
       // }
    }

}
