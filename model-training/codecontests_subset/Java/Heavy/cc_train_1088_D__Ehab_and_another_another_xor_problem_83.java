import java.io.*;
import java.util.StringTokenizer;

public class Main {
    FastScanner in;
    PrintWriter out;

    public static void main(String[] args) {
        try {
            (new Main()).run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int maskToInt(int[] mask) {
        int res = 0;
        for (int bit : mask) {
            res *= 2;
            res += bit;
        }
        return res;
    }

    private void run() throws IOException {
        in = new FastScanner(System.in);
        out = new PrintWriter(System.out);
        int[] aMask = new int[30];
        int[] bMask = new int[30];
        out.println("? 0 0");
        out.flush();
        int lastAns = in.nextInt();
        for (int j = 0; j < 30; j++) {
            aMask[j] = 1;
            bMask[j] = 1;
            out.println("? " + maskToInt(aMask) + " " + maskToInt(bMask));
            out.flush();
            int currentAns = in.nextInt();
            if (currentAns == lastAns) {
                if (lastAns == 1) {
                    aMask[j] = 0;
                    out.println("? " + maskToInt(aMask) + " " + maskToInt(bMask));
                    out.flush();
                    int temp = in.nextInt();
                    if (temp == 1) {
                        aMask[j] = 1;
                    } else {
                        bMask[j] = 0;
                    }
                } else {
                    bMask[j] = 0;
                    out.println("? " + maskToInt(aMask) + " " + maskToInt(bMask));
                    out.flush();
                    int temp = in.nextInt();
                    if (temp == -1) {
                        bMask[j] = 1;
                    } else {
                        aMask[j] = 0;
                    }
                }
            } else {
                if (currentAns == 1) {
                    aMask[j] = 0;
                }else{
                    bMask[j] = 0;
                }
                out.println("? "+maskToInt(aMask)+" "+maskToInt(bMask));
                out.flush();
                lastAns = in.nextInt();
            }
        }
        out.println("! " + maskToInt(aMask) + " " + maskToInt(bMask));
        out.close();
    }

    private class FastScanner {
        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;

        FastScanner(InputStream inputStream) {
            this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        FastScanner(File file) throws IOException {
            this.bufferedReader = new BufferedReader(new FileReader(file));
        }

        public String nextLine() throws IOException {
            return bufferedReader.readLine();
        }

        public String next() throws IOException {
            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                String line = bufferedReader.readLine();
                if (line == null) return null;
                stringTokenizer = new StringTokenizer(line);
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(this.next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(this.next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(this.next());
        }

    }
}