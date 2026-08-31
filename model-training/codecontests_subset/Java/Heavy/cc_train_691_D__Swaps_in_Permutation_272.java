import java.io.*;
import java.util.*;

public class Main {

    static int[] p;
    public static void main(String[] args) {
        InputReader in = new InputReader();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] nums = new int[n + 1];
        p = new int[n + 1];

        for(int i = 1; i <= n; ++i) {
            int x = in.nextInt();
            nums[i] = x;
            p[i] = i;
        }

        for(int i = 0; i < m; ++i) {
            int a = in.nextInt();
            int b = in.nextInt();
            merge(a,b);
        }

        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for(int i = 1; i <= n; ++i) {
            if(map.containsKey(findParent(p[i]))) {
                map.get(findParent(p[i])).add(nums[i]);
            } else {
                PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                pq.add(nums[i]);
                map.put(findParent(p[i]), pq);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; ++i) {
            sb.append(map.get(findParent(p[i])).poll());
            if(i != n) sb.append(" ");
        }

        System.out.println(sb.toString());

    }

    public static int findParent(int i) {
        return p[i] == i ? i : (p[i] = findParent(p[i]));
    }

    public static void merge(int x, int y) {
        int a = findParent(x);
        int b = findParent(y);
        p[Math.max(a,b)] = Math.min(a,b);
    }
}

class InputReader {
    BufferedReader reader;
    StringTokenizer tokenizer;

    public InputReader() { reader = new BufferedReader(new InputStreamReader(System.in)); }

    String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tokenizer.nextToken();
    }

    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() { return Double.parseDouble(next()); }

    String nextLine() {
        String str = "";
        try {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }
}

 	 	  	 	  	   	 	   		  		  	