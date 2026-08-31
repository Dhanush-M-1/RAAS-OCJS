

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {

    public static void main(String[] args) throws IOException {
        IOHelper ioh = new IOHelper();

        int n = ioh.nextInt();
        int m = ioh.nextInt();
        
        int [] ar = new int [m];
        
        
        for(int i=0;i<n;i++){
            
            int sz = ioh.nextInt();
            for(int j=0;j<sz;j++){
                ar[ioh.nextInt()-1]=1;
            }
        }
        boolean y = true;
        for(int i=0;i<m;i++){
            if(ar[i]==0){
                y = false;
                break;
            }
        }
        if(y)
            System.out.println("YES");
        else
            System.out.println("NO");
        
        


    }
    
    private static class IOHelper {
        private InputStreamReader isr = new InputStreamReader(System.in);
        private BufferedReader br = new BufferedReader(isr);
        private StringTokenizer tokenizer;

        public String next() throws IOException {
            while(tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(br.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }

}
