import java.io.*; 
import java.util.*; 

public class A {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream inputStream = System.in;
        //inputStream = new FileInputStream("C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\JavaApplication1\\src\\in");
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(in, out);
        out.close();
    }
    
    static class TaskC {
        
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[] a = new int[n];
            int sum = 0;
            for(int i = 0 ;i < n ; i++){
                a[i] = in.nextInt();
                sum += a[i];
            }
            Arrays.sort(a);
            int k = (2*sum) / n;
            if( (2*sum) % n != 0) k ++;
            k = Math.max(k , a[n-1]);
            if(k*n - sum <= sum) k++;
            out.println(k);
        }
       
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}