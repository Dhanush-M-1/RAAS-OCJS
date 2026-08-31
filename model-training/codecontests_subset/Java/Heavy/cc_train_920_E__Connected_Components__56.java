import java.util.*;

public final class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int m = sc.nextInt();

        ArrayList[] g = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> s = new ArrayList<>();
            s.add(-1);
            s.add(n);
            g[i] = s;
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt()-1, y = sc.nextInt()-1;
            ArrayList<Integer> s1 = g[x];
            s1.add(y);
            g[x] = s1;

            s1 = g[y];
            s1.add(x);
            g[y] = s1;
        }

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> l = g[i];
            Collections.sort(l);
            g[i] = l;
        }

        List<Integer> res = dfs(g, n);
        System.out.println(res.size());
        StringBuilder sb = new StringBuilder();
        for (int i : res) {
            sb.append(" ").append(i);
        }
        System.out.println(sb.substring(1));
    }
    public static List<Integer> dfs (ArrayList[] g, int n) {
        List<Integer> res = new ArrayList<>();
        TreeSet<Integer> vs = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            vs.add(i);
        }
        for (int i = 0; i < n; i++) {
            if (vs.contains(i)) {
                res.add(dfsrecur(g, vs, n, i));
            }
        }
        Collections.sort(res);
        return res;
    }

    private static int dfsrecur(ArrayList[] g, TreeSet<Integer> vs, int n, int i) {
        vs.remove(i);
        int count = 1;
        ArrayList<Integer> l = g[i];

        for (int p = 0; p < l.size()-1; p++) {

            int st = l.get(p);
            int end = l.get(p+1);

            while(true) {
                Integer j = vs.higher(st);
                if (j == null || j >= end) {
                    break;
                }
                count += dfsrecur(g, vs, n, j);
            }
        }
        return count;
    }
}