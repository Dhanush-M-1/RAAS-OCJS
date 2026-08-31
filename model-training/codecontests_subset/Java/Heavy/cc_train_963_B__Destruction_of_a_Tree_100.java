

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
 
public class P963B {
	private static Scanner in;

    private static int n;
    private static HashMap<Integer, ArrayList<Integer>> g;
    private static int[] size;

    private static Stack<Integer> children;
    private static StringBuilder sb;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		n = in.nextInt();

        g = new HashMap<>();
        for(int i=0; i<n; i++) {
            g.put(i, new ArrayList<Integer>());
        }
        
        for(int i=0; i<n; i++) {
        	int p = in.nextInt();
        	if (p!=0) {
        		g.get(p-1).add(i);
        		g.get(i).add(p-1);
        	}
        }

        size = new int[n];

        children = new Stack<>();

        sb = new StringBuilder();

        dfs(0, -1);

        if (!children.isEmpty()) {
            System.out.println("NO");
        } else{
            System.out.println("YES");
            System.out.println(sb.toString().trim());
        }

	}

    public static boolean dfs(int u, int p) {

        size[u] = 1;

        int degree = (p==-1?0:1);

        for(int v: g.get(u)) {
            if (v==p) continue;
            
            boolean deleted = dfs(v, u);

            if (!deleted) {
                degree++;
                size[u] += size[v];
            }
        }

        if (degree%2==0) {
            sb.append((u+1)+"\n");
            for(int j=0; j<size[u]-1; j++) {
                sb.append((children.pop()+1)+"\n");
            }
        } else {
            children.push(u);
        }


        return degree%2==0;
    }

    
 
}