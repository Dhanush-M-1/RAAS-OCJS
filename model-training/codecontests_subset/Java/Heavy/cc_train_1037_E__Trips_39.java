import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class E2 {

    public static void main(String[] args) throws IOException {
        E2 runner = new E2();
        runner.run();
        runner.close();
    }

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    void close() throws IOException {
        input.close();
        output.flush();
        output.close();
    }

    void read() {
        try {
            st = new StringTokenizer(input.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    int getInt() {
        return Integer.parseInt(st.nextToken());
    }

    void run()throws IOException {
        read();
        int n = getInt();
        int m = getInt();
        int k = getInt();

        int[] friends = new int[n+1];
        int[] days1 = new int[m];
        int[] days2 = new int[m];
        Stack<Integer>[] links = new Stack[n+1];
        IntStream.rangeClosed(1, n).forEach(i -> links[i] = new Stack<>());

        IntStream.range(0, m).forEach(i -> {
            read();
            int s = getInt();
            int f = getInt();
            days1[i] = s;
            days2[i] = f;
            links[s].add(f);
            links[f].add(s);
            friends[s]++;
            friends[f]++;
        });

        int count = n;
        boolean[] going = new boolean[n+1];
        IntStream.rangeClosed(1, n).forEach(i -> going[i] = true);
        Set<Integer> toRemove = new LinkedHashSet<>();

        IntStream.rangeClosed(1, n).forEach(i -> {
            if (friends[i] < k)
                toRemove.add(i);
        });

        int[] res = new int[m];

        for (int d = m-1; d >= 0; d--) {
            while (!toRemove.isEmpty()) {
                int r = toRemove.iterator().next();
                toRemove.remove(r);
                count -= 1;
                going[r] = false;
                links[r].forEach(o -> {
                    if (going[o]) {
                        friends[o]--;
                        if (friends[o] < k)
                            toRemove.add(o);
                    }
                });
            }
            res[d] = count;

            int s = days1[d];
            int f = days2[d];
            links[s].pop();
            links[f].pop();
            if (going[s] & going[f]) {
                friends[s]--;
                friends[f]--;
                if (friends[s] < k)
                    toRemove.add(s);
                if (friends[f] < k)
                    toRemove.add(f);
            }
        }

        for (int r : res) {
            output.write(String.valueOf(r));
            output.newLine();
        }
    }
}
