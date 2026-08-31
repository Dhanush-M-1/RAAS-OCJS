import java.io.*;
import java.util.*;
public class D {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        int[] people = new int[n];

        LinkedList<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            people[i] = Integer.valueOf(st.nextToken()) - 1;
        }
        int nat = people[n - 1];

        boolean[] special = new boolean[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.valueOf(st.nextToken()) - 1;
            int v = Integer.valueOf(st.nextToken()) - 1;
            if(v == nat){
                special[u] = true;
            }
            graph[v].add(u);
        }

        int[] counts = new int[n];
        int count = 0;
        int total = 0;
        for (int i = n-2; i >= 0; i--) {
            if(special[people[i]]) {
                if(counts[people[i]] == count) {
                    total++;
                    continue;
                }
            }
            for (int j : graph[people[i]]) {
                counts[j] ++;
            }
            count ++;
        }
        System.out.println(total);
    }
}
