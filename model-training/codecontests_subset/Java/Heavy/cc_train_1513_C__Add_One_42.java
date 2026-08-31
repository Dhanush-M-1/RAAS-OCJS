import java.io.*;
import java.util.*;
import java.lang.*;
public class Main{
    static InputReader sc;
    static PrintWriter pw;
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        sc = new InputReader(inputStream);
        pw = new PrintWriter(outputStream);
        solve();
        pw.close();
    }
    // static int L,R,top,bottom;
    // static int cnt,edge;
    // static long ans;
    public static void solve() {
        int t=sc.nextInt();
        long MOD=1000000007l;
        long [][]val;
        long [][]ans=new long[200010][10];   
        long temp=0; 
        val=new long[200010][10];
        val[0][0]=1;
        for(int i=1;i<=200009;i++){
            for(int j=0;j<9;j++)
                val[i][j+1]=(val[i][j+1]+val[i-1][j])%MOD;
            val[i][1]=(val[i][1]+val[i-1][9])%MOD;
            val[i][0]=(val[i][0]+val[i-1][9])%MOD;
            temp=0l;
            for(int j=0;j<10;j++)
                temp=(temp+val[i][j])%MOD;
            for(int j=0;j<=Math.min(i,9);j++)
                ans[i-j][j]=temp;
        }      
        u:while(t-->0){ 
            int n=s(0);
            int m=s(0);
            int []arr=new int[10];            
            while(n>0){
                arr[n%10]++;
                n/=10;
            }            
            long rtn=0l;
            for(int i=0;i<10;i++)
                rtn=(rtn+((ans[m][i]*(arr[i]%MOD))%MOD))%MOD;
            pln(rtn);
        }       
    }      
    public static int find(int n){
        return (n*(n+1))/2;
    } 
    public static long helper(int i, int k, int d, long [][][]dp, long MOD, long val, int n){
        if(i>n||i<=0||k==1){
            return val;
        }
        if(dp[i][k][d]!=-1l){            
            return dp[i][k][d];
        }
        if(d==0){
            dp[i][k][0]=helper(i+1,k,0,dp,MOD,val,n);
            if(k>1)
                dp[i][k][0]=(dp[i][k][0]+helper(i-1, k-1, 1, dp, MOD, val, n))%MOD;
            return dp[i][k][0];
        }
        dp[i][k][1]=helper(i-1,k,1,dp,MOD,val,n);
        if(k>1)
            dp[i][k][1]=(dp[i][k][1]+helper(i+1, k-1, 0, dp, MOD, val, n))%MOD;
        return dp[i][k][1];        
    }
    public static long sum(long n){
        long val=0l;
        while(n>0){
            val+=n%10;
            n/=10;
        }
        return val;
    }
    static class Node{
        int left,right;
        Node prev,next;
        Node(int i, int v){
            left=i;
            right=v;
            prev=next=null;
        }
        void remove(){
            this.prev.next=this.next;
            this.next.prev=this.prev;
        }
        void insert(Node node){
            node.next=this;
            node.prev=this.prev;
            node.prev.next=node;
            this.prev=node;
        }
    } 
    public static int  findDiameter(int r, List<List<Integer>>list){
        return findFarthest(findFarthest(r,list)[0],list)[1];
    }
    public static int[] findFarthest(int u, List<List<Integer>>list){
        int n=list.size();
        boolean []vis=new boolean[n+1];
        Queue<Integer>q=new LinkedList<>();
        q.offer(u);
        vis[u]=true;
        int s,pr,cnt=0;
        int []ar=new int[]{u,0};
        while(q.size()>0){
            s=q.size();
            while(s-->0){
                pr=q.poll();
                if(ar[1]<cnt){
                    ar[1]=cnt;
                    ar[0]=pr;
                }
                for(int i:list.get(pr)){
                    if(!vis[i]){
                        vis[i]=true;
                        q.offer(i);
                    }
                }
            }
            cnt++;
        }
        return ar;
    }
    public static long atMostK(char []chrr, int k){
        if(k<0)
            return 0;
        int l=0,cnt=0;
        long ans=0l;
        for(int i=0;i<chrr.length;i++){
            if(chrr[i]=='1')
                cnt++;
            while(cnt>k){
                if(chrr[l++]=='1')
                    cnt--;
            }
            ans+=(long)(i-l)+1l;
        }
        return ans;
    }
    public static int ask(int l){
        System.out.println(l);
        System.out.flush();
        return sc.nextInt();
    }
    public static void sort(long []arr){
        ArrayList<Long> list=new ArrayList<>();
        for(int i=0;i<arr.length;i++)
            list.add(arr[i]);
        Collections.sort(list);
        for(int i=0;i<arr.length;i++)
            arr[i]=list.get(i);
    }
    public static void swap(char []chrr, int i, int j){
        char temp=chrr[i];
        chrr[i]=chrr[j];
        chrr[j]=temp;
    }
    public static int countSetBits(long n){
        int a=0;
        while(n>0){
            a+=(n&1);
            n>>=1;
        }
        return a;
    }
    static class Pair{
        int v,w;
        Pair(int W, int V){
            v=V;
            w=W;
        }
     //*
    }
    /*/
        public int compareTo(Pair p){
            return (b-p.b);
        }
        public int hashCode(){
            int hashcode = (a+" "+b).hashCode();
            return hashcode;
        }
        public boolean equals(Object obj){
            if (obj instanceof Pair) {
                Pair p = (Pair) obj;
                return (p.a==this.a && p.b == this.b);
            }
            return false;
        }
    }
    //*/
    static boolean isPrime(int n) { 
        if (n <= 1) 
            return false; 
        if (n <= 3) 
            return true; 
        if (n % 2 == 0 || n % 3 == 0) 
            return false; 
        for (int i = 5; i * i <= n; i = i + 6) 
            if (n % i == 0 || n % (i + 2) == 0) 
                return false; 
        return true; 
    } 
    static long gcd(long a, long b) { 
        if (b == 0) 
            return a; 
        return a>b?gcd(b, a % b):gcd(a, b % a);  
    } 
    static long fast_pow(long base,long n,long M){
        if(n==0)
           return 1;
        if(n==1)
        return base;
        long halfn=fast_pow(base,n/2,M);
        if(n%2==0)
            return ( halfn * halfn ) % M;
        else
            return ( ( ( halfn * halfn ) % M ) * base ) % M;
    }
    static long modInverse(long n,long M){
        return fast_pow(n,M-2,M);
    }
    public static int s(int n){
        return sc.nextInt();
    }
    public static long s(long n){
        return sc.nextLong();
    }
    public static String s(String n){
        return sc.next();
    }
    public static double s(double n){
        return sc.nextDouble();
    }
    public static void p(int n){
        pw.print(n);
    }
    public static void p(long n){
        pw.print(n);
    }
    public static void p(String n){
        pw.print(n);
    }
    public static void p(double n){
        pw.print(n);
    }
    public static void pln(int n){
        pw.println(n);
    }
    public static void pln(long n){
        pw.println(n);
    }
    public static void pln(String n){
        pw.println(n);
    }
    public static void pln(double n){
        pw.println(n);
    }
    public static void feedArr(long []arr){
        for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextLong();
    }
    public static void feedArr(double []arr){
        for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextDouble();
    }
    public static void feedArr(int []arr){
        for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextInt();
    }
    public static void feedArr(String []arr){
        for(int i=0;i<arr.length;i++)
            arr[i]=sc.next();
    }
    public static String printArr(int []arr){
        StringBuilder sbr=new StringBuilder();
        for(int i:arr)
            sbr.append(i+" ");
        return sbr.toString();
    }
    public  static String printArr(long []arr){
        StringBuilder sbr=new StringBuilder();
        for(long i:arr)
            sbr.append(i+" ");
        return sbr.toString();
    }
    public static String printArr(String []arr){
        StringBuilder sbr=new StringBuilder();
        for(String i:arr)
            sbr.append(i+" ");
        return sbr.toString();
    }
    public static String printArr(double []arr){
        StringBuilder sbr=new StringBuilder();
        for(double i:arr)
            sbr.append(i+" ");
        return sbr.toString();
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
        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}