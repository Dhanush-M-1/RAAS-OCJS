import javax.swing.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    static PrintWriter out = new PrintWriter(System.out);
    static long[] tree;
    static int m = 100000000;
    static int k1,k2;
    static boolean[] vis;
    static tuple[] tuples;
    public static void main(String[] args) throws IOException {
        //BufferedReader reader=new BufferedReader(new FileReader("input.txt"));
        //PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner sc=new Scanner(System.in);
        Reader sc = new Reader();
        int t=sc.nextInt();
        for (int i = 0; i <t ; i++) {
            int n=sc.nextInt(),m=sc.nextInt();
            int[] hash=new int[1005];
            for (int j = 0; j <n ; j++) {
                int x=sc.nextInt();
                if (hash[x]==0)
                    hash[x]++;
            }
            for (int j = 0; j <m ; j++) {
                int x=sc.nextInt();
                if (hash[x]==1)
                    hash[x]++;
            }
            int ans=-1;
            //System.out.println(Arrays.toString(hash));
            for (int j = 0; j <1005 ; j++) {
                if (hash[j]>1)
                    ans=j;
            }
            if (ans<0)
                out.println("NO");
            else{
                out.println("YES");
                out.println(1+" "+ans);
            }
        }






        out.close();
    }
    static boolean bfs(int a,int b){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(a);

        while (!queue.isEmpty()){
            int now=queue.poll();
            vis[now]=true;

            for (int i = 0; i <k1 ; i++) {
                if (!vis[i]){
                    if((tuples[i].a<tuples[now].a&&tuples[now].a<tuples[i].b)
                                ||(tuples[i].a<tuples[now].b&&tuples[now].b<tuples[i].b)){
                        queue.add(i);
                        if (i==b){
                            Arrays.fill(vis,false);
                            return true;
                        }
                    }
                }
            }
        }

        Arrays.fill(vis,false);
        return false;

    }
    static int find(int[] p,int x){
        if (p[x]==x)return x;

        return p[x]=find(p,p[x]);
    }
    static void union(int[] p,int a,int b){
        p[find(p,b)]=find(p,a);
    }
    static void built(long[] a,int at,int l,int r,int n){
        if (l==r){
            tree[at]=a[l];
        }
        else {
            int mid=(l+r)/2;
            int right=2*at;
            int left=(2*at)+1;
            built(a,left,l,mid,n-1);
            built(a,right,mid+1,r,n-1);
            if (n%2==0)
                tree[at]=tree[left]^tree[right];
            else
                tree[at]=tree[left]|tree[right];
        }
    }
    static void update(int at,int l,int r,int i,long v,int n){
        if (i<l || i>r)return;

        if (l==r){
            tree[at]=v;
        }
        else {
            int mid=(l+r)/2;
            int right=2*at;
            int left=(2*at)+1;
            update(left,l,mid,i,v,n-1);
            update(right,mid+1,r,i,v,n-1);
            if (n%2==0)
                tree[at]=tree[left]^tree[right];
            else
                tree[at]=tree[left]|tree[right];
        }
    }




}

    class node implements Comparable<node> {
        Integer no;
        Integer cost;
        Vector<node> adj = new Vector<>();

        public node(Integer no, Integer cost) {
            this.no = no;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "node{" +
                    "no=" + no +
                    ", cost=" + cost +
                    '}';
        }

        @Override
        public int compareTo(node o) {
            return o.cost - this.cost;
        }
    }

    class edge implements Comparable<edge> {
        tuple u;
        Double cost;

        public edge(tuple u, Double cost) {
            this.u = u;
            this.cost = cost;
        }

        @Override
        public int compareTo(edge o) {
            return this.cost.compareTo(o.cost);
        }

        @Override
        public String toString() {
            return "edge{" +
                    "u=" + u +
                    ", cost=" + cost +
                    '}';
        }
    }

    ///*
    class tuple implements Comparable<tuple> {
        Integer a;
        Integer b;

        public tuple(Integer a, Integer b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(tuple o) {
            return (int) (this.b - o.b);
        }

        @Override
        public String toString() {
            return "tuple{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }


    //*/
    class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64];
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') while ((c = read()) >= '0' && c <= '9') ret += (c - '0') / (div *= 10);
            if (neg) return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null) return;
            din.close();
        }
    }