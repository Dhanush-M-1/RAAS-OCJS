import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int x1 = Reader.nextInt();
        int y1 = Reader.nextInt();
        int x2 = Reader.nextInt();
        int y2 = Reader.nextInt();
        int m = Reader.nextInt();
        HashSet<Pair<Integer, Integer>> valid = new HashSet<>();
        int r, a, b;
        for (int i = 0; i < m; i++) {
            r = Reader.nextInt();
            a = Reader.nextInt();
            b = Reader.nextInt();
            for (int j = a; j <= b; j++) {
                valid.add(new Pair<>(r, j));
            }
        }
        Queue<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        queue.add(new Pair<>(x1, y1));
        HashMap<Pair<Integer, Integer>, Integer> dist = new HashMap<>();
        dist.put(new Pair<>(x1, y1), 0);
        int[] dx = {1, 0, -1, 0, -1, 1, -1, 1};
        int[] dy = {0, 1, 0, -1, 1, -1, -1, 1};
        Pair<Integer, Integer> last = new Pair<>(x2, y2);
        boolean found = false;
        int MAX = 1000000000;
        while(!queue.isEmpty()){
            Pair<Integer, Integer> p = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                Pair<Integer, Integer> curr = new Pair<>(p.getKey() + dx[i], p.getValue() + dy[i]);
                if(p.getKey() >= 1 && p.getKey() <= MAX && p.getValue() >= 1 && p.getValue() <= MAX
                        && valid.contains(curr)){
                    if(dist.containsKey(curr))
                        continue;
                    dist.put(curr, dist.get(p) + 1);
                    if (curr.equals(last)){
                        found = true;
                        break;
                    }
                    queue.add(curr);
                }
            }
        }
        if (found)
            System.out.println(dist.get(last));
        else
            System.out.println(-1);
    }
}

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /**
     * call this method to initialize reader for InputStream
     */
    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }

    /**
     * get next word
     */
    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}

