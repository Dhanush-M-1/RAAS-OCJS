import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Vector;


public class TaskD {

    public static void main(String[] args) throws Exception{

        TaskD task = new TaskD();
        task.solve();

    }

    public void solve() throws Exception{



        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        String line = bi.readLine();

        //int n = scanner.nextInt();
        //int m = scanner.nextInt();

        int n = Integer.parseInt(line.split("\\s")[0]);
        int m = Integer.parseInt(line.split("\\s")[1]);

        //System.out.println(n);
        //System.out.println(m);

        DSU dsu = new DSU(n);

        int[] rearrangement = new int[n];
        int[] newarrange = new int[n];

        line = bi.readLine();
        int ii = -1;
        for (String numStr : line.split("\\s")) {
            ++ii;
            //System.out.println(numStr);
            rearrangement[ii] = Integer.parseInt(numStr);
        }

        for (int j = 0; j < m; ++j) {
            line = bi.readLine();

            int a = Integer.parseInt(line.split("\\s")[0]) - 1;
            int b = Integer.parseInt(line.split("\\s")[1]) - 1;
            //System.out.println(a + ", " + b);
            dsu.union_sets(a, b);
        }

        Map<Integer, Vector<Integer>> components = new TreeMap<Integer, Vector<Integer>>();

        for (int i = 0; i < n; ++i) {
            Integer set = dsu.find_set(Integer.valueOf(i));
            //System.out.println("set=" + set + ", i=" + i);
            if (!components.containsKey(Integer.valueOf(set))) {
                components.put(set, new Vector<Integer>());
            }
            components.get(Integer.valueOf(set)).add(Integer.valueOf(i));
            //System.out.println(components.get(set).size());
        }

        for (Map.Entry<Integer, Vector<Integer>> entry : components.entrySet()) {
            int set = entry.getKey();

            Vector<Integer> vertice = entry.getValue();
            Vector<Integer> subarrange = new Vector<Integer>();
            //System.out.println(set);
            //System.out.println(vertice);
            for (int v : vertice) {
                subarrange.add(-rearrangement[v]);
            }
            //System.out.println(subarrange);
            Collections.sort(subarrange);
            for (int i = 0; i < subarrange.size(); ++i) {
                newarrange[vertice.elementAt(i)] = -subarrange.elementAt(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int v : newarrange) {
            sb.append(v);
            sb.append(" ");

        }

        System.out.println(sb.toString());

    }

    class DSU {

        int[] parent;
        int[] rank;

        public void make_set (int v) {
            parent[v] = v;
            rank[v] = 0;
        }

        public int find_set (int v) {
            if (v == parent[v])
                return v;
            return parent[v] = find_set (parent[v]);
        }

        public void union_sets (int a, int b) {
            a = find_set (a);
            b = find_set (b);
            if (a != b) {
                if (rank[a] < rank[b]) {
                    int c = a;
                    a = b;
                    b = c;
                }
                parent[b] = a;
                if (rank[a] == rank[b])
                    ++rank[a];
            }
        }

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; ++i) {
                make_set(i);
            }

        }

    }


}