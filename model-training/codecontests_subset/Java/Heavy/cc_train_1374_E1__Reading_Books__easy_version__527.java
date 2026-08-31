/**
 * ******* Created  on 28/6/20 7:53 PM*******
 */

import java.io.*;
import java.util.*;

public class E1374 implements Runnable {

    private static final int MAX = (int) (1E5 + 5);
    private static final int MOD = (int) (1E9 + 7);
    private static final long Inf = (long) (1E14 + 10);
    private static final double eps = (double) (1E-9);

    private void solve() throws IOException {
        int t = 1;

        while (t-- > 0) {
            int n = reader.nextInt();
            int k = reader.nextInt();
            List<Integer> al  = new ArrayList<>();
            List<Integer> bob  = new ArrayList<>();
            List<Integer> both  = new ArrayList<>();
            for(int i=0;i<n;i++){
                int a =  reader.nextInt();
                int b =  reader.nextInt();
                int c =  reader.nextInt();
                if(b ==1 && c==1){
                    both.add(a);
                }
                else if(b==1){
                    al.add(a);
                }else if(c==1)
                    bob.add(a);
            }
            Collections.sort(al);
            Collections.sort(bob);
            Collections.sort(both);
            int pos1 =0,pos2 =0,pos3 =0;
            long sum =0;

            for(int i=0;i<k;i++){
                if(pos1 < al.size() && pos2 < bob.size() &&
                        (pos3 >= both.size() || (pos3 < both.size() &&  al.get(pos1) + bob.get(pos2) < both.get(pos3)) ) ){
                    sum += (long) (al.get(pos1) + bob.get(pos2) );
                    pos1++;
                    pos2++;
                }else if(pos3 < both.size()){
                    sum += (long)both.get(pos3);
                    pos3++;
                }
            }
            if(pos1 + pos3 >=k && pos2 + pos3 >=k)
                writer.println(sum);
            else
                writer.println("-1");
        }
    }

    public static void main(String[] args) throws IOException {
        try (Input reader = new StandardInput(); PrintWriter writer = new PrintWriter(System.out)) {
            new E1374().run();
        }
    }

    StandardInput reader;
    PrintWriter writer;

    @Override
    public void run() {
        try {
            reader = new StandardInput();
            writer = new PrintWriter(System.out);
            solve();
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    interface Input extends Closeable {
        String next() throws IOException;

        String nextLine() throws IOException;

        default int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        default long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        default double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        default int[] readIntArray() throws IOException {
            return readIntArray(nextInt());
        }

        default int[] readIntArray(int size) throws IOException {
            int[] array = new int[size];
            for (int i = 0; i < array.length; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        default long[] readLongArray(int size) throws IOException {
            long[] array = new long[size];
            for (int i = 0; i < array.length; i++) {
                array[i] = nextLong();
            }
            return array;
        }
    }

    private static class StandardInput implements Input {
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        private StringTokenizer stringTokenizer;

        @Override
        public void close() throws IOException {
            reader.close();
        }

        @Override
        public String next() throws IOException {
            if (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                stringTokenizer = new StringTokenizer(reader.readLine());
            }
            return stringTokenizer.nextToken();
        }

        @Override
        public String nextLine() throws IOException {
            return reader.readLine();
        }
    }

}
