import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author darinflar
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int a = in.readInt(), b = in.readInt();
        int ans = a;
        while (a >= b){
            int left = a % b;
            a /= b;
            ans += a;
            a += left;
        }
        out.printLine(ans);
    }
}

class InputReader {
    public InputReader(InputStream stream){
        reader = new BufferedReader(new InputStreamReader(stream));
    }

    public InputReader(Reader in){
        reader = new BufferedReader(in);
    }

    public String readLine(){
        String result = null;
        try{
            result = reader.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }

    public String readWord(){
        while (tokenizer == null || !tokenizer.hasMoreTokens())
            tokenizer = new StringTokenizer(readLine());
        return tokenizer.nextToken();
    }

    public int readInt(){
        return Integer.parseInt(readWord());
    }

    private BufferedReader reader;
    private StringTokenizer tokenizer;
}

class OutputWriter {
    public OutputWriter(PrintWriter writer) {
        this.writer = writer;
    }

    public OutputWriter(OutputStream outputStream){
        writer = new PrintWriter(new OutputStreamWriter(outputStream));
    }

    public OutputWriter(Writer out){
        writer = new PrintWriter(out);
    }

    public void print(Object...args){
        int size = args.length;
        for (int i = 0; i < size; i++)
            writer.print(args[i]);
    }

    public void printLine(Object...args){
        print(args);
        writer.println();
    }

    public void close(){
        writer.close();
    }

    private PrintWriter writer;
}

