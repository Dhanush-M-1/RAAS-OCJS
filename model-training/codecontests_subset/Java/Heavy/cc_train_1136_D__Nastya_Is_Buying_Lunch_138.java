

/*
TASK: template
LANG: JAVA
 */
import java.io.*;
import java.lang.*;
import java.util.*;

public class D1136 {
    public static void main(String[] args) throws IOException{
        StringBuffer ans = new StringBuffer();
        StringTokenizer st;
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        TreeSet<Integer>[] hash = new TreeSet[n];
        TreeSet<Integer> rem = new TreeSet<>();
        int[] where = new int[n];
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++){
            where[Integer.parseInt(st.nextToken())-1] = i;
            hash[i] = new TreeSet<>();
            rem.add(i);
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(f.readLine());
            int ft = Integer.parseInt(st.nextToken())-1;
            int sc = Integer.parseInt(st.nextToken())-1;
            hash[where[sc]].add(where[ft]);
        }

        f.close();

        for(int i = 0; i < n-1; i++){
            rem.add(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n-1);
        while (!queue.isEmpty()){
            int curr = queue.poll();
            ArrayList<Integer> arrl = new ArrayList<>();
            for(int i : rem){
                if(i > curr || rem.isEmpty()) break;
                if(!hash[curr].contains(i)){
                    arrl.add(i);
                    queue.add(i);
                }
            }
            for(int i : arrl){
                rem.remove(i);
            }
        }

        System.out.println(rem.size());

    }
}
