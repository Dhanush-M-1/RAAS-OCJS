import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<Integer>[] adj = new HashSet[n+1];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) set.add(i);

        for (int i = 0; i <= n; i++) adj[i] = new HashSet<>();
        int[] a = new int[n];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
        }
        int res = 0;
        for (int i = n-1; i >= 0; i--) {
           // System.out.println(set.toString());
            if (set.size() == 0) break;
           // if (!adj[a[i]].contains(a[n-1]) ) {
            HashSet<Integer> remove = new HashSet<>();
            if (adj[a[i]].contains(a[n-1]) && set.contains(a[i])) {
                res++;
                continue;
            }
            for (int j : set) {
                if (!adj[j].contains(a[i])) {
                  //  System.out.println("Remove " + j);
                    remove.add(j);
                }
           // }
            }
            set.removeAll(remove);
           // System.out.println(a[i] +  " " + set.toString());
        }
        out.println(res);
        out.close();
    }

}
/*
5 4
3 1 5 4 2
5 2
5 4
1 4
1 2


 */