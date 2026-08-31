import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task {
    static int[] queue;
    static Set<Long> set;

    public static void solve() throws Exception {
	int n = nextInt();
	int m = nextInt();
	queue = new int[n];
	for (int i = 0; i < n; i++) {
	    queue[i] = nextInt();
	}
	set = new HashSet<>(m);
	for (int i = 0; i < m; i++) {
	    int v = nextInt();
	    int k = nextInt();
	    set.add(k * 1000000L + v);
	}
	List<Integer> stack = new ArrayList<>(n);
	println(push(n - 1, 0));
    }

    private static int push(int nr, int bottom) {
	if (nr == bottom) {
	    return 0;
	}
	int count = 0;
	while (true) {
	    while (canMove(nr)) {
		int t = queue[nr];
		queue[nr] = queue[nr - 1];
		queue[nr - 1] = t;
		count++;
		nr--;
		if (nr == bottom) {
		    return count;
		} else if (nr < bottom) {
		    throw new RuntimeException();
		}
	    }
	    int moved = push(nr - 1, bottom);
	    if (moved == 0) {
		break;
	    }
	    bottom = nr - moved;
	}
	return count;
    }

    private static boolean canMove(int ind) {
	if (ind == 0)
	    return false;
	return set.contains(1000000L * queue[ind] + queue[ind - 1]);
    }

    public static void main(String[] args) throws Exception {
	try {
	    fastReader = new FastReader(System.in);
	    systemOut = new BufferedOutputStream(System.out);
	    solve();
	} finally {
	    systemOut.close();
	}
    }

    private static FastReader fastReader = null;
    private static BufferedOutputStream systemOut = null;

    public static void print(Object obj) {
	print(obj.toString());
    }

    public static void print(String str) {
	try {
	    systemOut.write(str.getBytes("utf-8"));
	} catch (Exception ex) {
	    throw new RuntimeException(ex);
	}
    }

    public static void println(Object obj) {
	println(obj.toString());
    }

    public static void println(String str) {
	try {
	    print(str);
	    systemOut.write('\n');
	} catch (Exception ex) {
	    throw new RuntimeException(ex);
	}
    }

    public static String next() {
	return fastReader.readNextToken(false);
    }

    public static String nextLine() {
	return fastReader.readNextToken(true);
    }

    public static int nextInt() {
	return Integer.parseInt(fastReader.readNextToken(false));
    }

    public static long nextLong() {
	return Long.parseLong(fastReader.readNextToken(false));
    }

    public static double nextDouble() {
	return Double.parseDouble(fastReader.readNextToken(false));
    }

    static class FastReader {
	private byte[] buf = new byte[65536];
	private int ind = 0;
	private int maxInd = -1;
	private InputStream is = null;
	private boolean eof = false;
	private boolean lastCharRead = false;

	public FastReader(InputStream is) {
	    this.is = is;
	}

	public String readNextToken(boolean endOfLine) {
	    try {
		StringBuilder sb = new StringBuilder();
		boolean found = false;
		while (true) {
		    if (lastCharRead) {
			return null;
		    } else if (ind > maxInd) {
			if (eof) {
			    lastCharRead = true;
			} else {
			    fillBuffer();
			}
		    }
		    byte b = '\n';
		    if (!lastCharRead) {
			b = buf[ind++];
		    }

		    if (b == '\r') {
			// ignore
		    } else if ((b == '\n' && endOfLine) || (Character.isWhitespace(b) && !endOfLine)) {
			if (found) {
			    break;
			}
		    } else {
			sb.append((char) b);
			found = true;
		    }
		}
		return sb.toString();
	    } catch (Exception ex) {
		throw new RuntimeException(ex);
	    }
	}

	private void fillBuffer() {
	    try {
		int read = is.read(buf, 0, buf.length);
		if (read < buf.length) {
		    eof = true;
		}
		ind = 0;
		maxInd = read - 1;
	    } catch (Exception ex) {
		throw new RuntimeException(ex);
	    }
	}
    }
}
