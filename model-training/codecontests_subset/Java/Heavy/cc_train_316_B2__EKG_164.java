
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.math.BigInteger;
import java.util.*;

public class Main implements Runnable {

    StreamTokenizer ST;
    PrintWriter out;
    BufferedReader br;
    Scanner in;

    public static void main(String[] args) throws IOException {
        new Thread(new Main()).start();
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(System.out);
            in = new Scanner(System.in);
            br = new BufferedReader(new InputStreamReader(System.in));
            ST = new StreamTokenizer(br);
            solve();
            out.close();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private int readInt() throws IOException {
        ST.nextToken();
        return (int) ST.nval;
    }

    private double readDouble() throws IOException {
        ST.nextToken();
        return ST.nval;
    }

    private String readString() throws IOException {
        ST.nextToken();
        return ST.sval;
    }
    boolean[] used;
    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public void dfs(int v, ArrayList<Integer> comp) {
        used[v] = true;
        comp.add(v + 1);
        for (int i = 0; i < graph.get(v).size(); ++i) {
            int to = graph.get(v).get(i);
            dfs(to, comp);
        }
    }

    public void findComponents() {
        for (int i = 0; i < used.length; ++i) {
            used[i] = false;
        }
        for (int i = 0; i < used.length; ++i) {
            if (!used[i]) {
                ArrayList<Integer> comp = new ArrayList<Integer>();

                dfs(i, comp);
                // work with component
                ans.add(comp);
            }
        }
    }

    public void solve() throws IOException {
        int n = readInt();
        int x = readInt();
        int[] g = new int[n];
        used = new boolean[n];
        for (int i = 0; i < n; ++i) {
            g[i] = readInt();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            if (g[i] != 0) {
                tmp.add(g[i] - 1);
            }
            graph.add(tmp);
        }
        findComponents();
        ArrayList<ArrayList<Integer>> components = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < ans.size(); ++i) {
            boolean contains = false;
            ArrayList<Integer> getI = ans.get(i);
            for (int j = i + 1; j < ans.size(); ++j) {
                ArrayList<Integer> getJ = ans.get(j);
                for (int k = 0; k < getI.size(); ++k) {
                    if (getJ.contains(getI.get(k))) {
                        contains = true;
                        if (getI.size() > getJ.size()) {
                            components.add(getI);
                        }
                    }
                }

            }
            if (!contains) {
                components.add(getI);
            }
        }
//        for (int i = 0; i < components.size(); ++i) {
//            System.err.println(components.get(i));
//        }
        int pos = -1;
        int position = -1;
        for (int i = 0; i < components.size(); ++i) {
            if (components.get(i).contains(x)) {
                ArrayList<Integer> get = components.get(i);
                for (int j = 0; j < get.size(); ++j) {
                    if (get.get(j) == x) {
                        position = get.size() - j;
                    }
                }
                pos = i;
                break;
            }
        }
        TreeSet<Integer> answer = new TreeSet<Integer>();
        answer.add(position);
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < components.size(); ++i) {
            if (i != pos) {
                a.add(components.get(i).size());
            }
        }

        for (int i = 0; i < a.size(); ++i) {
            Iterator<Integer> it = answer.iterator();
            TreeSet<Integer> tmp = new TreeSet<Integer>();
            while (it.hasNext()) {
                tmp.add(it.next() + a.get(i));
            }
            answer.addAll(tmp);
        }

        Iterator<Integer> it = answer.iterator();
        while (it.hasNext()) {
            out.println(it.next());
        }

//        char[] s = in.nextLine().toCharArray();
//        BigInteger ret = new BigInteger("1");
//        Set<Character> chars = new HashSet<Character>();
//        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//        boolean[] digits = new boolean[10];
//        int[] ans = new int[11];
//        Arrays.fill(digits, true);
//        for (int i = 0; i < s.length; ++i) {
//            if (s[i] == '?') {
//                if (i == 0) {
//                    ans[9]++;
//                    //ret = ret.multiply(new BigInteger("9"));
//                } else {
//                    ans[10]++;
//                    //ret = ret.multiply(BigInteger.TEN);
//                }
//            } else if (Character.isLetter(s[i])) {
//                int cnt = 0;
//                for (int j = 0; j < digits.length; ++j) {
//                    if (digits[j]) {
//                        ++cnt;
//                    }
//                }
//                if (i == 0) {
//                    cnt = 9;
//                }
//                if (!digits[s[i] - 'A']) {
//                    cnt = 1;
//                }
//                digits[s[i] - 'A'] = false;
//                ans[cnt]++;
//                //ret = ret.multiply(new BigInteger(String.valueOf(cnt)));
//            }
//        }
//        for (int i = 0; i < ans.length - 1; ++i) {
//
//            if (ans[i] != 0) {
//                BigInteger tmp = new BigInteger(String.valueOf(i));
//                tmp = tmp.pow(ans[i]);
//                ret = ret.multiply(tmp);
//            }
//        }
//        out.print(ret.toString());
//        for (int i = 0; i < ans[10]; ++i) {
//            out.print("0");
//        }
//        out.println();
    }
}
