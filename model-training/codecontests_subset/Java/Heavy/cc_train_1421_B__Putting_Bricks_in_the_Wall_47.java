import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        StringBuilder sb0 = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        int T = sc.nextInt();
        for(int ti = 0; ti < T; ti++){
            int n = sc.nextInt();
            char[][] map = new char[n][n];
            for(int i = 0; i < n; i++){
                map[i] = sc.next().toCharArray();
            }
            int a0 = 0;
            int a1 = 0;
            if(map[0][1] == '1'){
                a1++;
                sb1.append(1).append(" ").append(2).append("\n");
            }else{
                a0++;
                sb0.append(1).append(" ").append(2).append("\n");
            }
            if(map[1][0] == '1'){
                a1++;
                sb1.append(2).append(" ").append(1).append("\n");
            }else{
                a0++;
                sb0.append(2).append(" ").append(1).append("\n");
            }
            if(a1 >= 2){
                if(map[n-1][n-2] == '1'){
                    sb0.append(n).append(" ").append(n-1).append("\n"); a0++;
                }
                if(map[n-2][n-1] == '1'){
                    sb0.append(n-1).append(" ").append(n).append("\n"); a0++;
                }
                pw.println(a0);
                pw.print(sb0.toString());
            }else if(a0 >= 2){
                if(map[n-1][n-2] == '0'){
                    sb1.append(n).append(" ").append(n-1).append("\n"); a1++;
                }
                if(map[n-2][n-1] == '0'){
                    sb1.append(n-1).append(" ").append(n).append("\n"); a1++;
                }
                pw.println(a1);
                pw.print(sb1.toString());
            }else{
                if(map[n-1][n-2] != map[n-2][n-1]){
                    if(map[n-1][n-2] == '1'){
                        pw.println(2);
                        sb0.append(n).append(" ").append(n-1).append("\n"); a1++;
                        pw.print(sb0.toString());
                    }else{
                        pw.println(2);
                        sb1.append(n).append(" ").append(n-1).append("\n"); a1++;
                        pw.print(sb1.toString());
                    }
                }else{
                    if(map[n-1][n-2] == '1'){
                        pw.println(1);
                        pw.print(sb1.toString());
                    }else{
                        pw.println(1);
                        pw.print(sb0.toString());
                    }
                }
            }
            sb0.setLength(0);
            sb1.setLength(0);
        }
        pw.flush();
    }

    static class GeekInteger {
        public static void save_sort(int[] array) {
            shuffle(array);
            Arrays.sort(array);
        }
 
        public static int[] shuffle(int[] array) {
            int n = array.length;
            Random random = new Random();
            for (int i = 0, j; i < n; i++) {
                j = i + random.nextInt(n - i);
                int randomElement = array[j];
                array[j] = array[i];
                array[i] = randomElement;
            }
            return array;
        }
 
    }
}

class FastScanner {
    private BufferedReader reader = null;
    private StringTokenizer tokenizer = null;
    public FastScanner(InputStream in) {
        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = null;
    }

    public String next() {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public String nextLine() {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken("\n");
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
         return Double.parseDouble(next());
    }
    
    public String[] nextArray(int n) {
        String[] a = new String[n];
        for (int i = 0; i < n; i++)
            a[i] = next();
        return a;
    }

    public int[] nextIntArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = nextInt();
        return a;
    }

    public long[] nextLongArray(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = nextLong();
        return a;
    } 
}
