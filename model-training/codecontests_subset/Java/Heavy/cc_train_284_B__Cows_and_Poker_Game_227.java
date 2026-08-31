import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 *
 * @author Jose Arandia Luna https://github.com/jma-moon
 */
public class CowsAndPokerGame {

    public static void main(String[] args) throws IOException {
        int cowsNumber = In.nInt();
        String statuses = In.nString();

        int aCounter = 0;
        int iCounter = 0;
        
        for (int i = 0; i < cowsNumber; i++) {
            switch (statuses.charAt(i)) {
                case 'A':
                    aCounter++;
                    break;
                case 'I':
                    iCounter++;
                    break;
            }
        }
        
        int result = 0;
        
        if (iCounter == 0) {
            result = aCounter;
        }
        if (iCounter == 1) {
            result = iCounter;
        }
        
        Out.print(result);
        
        Out.close();
    }

    private static class Out {

        private static PrintWriter output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        public static void print(Object o) {
            output.print(o);
        }
        
        public static void printLn(Object o) {
            output.println(o);
        }

        public static void close() {
            output.close();
        }

    }

    private static class In {

        private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public static String nString() throws IOException {
            return br.readLine();
        }

        public static int nInt() throws IOException {
            return SP.toInt(nString());
        }

        public static long nLong() throws IOException {
            return SP.toLong(nString());
        }

        public static double nDouble() throws IOException {
            return SP.toDouble(nString());
        }

    }

    private static class SP {

        public static String[] split(String line, String separator) {
            return line.split(separator);
        }

        public static int toInt(String s) {
            return Integer.parseInt(s);
        }

        public static long toLong(String s) {
            return Long.parseLong(s);
        }

        public static double toDouble(String s) {
            return Double.parseDouble(s);
        }

    }

}
