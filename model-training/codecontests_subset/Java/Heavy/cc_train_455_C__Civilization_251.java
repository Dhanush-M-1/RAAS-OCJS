import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Code {
    static boolean skip = false;
    public static void main(String[] args) throws IOException {
        // Use the Scanner class
        FastScanner sc = new FastScanner(System.in);
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int m_org = m;
        Forest f = new Forest(n);
        while (m-- > 0) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            f.F.get(u).add(v);
            f.F.get(v).add(u);
        }
       f.compute_diameter_map();

       StringBuilder sb = new StringBuilder();
        while(q-- > 0) {
            int c = sc.nextInt();
            if (c == 2) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                f.merge(a, b);
            } else {
                int a = sc.nextInt() - 1;
                sb.append(f.find_diamater(a));
                sb.append("\n");
            }
        }
        out.println(sb.toString());
        out.flush();
    }

    static class Forest {

        UnionFind region_id;
        int n;
        ArrayList<List<Integer>> F;

        int[] node_comp;
        int[] comp_diam;

        Map<Integer, Integer> region_center ; // map region_id to the current center

        public Forest(int n) {
            this.n = n;
            region_id = new UnionFind(n);
            F  = new ArrayList<>(n);

            node_comp  = new int[n];
            comp_diam  = new int[n];

            region_center  = new HashMap<>();

            for (int i = 0; i < n; ++i) {
                F.add(new ArrayList<>());
            }
        }

        void compute_diameter_map() {
            Set<Integer> visited = new HashSet<>();
            int c_id = 0;
            for (int node = 0; node < n; ++node) {
                if (!visited.contains(node)) {
                    NodeWithDist furthest_leaf = find_furthest_node(node, visited, c_id);
                    NodeWithDist furthest_furthest_leaf = find_furthest_node(furthest_leaf.id, visited, c_id);
                    comp_diam[c_id] = furthest_furthest_leaf.dist;
                    int reg_id = region_id.find(c_id);
                    region_center.put(reg_id, c_id);
                    c_id++;
                }
            }
        }

        NodeWithDist find_furthest_node(int root, Set<Integer> visited, int c_id) {
            Set<Integer> explored = new HashSet<>();
            Queue<NodeWithDist> q = new LinkedList<>();
            NodeWithDist last_node = new NodeWithDist(root, 0);
            q.add(last_node);
            visited.add(root);
            explored.add(root);
            while(!q.isEmpty()) {
                NodeWithDist cur = q.poll();
                node_comp[cur.id] = c_id;
                last_node = cur;
                for (int ch : F.get(cur.id)) {
                    if(!explored.contains(ch)) {
                        q.add(new NodeWithDist(ch, cur.dist + 1));
                        visited.add(ch);
                        explored.add(ch);
                    }
                }

            }
            return last_node;

        }

        static class NodeWithDist {
            int id;
            int dist;

            public NodeWithDist(int id, int dist) {
                this.id = id;
                this.dist = dist;
            }
        }

        int find_diamater(int n) {
            int first_component = node_comp[n];
            int reg_id = region_id.find(first_component);
            int cur_comp = region_center.get(reg_id);
            return comp_diam[cur_comp];
        }

        void merge(int n1, int n2) {
            if (n1 == n2) {
                return;
            }
            int c1 = node_comp[n1];
            int c2 = node_comp[n2];

            if (c1 == c2) {
                return;
            }

            int reg_id_1 = region_id.find(c1);
            int cur_center_1 = region_center.get(reg_id_1);

            int reg_id_2 = region_id.find(c2);
            int cur_center_2 = region_center.get(reg_id_2);

            if (cur_center_1 == cur_center_2) {
                return;
            }

            int new_center = merge_centers(cur_center_1,cur_center_2);
            region_id.unify(cur_center_1, cur_center_2);
            region_center.put(region_id.find(cur_center_1), new_center);
        }

        int merge_centers(int c1, int c2) {
            int c1_diam = comp_diam[c1];
            int c2_diam = comp_diam[c2];

            int new_diam = half(c1_diam) + half(c2_diam) + 1;
            new_diam = Math.max(new_diam, Math.max(c1_diam, c2_diam));

            int node_id = c1_diam >= c2_diam ? c1: c2;
            comp_diam[node_id] =new_diam;
            return node_id;
        }

        int half(int x) {
            return x % 2 == 0 ? x /2 : (x/2) + 1;
        }
    }

    static class UnionFind {

      // The number of elements in this union find
      private int size;

      // Used to track the size of each of the component
      private int[] sz;

      // id[i] points to the parent of i, if id[i] = i then i is a root node
      private int[] id;

      // Tracks the number of components in the union find
      private int numComponents;

      public UnionFind(int size) {

        if (size <= 0)
          throw new IllegalArgumentException("Size <= 0 is not allowed");

        this.size = numComponents = size;
        sz = new int[size];
        id = new int[size];

        for(int i = 0; i < size; i++) {
          id[i] = i; // Link to itself (self root)
          sz[i] = 1; // Each component is originally of size one
        }

      }

      // Find which component/set 'p' belongs to, takes amortized constant time.
      public int find(int p) {

        // Find the root of the component/set
        int root = p;
        while( root != id[root] )
          root = id[root];

        // Compress the path leading back to the root.
        // Doing this operation is called "path compression"
        // and is what gives us amortized time complexity.
        while(p != root) {
          int next = id[p];
          id[p] = root;
          p = next;
        }

        return root;

      }

      // This is an alternative recursive formulation for the find method
      // public int find(int p) {
      //   if (p == id[p]) return p;
      //   return id[p] = find(id[p]);
      // }

      // Return whether or not the elements 'p' and
      // 'q' are in the same components/set.
      public boolean connected(int p, int q) {
        return find(p) == find(q);
      }

      // Return the size of the components/set 'p' belongs to
      public int componentSize(int p) {
        return sz[find(p)];
      }

      // Return the number of elements in this UnionFind/Disjoint set
      public int size() {
        return size;
      }

      // Returns the number of remaining components/sets
      public int components() {
        return numComponents;
      }

      // Unify the components/sets containing elements 'p' and 'q'
      public void unify(int p, int q) {

        int root1 = find(p);
        int root2 = find(q);

        // These elements are already in the same group!
        if (root1 == root2) return;

        // Merge smaller component/set into the larger one.
        if (sz[root1] < sz[root2]) {
          sz[root2] += sz[root1];
          id[root1] = root2;
        } else {
          sz[root1] += sz[root2];
          id[root2] = root1;
        }

        // Since the roots found are different we know that the
        // number of components/sets has decreased by one
        numComponents--;

      }

    }


    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
       BufferedReader br;
       StringTokenizer st;

       public MyScanner() {
          br = new BufferedReader(new InputStreamReader(System.in));
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

       String nextLine(){
           String str = "";
       try {
          str = br.readLine();
       } catch (IOException e) {
          e.printStackTrace();
       }
       return str;
       }

    }

    static public class FastScanner {

        static final int DEFAULT_BUFF = 10240, EOF = -1, INT_MIN = 48, INT_MAX = 57;
        static final byte NEG = 45;
        static final int[] ints = new int[58];

        static {
            int value = 0;
            for (int i = 48; i < 58; i++) {
                ints[i] = value++;
            }
        }

        InputStream stream;

        byte[] buff;
        int buffPtr;

        public FastScanner(InputStream stream) {
            this.stream = stream;
            this.buff = new byte[DEFAULT_BUFF];
            this.buffPtr = -1;
        }

        public int nextInt() throws IOException {
            int val = 0;
            int sign = readNonDigits();
            while (isDigit(buff[buffPtr]) && buff[buffPtr] != EOF) {
                val = (val << 3) + (val << 1) + ints[buff[buffPtr]];
                buffPtr++;
                if (buffPtr == buff.length) {
                    updateBuff();
                }
            }
            return val*sign;
        }

        private int readNonDigits() throws IOException {
            if (buffPtr == -1 || buffPtr == buff.length) {
                updateBuff();
            }
            if (buff[buffPtr] == EOF) {
                throw new IOException("End of stream reached");
            }
            int signByte = -1;
            while (!isDigit(buff[buffPtr])) {
                signByte = buff[buffPtr];
                buffPtr++;
                if (buffPtr >= buff.length) {
                    updateBuff();
                }
                if (buff[buffPtr] == EOF) {
                    throw new IOException("End of stream reached");
                }
            }
            if(signByte == NEG) return -1;
            return 1;
        }

        public void close() throws IOException {
            stream.close();
        }

        private boolean isDigit(int b) {
            return b >= INT_MIN && b <= INT_MAX;
        }

        private void updateBuff() throws IOException {
            buffPtr = 0;
            stream.read(buff);
        }
    }
}