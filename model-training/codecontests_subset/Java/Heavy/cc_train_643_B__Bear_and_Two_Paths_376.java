import java.util.ArrayList;
import java.util.List;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;
import java.io.StringWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.SortedSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
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

class TaskB extends SimpleSolution {

  public void solve(int testNumber) {
    int n = in.nextInt();
    int k = in.nextInt();

    int a = in.nextInt() - 1;
    int b = in.nextInt() - 1;
    int c = in.nextInt() - 1;
    int d = in.nextInt() - 1;

    if (n == 4 || k < n + 1) {
      out.println(-1);
      return;
    }

    SortedSet<Integer> set = new TreeSet<>();
    for (int i = 0; i < n; i++) {
      set.add(i);
    }

    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    list1.add(a);
    list1.add(c);

    SortedSet<Integer> set2 = new TreeSet<>(set);

    for (int i = 0; i < n - 4; i++) {
      int t = set2.first();
      set2.remove(t);

      if (t == a || t == b || t == c || t == d) {
        i--;
        continue;
      }

      list1.add(t);
    }

    list1.add(d);
    list1.add(b);

    list2.add(c);
    list2.add(a);
    list2.add(list1.get(2));

    for (int i = 3; i < n - 2; i++) {
      list2.add(list1.get(i));
    }

    list2.add(b);
    list2.add(d);

    for (int i = 0; i < n; i++) {
      out.print((list1.get(i) + 1) + " ");
    }
    out.println();

    for (int i = 0; i < n; i++) {
      out.print((list2.get(i) + 1) + " ");
    }
    out.println();
  }
}

abstract class SimpleSolution extends AbstractSolution {

  public SimpleSolution() {
    super();
    saveToFile = false;
  }

  public String postProcessTestOutput(String output, int testNumber) {
    return output;
  }
}

class InputReader {

	BufferedReader br;
	StringTokenizer in;

  public InputReader(InputStream inputStream) {
		br = new BufferedReader(new InputStreamReader(inputStream));
	}

	boolean hasMoreTokens() {
		while (in == null || !in.hasMoreTokens()) {
			String s = nextLine();
			if (s == null) {
				return false;
			}
			in = new StringTokenizer(s);
		}
		return true;
	}

	public String nextString() {
		return hasMoreTokens() ? in.nextToken() : null;
	}

	public String nextLine() {
		try {
			in = null;
			return br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int nextInt() {
		return Integer.parseInt(nextString());
	}

}

abstract class AbstractSolution {

  protected InputReader in;
  protected OutputWriter out;

  protected OutputWriter log;

  protected boolean saveToFile = true;

  private OutputWriter fileOut;

  public AbstractSolution() {
    log = new OutputWriter(System.out);
  }

  private boolean initialized = false;

  public void init() {
    if (saveToFile) {
      try {
        fileOut = new OutputWriter("chelper-output/last_output.txt");
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    if (!initialized) {
      init();
      initialized = true;
    }

    StringWriter sw = new StringWriter();

    this.in = in;
    this.out = new OutputWriter(sw);

    solve(testNumber);

    String testOutput = postProcessTestOutput(sw.toString(), testNumber);

    out.print(testOutput);
    out.flush();

    if (saveToFile) {
      fileOut.print(testOutput);
      fileOut.flush();
    }

    log.flush();
  }

  abstract public void solve(int testNumber);

  abstract public String postProcessTestOutput(String output, int testNumber);
}

class OutputWriter extends PrintWriter {

  public OutputWriter(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public OutputWriter(OutputStream outputStream) {
        super(outputStream);
    }

    public OutputWriter(Writer writer) {
        super(writer);
    }

}

