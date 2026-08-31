
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


// graph, dfs,bfs, get connected components,iscycle, isbipartite, dfs on trees



public class scratch_25{
    static class Graph{

        public static class Vertex{
            HashMap<Integer,Integer> nb= new HashMap<>();     // for neighbours of each vertex
        }

        public static HashMap<Integer,Vertex> vt;   // for vertices(all)

        public Graph(){
            vt= new HashMap<>();
        }

        public static int numVer(){
            return vt.size();
        }

        public static boolean contVer(int ver){
            return vt.containsKey(ver);
        }

        public static void addVer(int ver){
            Vertex v= new Vertex();
            vt.put(ver,v);
        }






        public static void addEdge(int ver1, int ver2, int weight){
            if(!vt.containsKey(ver1) || !vt.containsKey(ver2)){
                return;
            }
            Vertex v1= vt.get(ver1);
            Vertex v2= vt.get(ver2);
            v1.nb.put(ver2,weight);                                 // if previously there is an edge, then this replaces that edge
            v2.nb.put(ver1,weight);
        }

        public static void delEdge(int ver1, int ver2){

            if(!vt.containsKey(ver1) || !vt.containsKey(ver2)){
                return;
            }
            vt.get(ver1).nb.remove(ver2);
            vt.get(ver2).nb.remove(ver1);
        }
        public static void delVer(int ver){
            if(!vt.containsKey(ver)){
                return;
            }
            Vertex v1= vt.get(ver);
            ArrayList<Integer> arr= new ArrayList<>(v1.nb.keySet());
            for (int i = 0; i <arr.size() ; i++) {
                int s= arr.get(i);
                vt.get(s).nb.remove(ver);
            }
            vt.remove(ver);
        }
        static boolean done[];
        static int parent[];
        static ArrayList<Integer>vals= new ArrayList<>();


        public static boolean isCycle(int i){
            Stack<Integer>stk= new Stack<>();

            stk.push(i);
            while(!stk.isEmpty()){
                int x= stk.pop();
                vals.add(x);
                //   System.out.print("current="+x+" stackinit="+stk);
                if(!done[x]){
                    done[x]=true;
                }
                else if(done[x] ){
                    return true;
                }

                ArrayList<Integer>ar= new ArrayList<>(vt.get(x).nb.keySet());
                for (int j = 0; j <ar.size() ; j++) {
                    if(parent[x]!=ar.get(j)){
                        parent[ar.get(j)]=x;
                        stk.push(ar.get(j));
                    }
                }
                // System.out.println(" stackfin="+stk);
            }
            return false;
        }
        static int[]level;
        static int[] curr;
        static int[] fin;

        public static void dfs(int src){
            done[src]=true;
            level[src]=0;
            Queue<Integer>q= new LinkedList<>();
            q.add(src);
            while(!q.isEmpty()){
                int x= q.poll();
                ArrayList<Integer>arr= new ArrayList<>(vt.get(x).nb.keySet());
                for (int i = 0; i <arr.size() ; i++) {
                    int v= arr.get(i);
                    if(!done[v]){
                        level[v]=level[x]+1;
                        done[v]=true;
                        q.offer(v);
                    }
                }
            }
        }
        static int oc[];
        static int ec[];


        public static void dfs1(int src){
            Queue<Integer>q= new LinkedList<>();
            q.add(src);
            done[src]= true;
            //    int count=0;
            while(!q.isEmpty()){

                int x= q.poll();
                //   System.out.println("x="+x);
                int even= ec[x];
                int odd= oc[x];
                if(level[x]%2==0){
                    int val= (curr[x]+even)%2;
                    if(val!=fin[x]){
                        //  System.out.println("bc");
                        even++;
                        vals.add(x);
                    }
                }
                else{
                    int val= (curr[x]+odd)%2;
                    if(val!=fin[x]){
                        //   System.out.println("bc");
                        odd++;
                        vals.add(x);
                    }

                }
                ArrayList<Integer>arr= new ArrayList<>(vt.get(x).nb.keySet());
                //   System.out.println(arr);
                for (int i = 0; i <arr.size() ; i++) {
                    int v= arr.get(i);
                    if(!done[v]){
                        done[v]=true;
                        oc[v]=odd;
                        ec[v]=even;
                        q.add(v);
                    }
                }
            }

        }

        static long popu[];
        static long happy[];
        static long count[]; // total people crossing that pos
        static long sum[]; // total sum of happy people including that.


        public static void bfs(int x){
            done[x]=true;
            long total= popu[x];
//            long smile= happy[x];
            ArrayList<Integer>nbrs= new ArrayList<>(vt.get(x).nb.keySet());
            for (int i = 0; i <nbrs.size() ; i++) {
                int r= nbrs.get(i);
                if(!done[r]){
                    bfs(r);
                    total+=count[r];
//                    smile+=sum[r];
                }
            }
            count[x]=total;
//            sum[x]=smile;
        }


        public static void bfs1(int x){
            done[x]=true;
//            long total= popu[x];
            long smile= 0;
            ArrayList<Integer>nbrs= new ArrayList<>(vt.get(x).nb.keySet());
            for (int i = 0; i <nbrs.size() ; i++) {
                int r= nbrs.get(i);
                if(!done[r]){
                    bfs1(r);
//                    total+=count[r];
                    smile+=happy[r];
                }
            }
//            count[x]=total;
            sum[x]=smile;
        }


    }




    static class Reader {
        static BufferedReader reader;
        static StringTokenizer tokenizer;

        /**
         * call this method to initialize reader for InputStream
         */
        static void init(InputStream input) {
            reader = new BufferedReader(
                    new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        /**
         * get next word
         */
        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                //TODO add check for eof if necessary
                tokenizer = new StringTokenizer(
                        reader.readLine());
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        static long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }


    static class Pair implements Comparable<Pair>     {
        long pos;
        long val;



        public Pair(long pos, long val) {
            this.pos = pos;
            this.val = val;


        }


        @Override
        public String toString() {
            return pos + " " + val;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.val >o.val){
                return 1;
            }
            else if(this.val==o.val){
                if(this.pos>o.pos){
                    return 1;
                }
                else if(this.pos==o.pos){
                    return 0;
                }
                else{
                    return -1;
                }
//                return 0;
            }
            else{
                return -1;
            }
        }


    }
    static ArrayList<Pair> findSubArrays(long[] arr, int n)
    {
        // create an empty map
        HashMap<Long,ArrayList<Integer>> map = new HashMap<>();

        // create an empty vector of pairs to store
        // subarray starting and ending index
        ArrayList<Pair> out = new ArrayList<>();

        // Maintains sum of elements so far
        long sum = 0;

        for (int i = 0; i < n; i++)
        {
            // add current element to sum
            sum += arr[i];

            // if sum is 0, we found a subarray starting
            // from index 0 and ending at index i
            if (sum == 0)
                out.add(new Pair(0, i));
            ArrayList<Integer> al = new ArrayList<>();

            // If sum already exists in the map there exists
            // at-least one subarray ending at index i with
            // 0 sum
            if (map.containsKey(sum))
            {
                // map[sum] stores starting index of all subarrays
                al = map.get(sum);
                for (int it = 0; it < al.size(); it++)
                {
                    out.add(new Pair(al.get(it) + 1, i));
                }
            }
            al.add(i);
            map.put(sum, al);
        }
        return out;
    }




    // After writing solution, quick scan for:
    //   array out of bounds
    //   special cases e.g. n=1?
    //
    // Big numbers arithmetic bugs:
    //   int overflow
    //   sorting, or taking max, or negative after MOD

    // out.append("Case #"+(tt+1)+": ");





    public static void main(String[] args)  throws IOException {
        Reader.init(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t= Reader.nextInt();
        long mod= (long)1e9 +7;
        long dp[][]= new long[200000+2][11];
        for (int i = 0; i <10 ; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i <200000+2 ; i++) {
            for (int j = 0; j <9 ; j++) {
                dp[i][j]= dp[i-1][j+1];
            }
            dp[i][9]= (dp[i-1][0]%mod+dp[i-1][1]%mod)%mod;
        }

//        for (int i = 0; i <2 ; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

        for (int tt = 0; tt <t ; tt++) {
            String s= Reader.next();
            int moves= Reader.nextInt();
            long ans=0;
            for (int i = 0; i <s.length() ; i++) {
                ans=(ans%mod+dp[moves][Integer.parseInt(s.charAt(i)+"")]%mod)%mod;
            }
            out.append(ans+"\n");
















        }
        out.flush();
        out.close();
    }











    public static String convert(String s,int n){
        if(s.length()==n){
            return s;
        }
        else{
            int x= s.length();
            int v=n-x;
            String str="";
            StringBuilder s2= new StringBuilder();
            for (int i = 0; i <v ; i++) {
                s2.append('0');
            }
            StringBuilder s1= new StringBuilder(s);
            s2.append(s1);

//            str+=s;
            String q= s2.toString();
            return q;

        }
    }
    public static int lower(int arr[],int key){
        int low = 0;
        int high = arr.length-1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(arr[mid] >= key){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }

    public static int upper(int arr[],int key){
        int low = 0;
        int high = arr.length-1;
        while(low < high){
            int mid = low + (high - low+1)/2;
            if(arr[mid] <= key){
                low = mid;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }





    static long modExp(long a, long b, long mod) {
        //System.out.println("a is " + a + " and b is " + b);
        if (a==1) return 1;
        long ans = 1;
        while (b!=0) {
            if (b%2==1) {
                ans = (ans*a)%mod;
            }
            a = (a*a)%mod;
            b/=2;
        }
        return ans;
    }


    public static long modmul(long a, long b, long mod) {
        return b == 0 ? 0 : ((modmul(a, b >> 1, mod) << 1) % mod + a * (b & 1)) % mod;
    }

    static long sum(long n){
        //   System.out.println("lol="+ (n*(n-1))/2);
        return (n*(n+1))/2;
    }






    public static ArrayList<Integer> Sieve(int n) {
        boolean arr[]= new boolean [n+1];
        Arrays.fill(arr,true);
        arr[0]=false;
        arr[1]=false;
        for (int i = 2; i*i <=n ; i++) {
            if(arr[i]){
                for (int j = 2; j <=n/i ; j++) {
                    int u= i*j;
                    arr[u]=false;
                }}
        }
        ArrayList<Integer> ans= new ArrayList<>();
        for (int i = 0; i <n+1 ; i++) {
            if(arr[i]){
                ans.add(i);
            }
        }
        return ans;
    }




    static long power( long x, long y, long p)
    {

        long res = 1;


        x = x % p;

        if (x == 0) return 0;

        while (y > 0)
        {

            if((y & 1)==1)
                res = (res * x) % p;


            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    public static long ceil_div(long a, long b){
        return (a+b-1)/b;
    }

    static long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static long lcm(long a, long b)
    {
        return (a*b)/gcd(a, b);
    }

}