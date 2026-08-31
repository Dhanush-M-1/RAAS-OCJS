import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    static void solve(InputReader reader, OutputWriter writer)
            throws IOException {
        // Scanner scan = new Scanner(System.in);
        String s = reader.readLine();
        String[] split = s.split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        int count = a + a / b;

        // if(count - a >= b){
        int num = count;
        int x = a + 1;
        while (true) {
            if(a <= b){
                break;
            } 
            int counter = 0;
            for (int i = x; i <= num; ++i) {
                if (i % b == 0) {
                    count++;
                    counter++;

                }
            }
            //writer.println(counter + " " + num);
            if (counter == 0) { 
                break;
            }
            x = num +1;
            num += counter;
            
        }
        writer.println(count);
        // }

    }

    public static void main(String[] args) throws Exception {
        InputReader reader = new InputReader(System.in);
        OutputWriter writer = new OutputWriter(System.out);
        try {
            solve(reader, writer);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            writer.close();
        }
    }

}

class InputReader extends BufferedReader {
    public InputReader(InputStream in) {
        super(new InputStreamReader(in));
    }
}

class OutputWriter extends PrintWriter {
    public OutputWriter(PrintStream out) {
        super(new BufferedWriter(new OutputStreamWriter(out)));
    }
}
