import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task915A {

    public static void main(String... args) throws NumberFormatException,
            IOException {
        Solution.main(System.in, System.out);
    }

    private final static String YES = "Yes";
    private final static String NO = "No";

    static class Scanner {

        private final BufferedReader br;
        private String[] cache;
        private int cacheIndex;

        Scanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
            cache = new String[0];
            cacheIndex = 0;
        }

        int nextInt() throws IOException {
            if (cacheIndex >= cache.length) {
                cache = br.readLine().split(" ");
                cacheIndex = 0;
            }
            return Integer.parseInt(cache[cacheIndex++]);
        }

        long nextLong() throws IOException {
            if (cacheIndex >= cache.length) {
                cache = br.readLine().split(" ");
                cacheIndex = 0;
            }
            return Long.parseLong(cache[cacheIndex++]);
        }

        String next() throws IOException {
            if (cacheIndex >= cache.length) {
                cache = br.readLine().split(" ");
                cacheIndex = 0;
            }
            return cache[cacheIndex++];
        }

        void close() throws IOException {
            br.close();
        }

    }

    static class Solution {

        public static void main(InputStream is, OutputStream os)
                throws NumberFormatException, IOException {
            PrintWriter pw = new PrintWriter(os);
            Scanner sc = new Scanner(is);

            int n = sc.nextInt();
            int k = sc.nextInt();

            List<Integer> a = new ArrayList<>(n);

            for(int i = 0 ; i < n ; i++){
                a.add(sc.nextInt());
            }

            int retVal = Integer.MIN_VALUE;

            for(int ai : a){
                if(k % ai == 0){
                    retVal = Math.max(retVal, ai);
                }
            }

            pw.println(k / retVal);

            pw.flush();
            sc.close();
        }
    }

}