import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
    
/**
 * @Author  Roman Dzhadan
 * @Team    VNTU [Noobs v3.0]
 * @E-Mail  dflash36@gmail.com
 * @Skype   ronex36
 */
public class Main {
        
    public static final String     TYPE              =   IOSystem.STANDART;
    public static final long       TIME_LIMIT        =   2;
    public static final long       MEMORY_LIMIT      =   512 * (1L << 20);
    public static final String     INPUT_FILE_NAME   =   "input.txt";
    public static final String     OUTPUT_FILE_NAME  =   "output.txt";
    public static final boolean    ONLINE_JUDGE      =   System.getProperty("ONLINE_JUDGE") != null;
        
    public static void main(String[] args) throws FileNotFoundException {
        Main task = new Main();
        IOSystem IO = (TYPE.equals(IOSystem.STANDART) ? task.new IOSystem() : task.new IOSystem(INPUT_FILE_NAME, OUTPUT_FILE_NAME));
        new Thread(null, task.new Task(IO), "", MEMORY_LIMIT).start();
    }

    
    class Task implements Runnable {
    //------------------------------------------------------  SOLUTION  -----------------------------------------------------------//   
            
        public void solveA() throws IOException {

            String a = in.readInt() + "";
            int b = in.readInt();
            int n = in.readInt();
            
            BigInteger B = new BigInteger("" + b);
            
            BigInteger counter = BigInteger.ONE;
            BigInteger one = BigInteger.ONE;
            
            while (true) {
                BigInteger res = B.multiply(counter);
                String s = res.toString();
                if (s.length() > n + a.length()) {
                    out.println(-1);
                    return;
                }
                if (s.length() == n + a.length() && s.startsWith(a)) {
                    out.println(s);
                    return;
                }
                counter = counter.add(one);
            }
        }
        
        public int[] prefixFunction(String s) {
            int[] p = new int[s.length()];
            p[0] = 0;
            int k = 0;
            for (int i = 1; i < s.length(); i++) {
                while (k > 0 && s.charAt(k) != s.charAt(i))
                    k = p[k - 1];
                if (s.charAt(k) == s.charAt(i))
                    ++k;
                p[i] = k;
            }
            return p;
        }
        
        public int kmpMatcher(String s, String pattern) {
            int qnty = 0;
            int m = pattern.length();
            if (m == 0)
                return 0;
            int[] p = prefixFunction(pattern);
            for (int i = 0, k = 0; i < s.length(); i++)
                for (;; k = p[k - 1]) {
                    if (pattern.charAt(k) == s.charAt(i)) {
                        if (++k == m)
                            return ++qnty;
                            //return i + 1 - m;
                        break;
                    }
                    if (k == 0)
                        break;
                }
            return qnty;
        }
        
        public void solve() throws IOException {
            int best =  -1;
            String result = "";
            
            text = in.readLine();
            hashing(text);
            
            int[]month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            for (int i = 2013; i <= 2015; i++) {
                for (int j = 1; j <= 12; j++) {
                    for (int k = 1; k <= month[j - 1]; k++) {
                        char[]pattern = new char[6];
                        Arrays.fill(pattern, '0');
                        if (k < 10) {
                            pattern[1] = (char)((k) + '0');
                        }
                        else {
                            pattern[0] = (char)((k / 10) + '0');
                            pattern[1] = (char)((k % 10) + '0');
                        }
                        pattern[2] = '-';
                        if (j < 10) {
                            pattern[4] = (char)((j) + '0');
                        }
                        else {
                            pattern[3] = (char)((j / 10) + '0');
                            pattern[4] = (char)((j % 10) + '0');
                        }
                        pattern[5]='-';
                        String find = new String(pattern) + i;
                        int qnty = find(find);
                        if (qnty >= best) {
                            result = find;
                            best = qnty;
                        }
                    }
                }
            }
            
            out.println(result);
            
        }

        long[]p_pow;
        String text;
        long[]h;
        
        public void hashing(String text) {
            long p = 31;
            p_pow = new long[text.length()];
            p_pow[0] = 1;
            for (int i=1; i < p_pow.length; ++i)
                p_pow[i] = p_pow[i-1] * p;
            
            h = new long[text.length()];
            for (int i=0; i < text.length(); ++i)
            {
                h[i] = (text.charAt(i) - 'a' + 1) * p_pow[i];
                if (i!=0)  h[i] += h[i-1]; //check
            }
        }
        
        public int find(String pattern) {
            int res = 0;
            long h_s = 0;
            for (int i=0; i<pattern.length(); ++i)
                h_s += (pattern.charAt(i) - 'a' + 1) * p_pow[i];
            
            for (int i = 0; i + pattern.length() - 1 < text.length(); ++i)
            {
                long cur_h = h[i+pattern.length()-1];
                if (i!=0)  cur_h -= h[i-1];
                if (cur_h == h_s * p_pow[i])
                    res++;
            }
            return res;
        }
        
        //-----------------------------------------------------------------------------------------------------------------------------//
        public void run() {
            try {
                long startTime = System.currentTimeMillis();
                solve();
                close();
                long endTime = System.currentTimeMillis();
                long totalMemory = Runtime.getRuntime().totalMemory();
                long freeMemory = Runtime.getRuntime().freeMemory();
                System.err.printf("Time = %.3f ms\n", (endTime - startTime) / 1000.0);
                System.err.printf("Memory = %.3f MB\n", (totalMemory - freeMemory) / (double)(1L << 20));
            }
            catch (Throwable e) {e.printStackTrace(System.err);System.exit(-1);}
        }
        public PrintWriter out;
        public IOSystem in;
        public Task(IOSystem io) {out = io.out; this.in = io;}
        public void close() throws IOException {in.in.close(); out.close();}
    }
    
    class IOSystem {
        public static final String FILE = "file";
        public static final String STANDART = "stdin";
        
        BufferedReader in;
        StringTokenizer tok;
        PrintWriter out;
        
        public IOSystem() {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            tok = new StringTokenizer("");
        }
        
        public IOSystem(String inputFileName, String outputFileName) throws FileNotFoundException {
            in = new BufferedReader(new FileReader(inputFileName));
            out = new PrintWriter(outputFileName);
            tok = new StringTokenizer("");
        }
        
        String readString() throws IOException {while (!tok.hasMoreTokens()) {String line = in.readLine();if (line == null) return null;tok = new StringTokenizer(line);}return tok.nextToken();}
        String readLine() throws IOException {return in.readLine();}
        int readInt() throws IOException {return Integer.parseInt(readString());}
        long readLong() throws IOException {return Long.parseLong(readString());}
        double readDouble() throws IOException {return Double.parseDouble(readString());}
        void debug(Object... o) {if (!Main.ONLINE_JUDGE) {System.err.println(Arrays.deepToString(o));}}
    }
}