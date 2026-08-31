
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class ConnectedComponent {
    private int n;
    private TreeSet<Integer>[] adj;
    private TreeSet<Integer> unseen = new TreeSet<>();
    private int cnt;

    public static void main(String[] args){
        ConnectedComponent cc = new ConnectedComponent();
        cc.readInput(System.in);
        List<Integer> result = cc.solve();
        System.out.println(result.size());
        System.out.println(result.stream().map(x -> String.valueOf(x)).collect(Collectors.joining(" ")));
    }

    public ConnectedComponent() {
    }

    public void readInput(InputStream is) {
        Scanner s = new Scanner(is);
        n = s.nextInt();
        adj = new TreeSet[n];
        for (int i = 0; i <n; i++) {
            adj[i] = new TreeSet<>();
            unseen.add(i);
        }
        int m = s.nextInt();
        for (int i = 0; i < m; i++) {
            int a = s.nextInt()-1;
            int b = s.nextInt()-1;
            adj[a].add(b);
            adj[b].add(a);
        }
    }

    public void dfs(int i) {
        unseen.remove(i);
        cnt++;
        boolean go = true;
        while(go) {
            go = false;
            for (int j : unseen) {
                if (adj[i].contains(j)) continue;
                dfs(j);
                go = true;
                break;
            }
        }
    }

    public List<Integer> solve() {
        List<Integer> components = new ArrayList<>();

        while (!unseen.isEmpty()) {
            int next = unseen.first();
            cnt = 0;
            dfs(next);
            components.add(cnt);
        }
        Collections.sort(components);
        return components;
    }

}
