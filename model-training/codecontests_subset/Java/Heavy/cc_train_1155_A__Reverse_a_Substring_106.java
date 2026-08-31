import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class l {
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////                                                                                                               /////////
////////                                                                                                               /////////
////////   HHHH        HHHH  EEEEEEEEEEEEE   MMMM          MMMM         OOOOOO             SSSSSSS      EEEEEEEEEEEEE  /////////
////////   HHHH        HHHH  EEEEEEEEEEEEE   MMMMMM      MMMMMM      OOO      OOO        SSSS   SSS     EEEEEEEEEEEEE  /////////
////////   HHHH        HHHH  EEEEE           MMMM MMM  MMM MMMM    OOO          OOO    SSSS       SSS   EEEEE          /////////
////////   HHHH        HHHH  EEEEE           MMMM  MMMMMM  MMMM   OOO            OOO   SSSS             EEEEE          /////////
////////   HHHH        HHHH  EEEEE           MMMM          MMMM  OOO              OOO   SSSSSSS         EEEEE          /////////
////////   HHHHHHHHHHHHHHHH  EEEEEEEEEEE     MMMM          MMMM  OOO              OOO      SSSSSS       EEEEEEEEEEE    /////////
////////   HHHHHHHHHHHHHHHH  EEEEEEEEEEE     MMMM          MMMM  OOO              OOO         SSSSSSS   EEEEEEEEEEE    /////////
////////   HHHH        HHHH  EEEEE           MMMM          MMMM   OOO            OOO              SSSS  EEEEE          /////////
////////   HHHH        HHHH  EEEEE           MMMM          MMMM    OOO          OOO     SSS       SSSS  EEEEE          /////////
////////   HHHH        HHHH  EEEEEEEEEEEEE   MMMM          MMMM      OOO      OOO        SSS    SSSS    EEEEEEEEEEEEE  /////////
////////   HHHH        HHHH  EEEEEEEEEEEEE   MMMM          MMMM         OOOOOO             SSSSSSS      EEEEEEEEEEEEE  /////////
////////                                                                                                               /////////
////////                                                                                                               /////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static int mod = (int) (1e9 + 7);
    static int n;
    static StringBuilder sol;

    static class pair implements Comparable<pair> {
        int val, cost;

        public pair(int x, int y) {
            val = x;
            cost = y;
        }

        public int compareTo(pair o) {
            if (o.val == val) return cost - o.cost;
            return val - o.val;
        }

        public String toString() {
            return val + " " + cost;
        }
    }

    static class tri implements Comparable<tri> {
        int lef, righ, idx;

        tri(int a, int b, int c) {
            lef = a;
            righ = b;
            idx = c;
        }

        public int compareTo(tri o) {
            if (lef == o.lef) return righ - o.righ;
            return lef - o.lef;
        }

        public String toString() {
            return lef + " " + righ + " " + idx;
        }
    }
    static ArrayList<Integer>[]adj;
    static boolean[]vis;
    static ArrayList<Integer>ans;
    static void dfs(int u){
        vis[u]=true;
        ans.add(u+1);
        for (int v:adj[u]){
            if (!vis[v])dfs(v);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //FileWriter f = new FileWriter("C:\\Users\\Ibrahim\\out.txt");
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int[]is= new int[26];
        String s = sc.nextLine();
        for (int i =0;i<n;i++){
            int id = s.charAt(i)-'a';
            is[id]=i+1;
            for (int j=id+1;j<26;j++){
                if (is[j]!=0){
                    pw.println("YES");
                    pw.println(is[j]+" "+(i+1));
                    pw.flush();
                    return;
                }
            }
        }
        pw.println("NO");
        pw.flush();
    }

    static final int R = 26;                //Alphabet (lowercase etters in below implementation)

    static class Node {
        Node[] next = new Node[R];
        int val = -1;
        int count=0;
    }

    static Node root ;
    static int[]mm;
    static void put(char[] s, int idx)        // O(n) where n = |s|. Can be implemented recursively
    {
        Node cur = root;
        int i =1;
        for (char c : s) {
            Node nxt = cur.next[c - 'a'];
            if (nxt == null)
                nxt = cur.next[c - 'a'] = new Node();
            cur = nxt;
            cur.count++;
            mm[i]=Math.max(mm[i],cur.count);
            i++;
        }
        cur.val = idx;
    }

    static int search(char[] s) {
        Node cur = root;
        for (char c : s) {
            Node nxt = cur.next[c - 'a'];
            if (nxt == null)
                return -1;
            cur = nxt;
        }
        return cur.val;
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
}