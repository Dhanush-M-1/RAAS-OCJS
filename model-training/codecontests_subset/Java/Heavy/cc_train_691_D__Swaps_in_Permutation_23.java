import java.io.*;
import java.lang.*;
import java.util.*;
 
public class D691 {
    static int[] dsu;
    static int[] size;
    public static void main(String[] args) throws IOException{
        StringBuffer ans = new StringBuffer();
        StringTokenizer st;
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        size = new int[n];
        dsu = new int[n];
        st = new StringTokenizer(f.readLine());
        int[] pos = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken()) - 1;
            dsu[i] = i;
            size[i] = 1;
            pos[arr[i]] = i;
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(f.readLine());
            int ft = Integer.parseInt(st.nextToken()) - 1;
            int sc = Integer.parseInt(st.nextToken()) - 1;
            union(ft, sc);
        }
        HashMap<Integer, PriorityQueue<Integer>> hash = new HashMap<>();
        int[] use = new int[n];
        for(int i = 0; i < n; i++){
            int a = find(i);
            use[i] = a;
            if(!hash.containsKey(a))
                hash.put(a, new PriorityQueue<>());
            hash.get(a).add(i);
        }
        //System.out.println(Arrays.toString(dsu));
        int[] op = new int[n];
        for(int i = n-1; i > -1; i--){
            op[hash.get(use[pos[i]]).poll()] = i+1;
        }
        for(int i : op)
            ans.append(i).append(" ");
        System.out.println(ans);
    }
    public static int find(int node){
        if(dsu[node] == node) return node;
        int r = find(dsu[node]);
        dsu[node] = r;
        return r;
    }
    public static void union(int ft, int sc){
        int a = find(ft);
        int b = find(sc);
        if(a != b) {
            if (size[a] < size[b]) {
                int temp = a;
                a = b;
                b = temp;
            }
            dsu[b] = a;
            size[a]+=size[b];
        }
    }
}
