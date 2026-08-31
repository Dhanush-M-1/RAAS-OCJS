
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class EasyReadingBook {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String l = reader.readLine();
        String[] a = l.split(" ");
        int n = Integer.parseInt(a[0]);
        int k = Integer.parseInt(a[1]);

        PriorityQueue<Integer>[] queues=new PriorityQueue[3];
        for (int i = 0; i <3 ; i++) {
            queues[i]=new PriorityQueue<>();
        }

        for (int i = 0; i < n; i++) {
            l = reader.readLine();
            a = l.split(" ");
            int t = Integer.parseInt(a[0]);
            int A = Integer.parseInt(a[1]);
            int B = Integer.parseInt(a[2]);
            if(A==1&&B==1){
                queues[2].add(-t);
            }else if(A==1&&B==0){
                queues[1].add(t);
            }else if(A==0&&B==1){
                queues[0].add(t);
            }
        }
        while (!queues[0].isEmpty()&&!queues[1].isEmpty()){
            queues[2].add(-queues[0].peek()-queues[1].peek());
            queues[0].remove();
            queues[1].remove();
        }
        long ans=0;
        while (queues[2].size()>k)
            queues[2].remove();
        if (queues[2].size()<k)
            ans=-1;
        else {
            while (!queues[2].isEmpty()){
                ans+=Math.abs(queues[2].peek());
                queues[2].remove();
            }
        }
        System.out.println(ans);

    }
}
