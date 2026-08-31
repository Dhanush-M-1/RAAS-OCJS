import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 *
 * @author Harsh Vardhan Kumar
 */
public class newMain1 {
    public static boolean eof = false ;
    public static void main(String[] args) {
        Reader in = new Reader(new BufferedReader(new InputStreamReader(System.in)));
        String first = in.next() ;
        String second = in.next() ;
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)), true) ;
        int n = in.nextInt() ;
        out.println(first+" "+second);
        for(int i = 0 ; i<n ; i++) {
            String re = in.next() ;
            String rep = in.next() ;
            //System.out.println("re si "+re+" rep is "+rep);
            if(re.equals(first)) {
                first = rep ;
            }
            else second = rep ;
            out.println(first+" "+second);
        }
    }
    static class Reader {
        private static BufferedReader b ;
        public static String line ;
        public Reader() {
        }

        public Reader(BufferedReader b) {
            this.b = b ;
        }
        private static StringTokenizer st = null;
        public static String next()  {
            
            if(st==null || !st.hasMoreElements()) {
                try { 
                    line = b.readLine() ;
                    if(line==null) {
                        eof = true ; 
                        return null ;
                    }
                    else {
                        st=new StringTokenizer(line);
                    }
                } catch (IOException ex) {
                    
                }
            }
            return st.nextToken() ;
        }
        public static String nextLine()  {
            try {
                return b.readLine() ;
            } catch (IOException ex) {
                
            }
            return line ;
        }
        public static int nextInt()  {
            return Integer.parseInt(next());
        }
        public static long nextLong()  {
            return Long.parseLong(next());
        }
        public static float nextFloat()  {
            return Float.parseFloat(next());
        }
        public void close() throws IOException {
            b.close() ;
        }
        
    }
    
}
