import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
public class army {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        
        
        int n = in.nextInt();
        if (n==1) {
            System.out.println(1);
        } else {
        int[] a = new int[n];
        int[] b = new int[n];
        int x = in.nextInt();
        int h = in.nextInt();
        a[0] = x;
        b[0] = h;

        for (int i = 1;i<n;++i){
            int o = in.nextInt();
            int p = in.nextInt();
            a[i] =o;
            b[i] =p;
        }
        int count = 2;
        for (int j=1;j<n-1;++j){ 
            if (a[j]-b[j] > a[j-1]) {
                count = count + 1;
            } else if(a[j] + b[j] < a[j+1]) {
                count = count + 1;
                a[j] = a[j] + b[j];
            }
    
        }
        System.out.println(count);
    }
        out.close();
    }

}
class InputReader {
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
}    