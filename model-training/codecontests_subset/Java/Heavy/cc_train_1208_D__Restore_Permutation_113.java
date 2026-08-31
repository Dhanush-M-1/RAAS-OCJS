/*Author: Satyajeet Singh, Delhi Technological University*/
    import java.io.*;
    import java.util.*;
    import java.text.*; 
    import java.lang.*;
    import java.math.*;
 
public class Main{
/*********************************************Constants******************************************/
    static PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));        
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long mod=(long)1e9+7;
    static long mod1=998244353;
    static boolean sieve[];
    static ArrayList<Integer> primes;
    static ArrayList<Long> factorial;
    static HashSet<Pair> graph[];
    static boolean oj = System.getProperty("ONLINE_JUDGE") != null;
/****************************************Solutions Begins***************************************/
    static class segmentTree{
        int n=0;
        int[] lo,hi;
        long[] value,delta;
        int idx[];
        segmentTree(int n){
            this.n=n;
            lo=new int[8*n+1];
            hi=new int[8*n+1];
            value=new long[8*n+1];
            delta=new long[8*n+1];
            init(1,1,n);
            idx=new int[8*n+1];
        } 
        void init(int i,int left,int right){
            lo[i]=left;
            hi[i]=right;
            if(left==right){
                return;
            }
            int mid=(left+right)/2;
            init(2*i,left,mid);
            init(2*i+1,mid+1,right);
        }
        void update(int left,int right,long val){
            update(1,left,right,val);
        }
        Pairl query(int left,int right){
            return query(1,left,right);
        }
        void prop(int i){
            delta[2*i]+=delta[i];
            delta[2*i+1]+=delta[i];
            delta[i]=0;
        }
        void update(int i){
            long a=value[2*i]+delta[2*i];
            long b=value[2*i+1]+delta[2*i+1];
            if(a<=b){
                value[i]=a;
                if(a==b){
                    idx[i]=Math.max(idx[2*i],idx[2*i+1]);
                }
                else{
                    idx[i]=idx[2*i];
                }
            }
            else{
                value[i]=b;
                idx[i]=idx[2*i+1];
            }
        }
        void update(int i,int left,int right,long val){
            if(left>hi[i]||right<lo[i]){
                return;
            }
            if(lo[i]>=left&&hi[i]<=right){
                delta[i]+=val;
                value[i]+=delta[i];
                
                if(left==right){
                    delta[i]=0;
                    idx[i]=left;
                    return;
                }
                prop(i);
                return;
            }
            prop(i);
            update(2*i,left,right,val);
            update(2*i+1,left,right,val);
            update(i);
        }
        Pairl query(int i,int left,int right){
            if(left>hi[i]||right<lo[i]){
                return new Pairl(Long.MAX_VALUE,-1);
            }
            if(lo[i]>=left&&hi[i]<=right){
                value[i]+=delta[i];
                prop(i);
                return new Pairl(value[i],idx[i]);
            }
            prop(i);
            Pairl l=query(2*i,left,right);
            Pairl r=query(2*i+1,left,right);
            update(i);
            if(l.u<=r.u){
                if(l.u==r.u){
                    return new Pairl(l.u,Math.max(r.v,l.v));
                }
                else{
                    return l;
                }
            }
            else{
                return r;
            }
        }
    }
    public static void main (String[] args) throws Exception {
        String st[]=nl();
        int n=pi(st[0]);
        long input[]=new long[n];
        st=nl();
        segmentTree seg=new segmentTree(n);
        for(int i=0;i<n;i++){
            input[i]=pl(st[i]);
            seg.update(i+1,i+1,input[i]);
        }
        // debug(seg.query(1,n));
        //  debug(seg.lo);
        //  debug(seg.hi);
        //  debug(seg.value);
        //  debug(seg.idx);
        int output[]=new int[n];
        for(int i=1;i<=n;i++){
            Pairl p=seg.query(1,n);
            int idx=(int)p.v;
            output[idx-1]=i;
            seg.update(idx,idx,Long.MAX_VALUE/2);
            if(idx+1<=n)
                seg.update(idx+1,n,-i);
        //         debug(i);
        //         debug(seg.lo);
        //         debug(seg.hi);

        //             debug(seg.value);
        //             debug(seg.idx);
        // debug(seg.delta);
            // out.println();
            // for(int i=0;i<n;i++){
            //     out.print(seg.query(i+1,i+1)+" ");
            // }
        }
        for(int u:output){
            out.print(u+" ");
        }
/****************************************Solutions Ends**************************************************/
        out.flush();
        out.close();
    }
/****************************************Template Begins************************************************/
    static String[] nl() throws Exception{
        return br.readLine().split(" ");
    }
    static String[] nls() throws Exception{
        return br.readLine().split("");
    }
    static int pi(String str) {
        return Integer.parseInt(str);
    }
    static long pl(String str){
        return Long.parseLong(str);
    }
    static double pd(String str){
        return Double.parseDouble(str);
    }
/***************************************Precision Printing**********************************************/
    static void printPrecision(double d){
        DecimalFormat ft = new DecimalFormat("0.00000000000000000"); 
        out.println(ft.format(d));
    }
/**************************************Bit Manipulation**************************************************/
    static void printMask(long mask){
        System.out.println(Long.toBinaryString(mask));
    }
    static int countBit(int mask){
        int ans=0;
        while(mask!=0){
            if(mask%2==1){
                ans++;
            }
            mask/=2;
        }
        return ans;
    }
/******************************************Graph*********************************************************/
    static void Makegraph(int n){
        graph=new HashSet[n];
        for(int i=0;i<n;i++){
            graph[i]=new HashSet<>();
        }
    }
    static void addEdge(int a,int b,int c){
        graph[a].add(new Pair(b,c));
    }    
/*********************************************PAIR********************************************************/
    static class PairComp implements Comparator<Pair>{
        public int compare(Pair p1,Pair p2){
            return -((p1.u+p1.v)-(p2.u+p2.v));
        }
    }
    static class Pair implements Comparable<Pair> {
        int u;
        int v;
        int index=-1;
        public Pair(int u, int v) {
            this.u = u;
            this.v = v;
        }
        public int hashCode() {
            int hu = (int) (u ^ (u >>> 32));
            int hv = (int) (v ^ (v >>> 32));
            return 31 * hu + hv;
        }
        public boolean equals(Object o) {
            Pair other = (Pair) o;
            return u == other.u && v == other.v;
        }
        public int compareTo(Pair other) {
            if(index!=other.index)
                return Long.compare(index, other.index);
            return Long.compare(v, other.v)!=0?Long.compare(v, other.v):Long.compare(u, other.u);
        }
        public String toString() {
            return "[u=" + u + ", v=" + v + "]";
        }
    }
/******************************************Long Pair*************************************************/
    static class PairCompL implements Comparator<Pairl>{
        public int compare(Pairl p1,Pairl p2){
            long aa=p2.v-p1.v;
            if(aa<0){
                return -1;
            }
            else if(aa>0){
                return 1;
            }
            else{
                return 0;
            }
        }
    }
    static class Pairl implements Comparable<Pairl> {
            long u;
            long v;
            int index=-1;
            public Pairl(long u, long v) {
                this.u = u;
                this.v = v;
            }
    
            public int hashCode() {
                int hu = (int) (u ^ (u >>> 32));
                int hv = (int) (v ^ (v >>> 32));
                return 31 * hu + hv;
            }
    
            public boolean equals(Object o) {
                Pair other = (Pair) o;
                return u == other.u && v == other.v;
            }
    
            public int compareTo(Pairl other) {
                if(index!=other.index)
                    return Long.compare(index, other.index);
                return Long.compare(v, other.v)!=0?Long.compare(v, other.v):Long.compare(u, other.u);
            }
    
            public String toString() {
                return "[u=" + u + ", v=" + v + "]";
            }
        }
/*****************************************DEBUG***********************************************************/
    public static void debug(Object... o) {
        if(!oj)
        System.out.println(Arrays.deepToString(o));
    }
/************************************MODULAR EXPONENTIATION***********************************************/
    static long modulo(long a,long b,long c) {
        long x=1;
        long y=a;
        while(b > 0){
            if(b%2 == 1){
                x=(x*y)%c;
            }
            y = (y*y)%c; // squaring the base
            b /= 2;
        }
        return  x%c;
    }
/********************************************GCD**********************************************************/
    static long gcd(long x, long y)
    {
        if(x==0)
            return y;
        if(y==0)
            return x;
        long r=0, a, b;
        a = (x > y) ? x : y; // a is greater number
        b = (x < y) ? x : y; // b is smaller number
        r = b;
        while(a % b != 0)
        {
            r = a % b;
            a = b;
            b = r;
        }
        return r;
    }
/******************************************SIEVE**********************************************************/
    static void sieveMake(int n){
        sieve=new boolean[n];
        Arrays.fill(sieve,true);
        sieve[0]=false;
        sieve[1]=false;
        for(int i=2;i*i<n;i++){
            if(sieve[i]){
                for(int j=i*i;j<n;j+=i){
                    sieve[j]=false;
                }
            }
        }
        primes=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            if(sieve[i]){
                primes.add(i);
            }
        }        
    }
/********************************************End***********************************************************/
}