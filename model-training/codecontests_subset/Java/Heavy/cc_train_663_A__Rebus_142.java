import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.Writer;
import java.io.OutputStreamWriter;
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(in, out);
        out.close();
    }
    static class TaskB {
        public void solve(InputReader in, OutputWriter out) {
            Expression expression = new Expression(in);
            int curindex = 0;
            while(expression.cur < expression.n) {
                if(expression.positive.size() == curindex) break;
                if(expression.positive.get(curindex).val == expression.n) {
                    curindex++;
                } else {
                    expression.positive.get(curindex).val++;
                    expression.cur++;
                }
            }
            curindex = 0;
            while(expression.cur > expression.n) {
                if(expression.negative.size() == curindex) break;
                if(expression.negative.get(curindex).val == expression.n) {
                    curindex++;
                } else {
                    expression.negative.get(curindex).val++;
                    expression.cur--;
                }
            }
            if(expression.cur == expression.n) {
                out.printLine("Possible");
                for(int i = 0; i < expression.terms.size(); i++) {
                    Term t = expression.terms.get(i);
                    if(i > 0) {
                        out.print(t.sign == 1 ? "+" : "-");
                        out.print(" ");
                    }
                    out.print(t.val + " ");
                }
                out.print("=", expression.n);
            } else {
                out.printLine("Impossible");
            }
        }
        class Term {
            int sign;
            int val;
            public Term(int sign, int val) {
                this.sign = sign;
                this.val = val;
            }
        }
        class Expression {
            int n;
            int cur = 0;
            ArrayList<Term> terms = new ArrayList<>();
            ArrayList<Term> positive = new ArrayList<>();
            ArrayList<Term> negative = new ArrayList<>();
            void append(int sign, int val) {
                Term t = new Term(sign, val);
                terms.add(t);
                if(sign == 1) positive.add(t);
                else negative.add(t);
            }
            public Expression(InputReader in) {
                String input = in.readLine();
                String[] arr = input.split(" ");
                int sign = 1;
                for(int i = 0; i < arr.length; i++) {
                    String term = arr[i];
                    if(term.equals("-")) sign = -1;
                    else if(term.equals("+")) sign = 1;
                    else if(term.equals("=")) {
                        n = Integer.parseInt(arr[i + 1]);
                        break;
                    } else {
                        append(sign, 1);
                    }
                }
                for(Term t : terms) this.cur += t.sign * t.val;
            }
        }
    }
    static class OutputWriter {
        private final PrintWriter writer;
        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }
        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }
        public void print(Object... objects) {
            for(int i = 0; i < objects.length; i++) {
                if(i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }
        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }
        public void close() {
            writer.close();
        }
    }
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
        public int read() {
            if(numChars == -1)
                throw new InputMismatchException();
            if(curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch(IOException e) {
                    throw new InputMismatchException();
                }
                if(numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
        private String readLine0() {
            StringBuilder buf = new StringBuilder();
            int c = read();
            while(c != '\n' && c != -1) {
                if(c != '\r')
                    buf.appendCodePoint(c);
                c = read();
            }
            return buf.toString();
        }
        public String readLine() {
            String s = readLine0();
            while(s.trim().length() == 0)
                s = readLine0();
            return s;
        }
    }
}