import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Parser parser = new Parser();

    public static void main(String[] args) throws IOException {
        int T = parser.parseInt();

        for(int i = 0; i < T; i++){
            solve();
        }
    }

    static void solve() throws IOException{
        int n = parser.parseInt();
        long l = parser.parseLong();
        long r = parser.parseLong();

        int idx = 1;
        long curr = 0;
        while(curr + (n - idx) * 2 < l){
            if(idx == n){
                break;
            }

            curr += (n - idx) * 2;
            idx += 1;
        }
        List<Integer> cycle = new ArrayList<>();
        while(cycle.size() < r - curr + 1){
            if(idx == n){
                break;
            }

            for(int i = idx + 1; i <= n; i++){
                cycle.add(idx);
                cycle.add(i);
            }
            idx += 1;
        }
        cycle.add(1);

        for(long i = l; i <= r; i++){
            System.out.printf("%d ", cycle.get((int)(i - curr - 1)));
        }
        System.out.println();

    }

}

class Parser {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final Iterator<String> stringIterator = br.lines().iterator();
    private static final Deque<String> inputs = new ArrayDeque<>();

    void fill() throws IOException {
        if(inputs.isEmpty()){
            if(!stringIterator.hasNext()) throw new IOException();
            inputs.addAll(Arrays.asList(stringIterator.next().split(" ")));
        }
    }

    Integer parseInt() throws IOException {
        fill();
        if(!inputs.isEmpty()) {
            return Integer.parseInt(inputs.pollFirst());
        }
        throw new IOException();
    }

    Long parseLong() throws IOException {
        fill();
        if(!inputs.isEmpty()) {
            return Long.parseLong(inputs.pollFirst());
        }
        throw new IOException();
    }

    Double parseDouble() throws IOException {
        fill();
        if(!inputs.isEmpty()) {
            return Double.parseDouble(inputs.pollFirst());
        }
        throw new IOException();
    }

    String parseString() throws IOException {
        fill();
        return inputs.pollFirst();
    }

}

