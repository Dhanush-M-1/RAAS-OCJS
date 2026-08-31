import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class A {

    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(final String[] args) throws IOException {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);

        Set<String> participants = new HashSet<>();
        int bytes = 0;

        String command = in.nextLine();
        while (command != null) {
            if (command.charAt(0) == '+') {
                participants.add(command.substring(1));
            } else if (command.charAt(0) == '-') {
                participants.remove(command.substring(1));
            } else {
                String[] tokens = command.split(":");
                if (tokens.length == 2 && tokens[1].length() > 0) {
                    bytes += (participants.size() * tokens[1].length());
                }
            }
            command = in.nextLine();
        }
        out.println(bytes);
    }

}
