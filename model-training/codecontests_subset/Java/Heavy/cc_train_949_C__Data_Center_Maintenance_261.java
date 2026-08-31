import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.Consumer;
import java.util.Stack;
import java.util.StringTokenizer;

public class TimeShift {
    static class Digraph {
        public Digraph(int n) {
            mEdges = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                mEdges.add(i, new ArrayList<>());
            }
        }
        
        public void addEdge(int f, int t) {
            mEdges.get(f).add(t);
        }
        
        public Iterable<Integer> adj(int e) {
            return mEdges.get(e);
        }
        
        public int size() {
            return mEdges.size();
        }
        
        public Digraph invert() {
            Digraph result = new Digraph(mEdges.size());
            
            for (int f = 0; f < mEdges.size(); f++) {
                for (int t : mEdges.get(f)) {
                    result.addEdge(t, f);
                }
            }
            
            return result;
        }
        
        private final ArrayList<ArrayList<Integer>> mEdges;
    }
    
    public static void postorder(Digraph d, int start, HashSet<Integer> visited, Consumer<Integer> visit) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.empty()) {
            int v = stack.pop();
            if (visited.contains(v)) {
                visit.accept(v);
                //System.out.println("post: " + v);
                continue;
            }
            visited.add(v);
            //System.out.println("pre: " + v);
            stack.push(v);
            for (int n : d.adj(v)) {
                if (!visited.contains(n)) stack.push(n);
            }
        }
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next() {
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
 
        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int h = sc.nextInt();
        
        int updateHour[] = new int[n];
        for (int i = 0; i < n; i++) {
            updateHour[i] = sc.nextInt();
        }
        
        Digraph g = new Digraph(n);
        
        for (int i = 0; i < m; i++) {
            int c1 = sc.nextInt() - 1;
            int c2 = sc.nextInt() - 1;
            
            if ((updateHour[c1] + 1) % h == updateHour[c2]) {
                g.addEdge(c1, c2);
            }
            if ((updateHour[c2] + 1) % h == updateHour[c1]) {
                g.addEdge(c2, c1);
            }
        }
        
        Digraph gr = g.invert();
        final Stack<Integer> order = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) continue;
            //System.out.println("start: " + i);
            postorder(gr, i, visited, v -> order.push(v));
        }
        
        final int component[] = new int[n];
        int compNum = 0;
        
        visited.clear();
        while (!order.empty()) {
            int i = order.pop();
            if (visited.contains(i)) continue;
            //System.out.println("order: " + i);
            final int compNumCopy = compNum++;
            postorder(g, i, visited, v -> component[v] = compNumCopy);
        }
        
        int compSize[] = new int[compNum];
        for (int i = 0; i < n; i++) {
            //System.out.println("comp: " + i + " -> " + component[i]);
            compSize[component[i]]++;
        }
        
        boolean source[] = new boolean[compNum];
        
        for (int i = 0; i < n; i++) {
            for (int j : g.adj(i)) {
                if (component[i] != component[j]) {
                    //System.out.println("source: " + i + " -> " + j + ": " + component[i]);
                    source[component[i]] = true;
                }
            }
        }
        
        int minComp = -1;
        int minCompSize = Integer.MAX_VALUE;
        for (int i = 0; i < compNum; i++) {
            //System.out.println("size: " + i + " -> " + compSize[i] + ": " + source[i]);
            if (!source[i] && compSize[i] < minCompSize) {
                minComp = i;
                minCompSize = compSize[i];
            }
        }
        
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        System.out.println("" + minCompSize);
        for (int i = 0; i < n; i++) {
            if (component[i] == minComp) {
                writer.print(i+1);
                writer.print(" ");
            }
        }
        writer.println();
        writer.flush();
    }
}