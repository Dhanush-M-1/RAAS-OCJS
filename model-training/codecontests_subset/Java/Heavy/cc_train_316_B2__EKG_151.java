import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ABBYY3B {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt(), x = in.nextInt()-1;
        int[] l = new int[n+1];
        Arrays.fill(l, -1);
        LinkedList[] queues = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            queues[i] = new LinkedList();
            queues[i].addLast(i);
            int ai = in.nextInt();
            if (ai != 0) {
                l[ai-1] = i;
            }
        }
        
        int tlen = -1, tidx = -1;
        for (int i = 0; i < n; i++) {
            int c = l[i];
            while (c != -1) {
                queues[i].addAll(queues[c]);
                queues[c].clear();
                c = l[c];
            }
        }
        
        Arrays.fill(l, 0);
        l[0] = 1;
        
        List<Integer> sizes = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (queues[i].size() > 0) {
                if (tidx == -1 && queues[i].contains(x)) {
                    tlen = queues[i].size();
                    tidx = queues[i].indexOf(x) + 1;
                } else {
                    sizes.add(queues[i].size());
                }
            }
        }
        
        for (int j = 0; j < sizes.size(); j++) {
            for (int i = n; i >= 0; i--) {
                if (l[i] > 0) {
                    l[i+sizes.get(j)] = 1;
                }
            }
        }
        
        for (int i = 0; i <= n; i++) {
            if (l[i] > 0) {
                out.println(i + tidx);
            }
        }

        out.flush();
    }
}
