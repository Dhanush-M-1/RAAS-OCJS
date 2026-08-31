import java.util.*;
import java.io.*;

public class TestClass {

    static class Parser
    {
        final private int BUFFER_SIZE = 1 << 16;

        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Parser(InputStream in)
        {
            din = new DataInputStream(in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public long nextLong() throws Exception
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = c == '-';
            if (neg) c = read();
            do
            {
                ret = ret * 10 + c - '0';
                c = read();
            } while (c > ' ');
            if (neg) return -ret;
            return ret;
        }

        //reads in the next string
        public String next() throws Exception
        {
            StringBuilder ret =  new StringBuilder();
            byte c = read();
            while (c <= ' ') c = read();
            do
            {
                ret = ret.append((char)c);
                c = read();
            } while (c > ' ');
            return ret.toString();
        }

        public int nextInt() throws Exception
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = c == '-';
            if (neg) c = read();
            do
            {
                ret = ret * 10 + c - '0';
                c = read();
            } while (c > ' ');
            if (neg) return -ret;
            return ret;
        }

        private void fillBuffer() throws Exception
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws Exception
        {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
    }
    static class OutputWriter
    {
        private PrintWriter writer;

        public OutputWriter(OutputStream stream)
        {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                    stream)));
        }

        public OutputWriter(Writer writer)
        {
            this.writer = new PrintWriter(writer);
        }

        public void println(int x)
        {
            writer.println(x);
        }

        public void print(int x)
        {
            writer.print(x);
        }

        public void println(char x)
        {
            writer.println(x);
        }

        public void print(char x)
        {
            writer.print(x);
        }

        public void println(int array[], int size)
        {
            for (int i = 0; i < size; i++)
                println(array[i]);
        }

        public void print(int array[], int size)
        {
            for (int i = 0; i < size; i++)
                print(array[i] + " ");
        }

        public void println(long x)
        {
            writer.println(x);
        }

        public void print(long x)
        {
            writer.print(x);
        }

        public void println(long array[], int size)
        {
            for (int i = 0; i < size; i++)
                println(array[i]);
        }

        public void print(long array[], int size)
        {
            for (int i = 0; i < size; i++)
                print(array[i]);
        }

        public void println(float num)
        {
            writer.println(num);
        }

        public void print(float num)
        {
            writer.print(num);
        }

        public void println(double num)
        {
            writer.println(num);
        }

        public void print(double num)
        {
            writer.print(num);
        }

        public void println(String s)
        {
            writer.println(s);
        }

        public void print(String s)
        {
            writer.print(s);
        }

        public void println()
        {
            writer.println();
        }

        public void printSpace()
        {
            writer.print(" ");
        }

        public void printf(String format, Object args)
        {
            writer.printf(format, args);
        }

        public void flush()
        {
            writer.flush();
        }

        public void close()
        {
            writer.close();
        }

    }
    static class Point{
        Long x;
        int i;
        //   boolean left;
        Point(long x,int i){
            this.x=x;
            this.i=i;
            //  this.left=left;

        }}
        static int len[];
    static ArrayList<Integer> list=new ArrayList<>();
    static int max=0;
    static int indx=-1;
        static class Graph {
                private int V;
                private LinkedList<Integer> adj[];
                Graph(int v) {
                    V = v;
                    adj = new LinkedList[v];
                    for (int i = 0; i < v; ++i)
                        adj[i] = new LinkedList();
                }
                void addEdge(int v, int w) {
                    adj[v].add(w);
                }
                void DFSUtil(int v, boolean visited[],int lev[]) {
                    visited[v] = true;
                  //  System.out.print(v + " ");
                    Iterator<Integer> i = adj[v].listIterator();
                    while (i.hasNext()) {
                        int n = i.next();
                        if (!visited[n]){
                            lev[n]=lev[v]+1;
                            if(max<lev[n]){
                                max=lev[n];
                                indx=n;
                            }
                            DFSUtil(n, visited,lev);}
                    }
                }
            void DFSUtil2(int v, boolean visited[],int lev[]) {
                visited[v] = true;
              //  System.out.print(v + " ");
                Iterator<Integer> i = adj[v].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    if (!visited[n]){
                        lev[n]=lev[v]+1;
                        if(max<lev[n]){
                            max=lev[n];
                            indx=n;
                        }
                        DFSUtil2(n, visited,lev);}
                }
            }
                void DFS() {
                    boolean visited[] = new boolean[V];
                    int level[]=new int[V];
                    boolean visited2[] = new boolean[V];
                    int level2[]=new int[V];
                    for (int i = 0; i < V; ++i)
                        if (visited[i] == false){
                          //  System.out.println(i+" "+true);
                        indx=i;
                            max=0;
                            DFSUtil(i, visited, level);
                            max=0;
                            DFSUtil2(indx,visited2,level2);
                            len[indx]=max;
                            list.add(indx);
                    }
                }
                void bfs(){
                    int Visit[]=new int[V];
                   // System.out.println(Arrays.asList(list));
                    for (int i = 0; i <list.size(); i++) {
                        Queue<Integer> queue=new LinkedList<>();
                        int x=list.get(i);
                        queue.add(x);
                       // System.out.println(x+"   here");

                        Visit[x]=1;
                        while (!queue.isEmpty()){
                            int y=queue.poll();

                            Iterator<Integer> j=adj[y].listIterator();
                            while (j.hasNext()){
                                int n=j.next();
                                if(Visit[n]==0){
                                    Visit[n]=1;
                                    len[n]=len[x];
                                    queue.add(n);
                                }
                            }
                        }
                    }
                }
            }
            static int max(int a,int b,int c){
                int max=a;
                if(max<b)
                    max=b;
                if(max<c)
                    max=c;
              return max;

            }
    public static void main(String args[]) throws Exception {
        Parser s=new Parser(System.in);
        OutputWriter out=new OutputWriter(System.out);
        int N=s.nextInt();
        int M=s.nextInt();
        int Q=s.nextInt();
         len=new int[N];
        Graph g=new Graph(N);
        Initialize(N);
        for (int i = 0; i <M ; i++) {
            int x=s.nextInt()-1;
            int y=s.nextInt()-1;
            g.addEdge(x,y);
            g.addEdge(y,x);
            union(x,y);
        }
        g.DFS();
        g.bfs();/*
        for (int i = 0; i <N ; i++) {
            System.out.print(len[i]+" ");
        }
        System.out.println("----------------");*/
        while (Q-->0){
            int type=s.nextInt();
            if(type==1){
                int x=s.nextInt()-1;
                int root=root(x);
               out.println(len[root]);
            }
            else{
                int x=s.nextInt()-1;
                int y=s.nextInt()-1;
                int r1=root(x);
                int r2=root(y);
                int v=len[r1]/2+len[r2]/2+1;
                if(len[r1]%2!=0)
                    v++;
                if(len[r2]%2!=0)
                    v++;
                if(r1!=r2){
                union(r1,r2);
                int root=root(r1);
                len[root]=max(len[r1],len[r2],v);
                   // System.out.println(len[root]);
                }
            }
           // System.out.println(Arrays.toString(len)+"  "+Q);
        }out.close();

    }
        static int size[];
        static int arr[];
        static   void Initialize(int N){
            arr=new int[N];
            size=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=i;
                size[i]=1;
            }
        }
        static int root(int i){
            while(arr[i]!=i){
                arr[i]=arr[arr[i]];
                i=arr[i];
            }
            return i;
        }
        static void union(int A,int B){
            int rootA=root(A);
            int rootB=root(B);
            if(size[rootA]<size[rootB]){

                arr[rootA]=rootB;
                size[rootB]+=size[rootA];
            }
            else{
                arr[rootB]=rootA;
                size[rootA]+=size[rootB];
            }
        }
        static boolean find(int A,int B)
        {
            if( root(A)==root(B) )       //if A and B have the same root, it means that they are connected.
                return true;
            else
                return false;
        }

    }


