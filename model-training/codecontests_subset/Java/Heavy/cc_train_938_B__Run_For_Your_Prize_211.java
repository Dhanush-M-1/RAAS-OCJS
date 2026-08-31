import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Abhas
 */
public class JavaApplication12 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        InputReader ir = new InputReader(); int x=0,y=0;
        int t = ir.nextInt();
         while(t-->0){
            x = ir.nextInt();
            if(x>500000){
                System.out.println(max(y-1,1000000-x)); break;
            }
            y=x;
        }
        if(x<=500000) System.out.println(y-1);
    }
        static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
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
        static int max(int x,int y){
            if(x>y) return x;
            else return y;
        }
    
}