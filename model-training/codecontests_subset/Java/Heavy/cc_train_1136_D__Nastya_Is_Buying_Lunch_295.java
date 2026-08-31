import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Set;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in Actual solution is at the top
 */
public class Main {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    OutputWriter out = new OutputWriter(outputStream);
    TaskD solver = new TaskD();
    solver.solve(1, in, out);
    out.close();
  }

  static class TaskD extends ChelperSolution {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
      super.solve(testNumber, in, out);
    }

    public void solve(int testNumber) {
      int n = in.nextInt();
      int m = in.nextInt();

      int[] positions = in.nextIntArray(n);
      int[][] swaps = in.nextIntIntArray(m, 2);

      int[] positionOf = new int[n + 1];

      for (int i = 0; i < n; i++) {
        positionOf[positions[i]] = i;
      }

      List<Set<Integer>> rightSideOf = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        rightSideOf.add(new HashSet<>());
      }

      for (int i = 0; i < m; i++) {
        int l = positionOf[swaps[i][0]];
        int r = positionOf[swaps[i][1]];

        rightSideOf.get(l).add(r);
      }

      int nastya = n - 1;

      List<Integer> jumpers = new ArrayList<>();
      List<Integer> leftovers = new ArrayList<>();
      leftovers.add(nastya);

      for (int i = nastya - 1; i >= 0; i--) {
        boolean ok = true;

        for (Integer j : leftovers) {
          if (!rightSideOf.get(i).contains(j)) {
            ok = false;
            break;
          }
        }

        if (ok) {
          jumpers.add(i);
        } else {
          leftovers.add(i);
        }
      }

      out.println(jumpers.size());
    }

  }

  static class OutputWriter extends PrintWriter {
    public static OutputWriter toFile(String fileName) {
      try {
        return new OutputWriter(fileName);
      } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
      }
    }

    public void close() {
      super.close();
    }

    public OutputWriter(String fileName) throws FileNotFoundException {
      super(fileName);
    }

    public OutputWriter(OutputStream outputStream) {
      super(outputStream, true);
    }

    public OutputWriter(Writer writer) {
      super(writer, true);
    }

  }

  static abstract class ChelperSolution implements ChelperCallable {
    public static final String LOCAL_FILE = "chelper.properties";
    public static final String SAVE_RESULT_FILE = "last_test_output.txt";
    protected final boolean local = new File(LOCAL_FILE).exists();
    protected boolean firstTest = true;
    protected InputReader in;
    protected OutputWriter out;
    protected OutputWriter debug;
    protected OutputWriter fileOut;
    protected boolean saveTestResult = true;
    protected boolean gcj = false;

    protected void init() {
      if (local) {
        debug = new OutputWriter(System.err);
        if (saveTestResult) {
          fileOut = OutputWriter.toFile(SAVE_RESULT_FILE);
        }
      } else {
        debug = new OutputWriter(new NullOutputStream());
      }
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
      if (firstTest) {
        init();
        precalc();
        firstTest = false;
      }

      this.in = in;
      if (local && saveTestResult) {
        this.out = new SplittingOutputWriter(out, fileOut);
      } else {
        this.out = out;
      }

      preSolve(testNumber);
      solve(testNumber);
      postSolve(testNumber);
    }

    protected void precalc() {

    }

    protected void preSolve(int testNumber) {
      if (gcj) {
        out.printf("Case #%d: ", testNumber);
      }
    }

    public abstract void solve(int testNumber);

    protected void postSolve(int testNumber) {
      out.flush();
      debug.flush();
    }

  }

  static interface ChelperCallable {
  }

  static class NullOutputStream extends OutputStream {
    public void write(int b) throws IOException {
      // nothing
    }

  }

  static class SplittingOutputWriter extends OutputWriter {
    private final OutputWriter[] outputWriters;

    public SplittingOutputWriter(OutputWriter... outputWriters) {
      super(new OutputStream() {

        public void write(int b) throws IOException {
          for (OutputWriter outputWriter : outputWriters) {
            outputWriter.write(b);
          }
        }
      });

      this.outputWriters = outputWriters;
    }

    public void flush() {
      for (OutputWriter outputWriter : outputWriters) {
        outputWriter.flush();
      }
    }

    public void close() {
      for (OutputWriter outputWriter : outputWriters) {
        outputWriter.close();
      }
    }

  }

  static class InputReader {
    private BufferedReader br;
    private StringTokenizer in;

    public InputReader(String fileName) {
      try {
        br = new BufferedReader(new FileReader(fileName));
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    public InputReader(InputStream inputStream) {
      br = new BufferedReader(new InputStreamReader(inputStream));
    }

    private boolean hasMoreTokens() {
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

    public int[] nextIntArray(int n) {
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = nextInt();
      }
      return a;
    }

    public int[][] nextIntIntArray(int n, int m) {
      int[][] a = new int[n][m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          a[i][j] = nextInt();
        }
      }
      return a;
    }

  }
}

