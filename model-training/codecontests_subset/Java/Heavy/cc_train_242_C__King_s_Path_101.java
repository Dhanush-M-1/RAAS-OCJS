
import java.util.*;
import java.io.*;

public class CodeForces {

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        long x1 = Reader.nextInt(), y1 = Reader.nextInt();
        long x2 = Reader.nextInt(), y2 = Reader.nextInt();
        
        int n = Reader.nextInt();
        int cnt = 0;
        HashSet<Long> avil = new HashSet();
        HashSet<Long> vis = new HashSet();
        long codeX = 1000000001;
        
        for(int i = 0; i < n; i++) {
            long r = Reader.nextInt();
            int a = Reader.nextInt(), b = Reader.nextInt();
            
            for (int j = a; j <= b; j++)
                avil.add(r*codeX+j);
        }
        
        
        long src = x1 * codeX + y1;
        long dist = x2 * codeX + y2;
        
        Queue q = new Queue(1000000);
        q.push(src);
        vis.add(src);
        int depth = 0;
        
        while(!q.isEmpty()){
            int size = q.size;
            depth++;
            
            for (int i = 0; i < size; i++) {
                long ne = q.pop();
                long x = ne / codeX;
                long y = ne % codeX;
                
                for (int j = 0; j < 8; j++) {
                    long xi = x + dx[j]; 
                    long yi = y + dy[j];
                    long e = xi * codeX + yi;
                    
                    if(e == dist){
                        System.out.println(depth);
                        return;
                    }
                    
                    if(avil.contains(e) && !vis.contains(e)){
                        q.push(e);
                        vis.add(e);
                    }
                }
            }
        }
        
        System.out.println(-1);
    }
    
    static boolean v[];
    static Pair arr[];
    static ArrayList<Integer> g[];
    static int dx[] = {1, 0, -1, 0, 1, 1, -1, -1};
    static int dy[] = {0, 1, 0, -1, 1, -1, 1, -1};
}

class Queue{
    int first = -1, last = -1, size = 0;
    long arr[];
    
    Queue(int n){
        arr = new long[n+10];
    }
    
    long pop(){
        size--;
        return arr[++first];
    }
    
    void push(long x){
        size++;
        arr[++last] = x;
    }
    
    boolean isEmpty(){
        return first == last;
    }
}
class Pair implements Comparable<Pair> {

    int x;
    int y;

    Pair(int a, int b) {
        x = a;
        y = b;
    }

    @Override
    public int compareTo(Pair t) {
        return x - t.x;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        return ((Pair)o).x == x && ((Pair)o).y == y;
    }
    
    
    
    
}

class Reader {

    static BufferedReader reader;
    static StringTokenizer tokenizer;

    public static int pars(String x) {
        int num = 0;
        int i = 0;
        if (x.charAt(0) == '-') {
            i = 1;
        }
        for (; i < x.length(); i++) {
            num = num * 10 + (x.charAt(i) - '0');
        }

        if (x.charAt(0) == '-') {
            return -num;
        }

        return num;
    }

    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }

    static void init(FileReader input) {
        reader = new BufferedReader(input);
        tokenizer = new StringTokenizer("");
    }

    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return pars(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}
