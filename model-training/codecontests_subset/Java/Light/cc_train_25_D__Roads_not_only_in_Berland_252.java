import java.util.*;
import java.io.*;
import java.awt.Point;
import static java.lang.Math.*;

public class CF25D {
    static int[] uf;
    static void mix(int a, int b) {
        uf[find(a)] = find(b);
    }
    static int find(int x) {
        if(uf[x] == x) return uf[x];
        return uf[x] = find(uf[x]);
    }
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        uf = new int[n];
        for(int i=0; i<n; i++) uf[i] = i;

        List<int[]> A = new ArrayList<int[]>();
        for(int i=0; i<n-1; i++) {
            int s = in.nextInt()-1;
            int t = in.nextInt()-1;
            if(find(s) == find(t)) {
                A.add(new int[]{s,t});
            } else {
                mix(s,t);
            }
        }
        TreeSet<Integer> X = new TreeSet<Integer>();
        for(int i=0; i<n; i++) X.add(find(i));

        System.out.println(X.size()-1);
        int ix = 0;
        while(X.size() > 1) {
            int u = X.pollFirst();
            int v = X.pollFirst();
            System.out.printf("%d %d %d %d\n", A.get(ix)[0]+1, A.get(ix)[1]+1, u+1, v+1);
            mix(u,v);
            ix++;
            X.add(u);    
        }
    }
}
