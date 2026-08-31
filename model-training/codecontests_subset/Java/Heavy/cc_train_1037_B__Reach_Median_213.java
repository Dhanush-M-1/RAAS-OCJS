import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Two {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.call(in,out);

        out.close();
    }

    static class TaskA {
        public void call(InputReader in, PrintWriter out) {
            int n, k ;
            long a=0;
            n = in.nextInt();
            k = in.nextInt();
            
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            if(arr[n/2]!=k) {
                a = Math.abs(arr[n/2]-k);

                if(arr[n/2]>k){
                    arr[n/2] = k;
                    for (int i = n/2 -1; i >=0 ; i--) {
                        if(arr[i+1]<arr[i]){
                            a+= (long) arr[i] - (long) arr[i+1];
                            arr[i] = arr[i+1];
                        }
                    }
                }
                else {
                    arr[n/2] = k;
                    for (int i = n/2 +1; i <n ; i++) {
                        if(arr[i-1]>arr[i]){
                            a+= (long) arr[i-1] - (long)arr[i];
                            arr[i] = arr[i-1];
                        }
                    }
                }
                out.println(a);
            }
            else{
                out.println(0);
            }

        }
    }

    static final Random random=new Random();

    static void shuffleSort(int[] arr) {
        int n=arr.length;
        for (int i=0; i<n; i++) {
            int a=random.nextInt(n), temp=arr[a];
            arr[a]=arr[i];
            arr[i]=temp;
        }
        Arrays.sort(arr);
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
        public long nextLong(){
            return Long.parseLong(next());
        }

    }
}