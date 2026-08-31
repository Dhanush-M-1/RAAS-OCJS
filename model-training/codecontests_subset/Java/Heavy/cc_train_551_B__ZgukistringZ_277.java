import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.io.Writer;
import java.math.BigInteger;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author walker
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String a = in.readLine();
        String b = in.readLine();
        String c = in.readLine();
        char[] ans = new char[a.length()];
        int idx = 0;
        int[] BCounts = new int['z' + 1];
        int[] CCounts = new int['z' + 1];
        int[] ACounts = new int['z' + 1];
        for(int i = 0; i < a.length(); i++){
            ACounts[a.charAt(i)]++;
        }
        for(int i = 0; i < b.length(); i++){
            BCounts[b.charAt(i)]++;
        }
        for(int i = 0; i < c.length(); i++){
            CCounts[c.charAt(i)]++;
        }
        while(true){
            int toAdd = 0;
            int Bmin = Integer.MAX_VALUE, Cmin = Integer.MAX_VALUE;
            boolean Bflag = false, Cflag = false;
            for(int i = 'a'; i <= 'z'; i++){
                if(BCounts[i] > 0){
                    if(ACounts[i] >= BCounts[i]){
                        Bmin = Math.min(Bmin, ACounts[i] / BCounts[i]);
                    }
                    else{
                        Bflag = true;
                    }
                }
                if(CCounts[i] > 0){
                    if(ACounts[i] >= CCounts[i]){
                        Cmin = Math.min(Cmin, ACounts[i] / CCounts[i]);
                    }
                    else{
                        Cflag = true;
                    }
                }
            }
            if(Cflag && Bflag){
                break;
            }
            else if(Cflag){
                for(int i = 0; i < b.length(); i++){
                    ACounts[b.charAt(i)]--;
                    ans[idx++] = b.charAt(i);
                }
            }
            else if(Bflag){
                for(int i = 0; i < c.length(); i++){
                    ACounts[c.charAt(i)]--;
                    ans[idx++] = c.charAt(i);
                }
            }
            else if(Bmin >= Cmin){
                for(int i = 0; i < b.length(); i++){
                    ACounts[b.charAt(i)]--;
                    ans[idx++] = b.charAt(i);
                }
            }
            else{
                for(int i = 0; i < c.length(); i++){
                    ACounts[c.charAt(i)]--;
                    ans[idx++] = c.charAt(i);
                }
            }
        }
        for(int i = 'a'; i <= 'z'; i++){
            while(ACounts[i] > 0){
                ACounts[i]--;
                ans[idx++] = (char)i;
            }
        }
        for(int i = 0; i < ans.length; i++){
            out.print(ans[i]);
        }
    }
}

class InputReader {

	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;

    public InputReader(InputStream stream) {
		this.stream = stream;
	}

	public int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

    private String readLine0() {
		StringBuilder buf = new StringBuilder();
		int c = read();
		while (c != '\n' && c != -1) {
			if (c != '\r')
				buf.appendCodePoint(c);
			c = read();
		}
		return buf.toString();
	}

	public String readLine() {
		String s = readLine0();
		while (s.trim().length() == 0)
			s = readLine0();
		return s;
	}

}

class OutputWriter {
	private final PrintWriter writer;

	public OutputWriter(OutputStream outputStream) {
		writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
	}

    public void print(char i) {
		writer.print(i);
	}

	public void close() {
		writer.close();
	}

}

