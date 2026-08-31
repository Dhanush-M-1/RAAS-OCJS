import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            String[] line;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            line = in.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            int[] p = new int[n];
            line = in.readLine().split(" ");
            for(int i=0;i<n;i++){
                p[i] = Integer.parseInt(line[i]);
            }
            Map<Integer, Set<Integer>> map = new HashMap<>();
            Set<Integer> cur;
            int key;
            int value;
            for(int i=0;i<m;i++){
                line = in.readLine().split(" ");
                key = Integer.parseInt(line[0]);
                value = Integer.parseInt(line[1]);
                cur = map.get(key);
                if (cur!=null){
                    cur.add(value);
                }
                else{
                    map.put(key, new HashSet<>(Collections.singleton(value)));
                }
            }
            if (n==1){
                System.out.println(0);
                return;
            }
            int result = 0;
            Set<Integer> currentQueue = new HashSet<>(Collections.singleton(p[n-1]));
            for (int i=n-2; i>=0;i--){
                if (map.containsKey(p[i]) && map.get(p[i]).containsAll(currentQueue)){
                    result++;
                }
                else{
                    currentQueue.add(p[i]);
                }
            }
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}