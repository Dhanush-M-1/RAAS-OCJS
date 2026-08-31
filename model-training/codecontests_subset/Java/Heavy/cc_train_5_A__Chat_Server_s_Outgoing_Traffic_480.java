
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PSUT {

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int numberOfDudes = 0;
        int outgoingTraffic = 0;
        while (true) {
            String command = in.nextLine();
            if (command == null || command.equals("")){
                System.out.println(outgoingTraffic);
                return;
            }
            if (command.charAt(0) == '+') {
                numberOfDudes++;
            } else if (command.charAt(0) == '-') {
                numberOfDudes--;
            } else {
                try {
                String message = command.split(":")[1];
                outgoingTraffic += message.length() * numberOfDudes;
                } catch(ArrayIndexOutOfBoundsException e) {
                    outgoingTraffic += 0;
                }
            }
        }
        //System.out.println(outgoingTraffic);
    }

    static class FastReader {

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
}
