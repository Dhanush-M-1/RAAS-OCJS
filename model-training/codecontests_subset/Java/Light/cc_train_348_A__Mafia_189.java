import java.io.*;
import java.util.PriorityQueue;

public class CF_349C {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split("\\s+");
        PriorityQueue<Integer> a = new PriorityQueue<>();

        int max = 0;
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(line[i]); 
            a.add(temp);
            max = temp > max ? temp : max;
        }
        long diff = 0;
        
        while (a.peek() > diff && a.peek() < max) {
            int cur = a.poll();
            diff += max - cur;
        }
        
        if (a.peek() == max) {
            long v = max - diff;
            diff += n * (v / (n - 1));
            v = v % (n - 1);
            if (v != 0)
                diff += v + 1;
        }
        else
            diff += (max - diff);
        System.out.println(diff);
    }
}
