
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tibor
 */
public class test {

//   static java.io.InputStreamReader converter = new java.io.InputStreamReader(System.in);
//    static java.io.BufferedReader in = new java.io.BufferedReader(converter);
//
//    public static String readLine() {
//        String s = "";
//        try {
//
//            s = in.readLine();
//        } catch (Exception e) {
//            System.out.println("Error! Exception: " + e);
//        }
//        return s;
//    }
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(
            new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(System.out);

//    static {
//        in.ordinaryChars('-', '-');
//        in.ordinaryChars('+', '+');
//        in.wordChars('-', '-');
//        in.wordChars('+', '+');
//    }
    static int nextInt() {
        try {
            in.nextToken();
        } catch (IOException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (int) in.nval;
    }

    static String nextString() {
        try {
            in.nextToken();
        } catch (IOException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
        return in.sval;
    }

    public static void main(String args[]) throws Exception {
        int n, x, y;
        
        n = nextInt();
        x = nextInt();
        y = nextInt();
        y = (n * y + 99) / 100;
if(y<x)y=x;
        System.out.print(y - x);
    }


   
}
