//package contest_123_div2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.Writer;

public class A {
	public static void main(String[] args) throws IOException {
		new A().run();
	}

	int nextInt() throws IOException {
		in.nextToken();
		return (int) in.nval;
	}

	String nextString() throws IOException {
		in.nextToken();
		return (String) in.sval;
	}

	StreamTokenizer in;
	Writer writer;
	Reader reader;

	void run() throws IOException {
		boolean oj = System.getProperty("ONLINE_JUDGE") != null;
		reader = oj ? new InputStreamReader(System.in, "ISO-8859-1")
				: new FileReader("src/contest_123_div2/A.txt");
		writer = new OutputStreamWriter(System.out, "ISO-8859-1");
		in = new StreamTokenizer(new BufferedReader(reader));
		PrintWriter out = new PrintWriter(writer);
		int a = nextInt();
		int b = nextInt();
		int c = nextInt();
		out.println((int)Math.ceil(((double)a * c - b * c) / b));
		out.flush();
		out.close();
	}
}
