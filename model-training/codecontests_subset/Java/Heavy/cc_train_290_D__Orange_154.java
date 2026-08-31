import java.io.*;
import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class Main implements Runnable {
    public static void main(String[] args) throws IOException {
        new Thread(new Main()).start();
    }

    private void solve() throws IOException {
        String s = nextToken().toLowerCase();
        int n = nextInt();

        String answer = "";
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (c < n + 'a') {
                answer += Character.toUpperCase(c);
            } else
                answer += Character.toLowerCase(c);
        }

        writer.println(answer);
    }

    private class Pair<E, V> implements Comparable<Pair<E, V>> {
        private E first;
        private V second;

        public Pair(E first, V second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object obj) {
            Pair other = (Pair)obj;
            return first == other.first && second == other.second;
        }

        @Override
        public int compareTo(Pair<E, V> evPair) {
            if (first.equals(evPair.first))
                return ((Comparable) second).compareTo(evPair.second);

            return ((Comparable) first).compareTo(evPair.first);
        }

                @Override
                public int hashCode() {
                    return (first.hashCode() + 41) * 41 + second.hashCode();
                }
            }

        public void run() {
            try {
                if(in.equals(""))
                    reader = new BufferedReader(new InputStreamReader(System.in));
                else
                    reader = new BufferedReader(new FileReader(in));

                if(out.equals(""))
                    writer = new PrintWriter(System.out);
                else
                    writer = new PrintWriter(new FileWriter(out));

                solve();
            } catch(IOException e) {
                e.printStackTrace();
            } finally {
                writer.close();

                try {
                reader.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private String nextToken() throws IOException {
        while(st == null || !st.hasMoreTokens())
            st = new StringTokenizer(reader.readLine());

        return st.nextToken();
    }

    private String in = "", out = "";
    private BufferedReader reader;
    private PrintWriter writer;
    private StringTokenizer st;
}