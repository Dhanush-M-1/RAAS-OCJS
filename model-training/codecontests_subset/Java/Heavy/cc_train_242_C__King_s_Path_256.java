import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static PrintWriter out = new PrintWriter(System.out,true);
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static Map<Integer,HashSet<Integer>> free = new HashMap<>();
    static Map<Integer,HashMap<Integer,Integer>> cost = new HashMap<>();

    public static void main(String[] args) throws Exception {
        int x0 = nextInt(), y0 = nextInt(), x1 = nextInt(), y1 = nextInt();
        int n = nextInt();
        int[][] m = new int[n][3];
        for(int i = 0;i < n;i++) {
            m[i][0] = nextInt();
            m[i][1] = nextInt();
            m[i][2] = nextInt();
        }
        for(int i = 0;i < n;i++) {
            for(int j = m[i][1];j <= m[i][2];j++) {
                if(!free.containsKey(m[i][0])) free.put(m[i][0],new HashSet<Integer>());
                free.get(m[i][0]).add(j);
            }
        }
        cost.put(x0,new HashMap<Integer, Integer>());
        cost.get(x0).put(y0,0);
        int[][] d = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x0,y0});
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            int c = cost.get(x).get(y);
            for(int i = 0;i < d.length;i++) {
                if(free.containsKey(x+d[i][0]) && free.get(x+d[i][0]).contains(y+d[i][1])) {
                    if(!cost.containsKey(x+d[i][0]) || !cost.get(x+d[i][0]).containsKey(y+d[i][1])) {
                        if(!cost.containsKey(x+d[i][0])) cost.put(x+d[i][0],new HashMap<Integer, Integer>());
                        cost.get(x+d[i][0]).put(y+d[i][1],c+1);
                        q.add(new int[]{x+d[i][0],y+d[i][1]});
                    }
                }
            }
        }
        if(!cost.containsKey(x1) || !cost.get(x1).containsKey(y1)) out.println(-1);
        else out.println(cost.get(x1).get(y1));
    }

    public static int nextInt() throws Exception {
        if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(in.readLine());
        return Integer.parseInt(st.nextToken());
    }
}