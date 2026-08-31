import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] params = input.readLine().split(" ");
        final int N = Integer.parseInt(params[0]);
        final int M = Integer.parseInt(params[1]);
        
        String[] wStr = input.readLine().split(" ");
        int[] weight = new int[N];
        for (int i = 0 ; i < N ; i++) {
            weight[i] = Integer.parseInt(wStr[i]);
        }
        
        String[] rStr = input.readLine().split(" ");
        int[] read = new int[M];
        for (int i = 0 ; i < M ; i++) {
            read[i] = Integer.parseInt(rStr[i]);
        }
        
        List<Integer> stack = new ArrayList<>();
        for (int x : read) {
            if (!stack.contains(x)) {
                stack.add(x);
            }
        }
        
        int total = 0;
        for (int i = 0 ; i < M ; i++) {
            for (Iterator<Integer> it = stack.iterator() ; it.hasNext() ; ) {
                int x = it.next();
                if (x == read[i]) {
                    it.remove();
                    break;
                } else {
                    total += weight[x - 1];
                }
            }
            stack.add(0 , read[i]);
        }
        System.out.println(total);
    }
    
}
