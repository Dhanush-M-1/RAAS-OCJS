import java.math.*;
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args ) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        in = br.readLine().split(" ");
        int[] arr = new int[n];
        for( int i = 0; i< n; i++)
            arr[i] = Integer.parseInt(in[i]);

        ArrayList[] g = new ArrayList[n];
        for(int i = 0; i < n; i++)
            g[i] = new ArrayList<>();
        for( int i = 0; i < m; i++){
            in = br.readLine().split(" ");
            int a = Integer.parseInt(in[0]);
            int b = Integer.parseInt(in[1]);
            a--;
            b--;
            g[a].add(b);
            g[b].add(a);
        }
        boolean[] seen = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Node> sort = new ArrayList<>();
        for( int i = 0; i < n; i++){
                if(seen[i])continue;
                q.add(i);
                list.clear();
                sort.clear();
                
                while(!q.isEmpty()){
                    int num = q.remove();
                    if(seen[num])continue;
                    seen[num] = true;
                    list.add(num);
                    for( int j  = 0; j < g[num].size(); j++){
                        int to = (Integer)g[num].get(j);
                        if(seen[to])continue;
                        q.add(to);
                    }
                }
                for( int j = 0; j < list.size(); j++){
                    sort.add(new Node(list.get(j), arr[list.get(j)]));
                }
                Collections.sort(sort, Collections.reverseOrder());
                Collections.sort(list);
                StringBuilder out = new StringBuilder();
                for( int j = 0; j < sort.size(); j++){
                    Node node = sort.get(j);
                    arr[list.get(j)] = node.val;
                }
        }
        StringBuilder out = new StringBuilder();
        for(int i = 0; i < n; i++){
            out.append(arr[i]).append(' ');
        }
        out.setLength(out.length() -1);
        System.out.println(out.toString());

    }

}
class Node implements Comparable<Node>{
    int index;
    int val;
    public Node( int i, int v){
        index = i;
        val = v;
    }
    public int compareTo(Node that){
        return this.val - that.val;
    }
}
