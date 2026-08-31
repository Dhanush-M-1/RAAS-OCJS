import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    public static final long       MEMORY_LIMIT      =   256 * (1L << 20);
    public static final String     INPUT_FILE_NAME   =   "input.txt";
    public static final String     OUTPUT_FILE_NAME  =   "output.txt";
    public static final boolean    ONLINE_JUDGE      =   System.getProperty("ONLINE_JUDGE") != null;
    
    public static void main(String[] args) throws FileNotFoundException {
        IOSystem IO = (TYPE.equals(IOSystem.STANDART) ? new IOSystem() : new IOSystem(INPUT_FILE_NAME, OUTPUT_FILE_NAME));
        new Thread(null, new Task(IO), "", MEMORY_LIMIT).start();
    }
}

class Task implements Runnable {
//------------------------------------------------------  SOLUTION  -----------------------------------------------------------//   

    public void solve() throws IOException {
        char task[] = in.readString().toLowerCase().toCharArray();
        int code = in.readInt();
        for (int i = 0; i < task.length; i++) {
            char upTmp = ("" + task[i]).toUpperCase().charAt(0);
            char loTmp = ("" + task[i]).toLowerCase().charAt(0);
            if ((int) (97 + task[i] - 'a') < code + 97) {
                task[i] = upTmp; 
            }
            else {
                task[i] = loTmp;
            }
        }
        out.println(new String(task));
    }
    
    public void solveD() throws IOException {
        int first = in.readInt();
        int second = in.readInt();
        out.println(second >> first);
//      if (first == second) out.println(0);
//      else if (second == 0) out.println(first);
//      else out.println(first / second);
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
    void debug(Object... o) {if (!Main.ONLINE_JUDGE) {System.err.println(Arrays.deepToString(o));}}
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
    int readInt() throws IOException {return Integer.parseInt(readString());}
    long readLong() throws IOException {return Long.parseLong(readString());}
    double readDouble() throws IOException {return Double.parseDouble(readString());}
}