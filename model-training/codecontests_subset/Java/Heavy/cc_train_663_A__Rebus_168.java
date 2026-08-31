import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main12 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
    	
        public void solve(int testNumber, InputReader in, PrintWriter out) {
        	List<String> ops = new ArrayList<>();
        	ops.add("+");
        	int plus = 1;
        	int minus = 0;
        	while (true) {
        		String next = in.next();
        		if (next.equals("+") || next.equals("-")) {
        			ops.add(next);
        			if (next.equals("+"))
        				plus++;
        			else
        				minus++;
        		}
        		if (next.equals("=")) {
        			break;
        		}
        	}
        	
        	int val = Integer.parseInt(in.next());
        	final int max = val;
        	int nbalance = -val;
        	nbalance -= minus;
        	int[] subs = new int[minus];
        	for (int i = 0; i < minus; i++)
        		subs[i]++;
        	if (-nbalance > max * plus) {
        		out.println("Impossible");
        		return;
        	}
        	int[] adds = new int[plus];
        	int idx = 0;
        	while (nbalance != 0) {
        		adds[idx++ % plus]++;
        		nbalance++;
        	}
        	
        	while (idx < plus) {
        		adds[idx++] = 1;
        		if (minus == 0) {
            		out.println("Impossible");
            		return;
        		}
        		subs[idx % minus]++;
        	}
        	
        	for (int i = 0; i < plus; i++) {
        		if (adds[i] > max) {
        			out.println("Impossible");
        			return;
        		}
        	}
        	// ? - ? + ? + ? = 1
        	for (int i = 0; i < minus; i++) {
        		if (subs[i] > max) {
        			out.println("Impossible");
        			return;
        		}
        	}
        	
        	int ip = 0,
        		im = 0;
        	StringBuilder sb = new StringBuilder();
        	for (int i = 0; i < ops.size(); i++) {
        		if (ops.get(i).equals("+")) {
        			if (i != 0)
        				sb.append("+ ");
        			sb.append(adds[ip++]);
        			sb.append(" ");
        		} else {
        			sb.append("- ");
        			sb.append(subs[im++]);
        			sb.append(" ");
        		}
        	}
        	
        	sb.append("= ");
        	sb.append(max);
        	out.println("Possible");
        	out.println(sb.toString().trim());
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}