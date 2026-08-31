import java.io.BufferedWriter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
        }
    class InputReader {


        private InputStream stream;

        private byte[] buf = new byte[1024];

        private int curChar;

        private int numChars;

        private SpaceCharFilter filter;
        

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


        public int readInt() {

            int c = read();

            while (isSpaceChar(c))

                c = read();

            int sgn = 1;

            if (c == '-') {

                sgn = -1;

                c = read();

            }

            int res = 0;

            do {

                if (c < '0' || c > '9')

                    throw new InputMismatchException();

                res *= 10;

                res += c - '0';

                c = read();

            } while (!isSpaceChar(c));

            return res * sgn;

        }
        public long readLong() {

            int c = read();

            while (isSpaceChar(c))

                c = read();

            int sgn = 1;

            if (c == '-') {

                sgn = -1;

                c = read();

            }

            long res = 0;

            do {

                if (c < '0' || c > '9')

                    throw new InputMismatchException();

                res *= 10;

                res += c - '0';

                c = read();

            } while (!isSpaceChar(c));

            return res * sgn;

        }

        public String readString() {

            int c = read();

            while (isSpaceChar(c))

                c = read();

            StringBuilder res = new StringBuilder();

            do {

                res.appendCodePoint(c);

                c = read();

            } while (!isSpaceChar(c));

            return res.toString();

        }


        public boolean isSpaceChar(int c) {

            if (filter != null)

                return filter.isSpaceChar(c);

            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;

        }


        public String next() {

            return readString();

        }



    }


class OutputWriter {

        private final PrintWriter writer;


        public OutputWriter(OutputStream outputStream) {

            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));

        }


        public OutputWriter(Writer writer) {

            this.writer = new PrintWriter(writer);

        }


        public void print(Object...objects) {

            for (int i = 0; i < objects.length; i++) {

                if (i != 0)

                    writer.print(' ');

                writer.print(objects[i]);

            }

        }


        public void printLine(Object...objects) {

            print(objects);

            writer.println();

        }


        public void close() {

            writer.close();

        }


        public void flush() {

            writer.flush();

        }


        }

    /**
     * @param args
     */

    InputReader in= new InputReader(System.in);
    OutputWriter out = new OutputWriter(System.out);
        StringTokenizer tok;
      
        public static void main(String[] args) throws IOException
        {
           new Main().run();
        }
        void run() throws IOException
        {
            
           solve();
           out.flush();
           tok=null;
        }
      

void  solve() throws IOException{
		String ln=in.readString();
		Stack<Character> st=new Stack<Character>();
		int n=ln.length();
		for (int i=0;i<n;++i){
			if (st.size()==0){
				st.push(ln.charAt(i));
			}else{
				if (ln.charAt(i)=='T'){
					if (st.peek()=='S') st.pop();
					else st.push('T');
				}else{
					st.push('S');
				}
			}
		}
		out.printLine(st.size());

}        
}