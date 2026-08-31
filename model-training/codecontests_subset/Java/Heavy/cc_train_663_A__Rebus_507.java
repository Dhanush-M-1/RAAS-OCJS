import java.io.*;
import java.util.InputMismatchException;

public class Cf347B {
    private static InputReader in = new InputReader(System.in);
    private static OutputWriter out = new OutputWriter(System.out);




    private static void solve() throws Exception{
        int plus = 1;
        int minus = 0;
        StringBuilder question = new StringBuilder();

        while(true) {
            String s = in.readString();

            if (s.charAt(0) == '=') {
                break;
            }

            if(s.charAt(0)== '+'){
                plus++;
            }
            if(s.charAt(0)== '-'){
                minus++;
            }
            question.append(s.charAt(0));
        }
        String ques = question.toString();
        int n = in.readInt();
        int min = plus-minus*n;
        int max = plus*n-minus;
        if((n<min)||(n>max)){
            out.println("Impossible");
        }
        else{
            out.println("Possible");
            int difference = n - min;
            plus--;
            String result ="";
            int add = Math.min(n-1,difference);
            difference -= add;
            add++;
            result += add;

            for(int i=1; i<ques.length(); i=i+2){

                if(ques.charAt(i)=='-'){
                    result = result +" - ";
                    minus--;
                    add = Math.min(n-1,difference);
                    difference -= add;
                    add = n-add;
                    result += add;
                }
                else{
                    plus--;
                    result = result +" + ";
                    add = Math.min(n-1,difference);
                    difference -= add;
                    add++;
                    result += add;
                }

            }
            result += " = ";
            result += n;
            out.println(result);


        }


    }



    public static void main(String[] args) throws Exception {
        solve();
        out.close();
    }


    private static class InputReader {
        private InputStream stream;
        private byte[] buffer;
        private int currentIndex;
        private int bytesRead;

        public InputReader(InputStream stream) {
            this.stream = stream;
            buffer = new byte[131072];
        }


        public InputReader(InputStream stream, int bufferSize) {
            this.stream = stream;
            buffer = new byte[bufferSize];
        }


        private int read() throws IOException {
            if (currentIndex >= bytesRead) {
                currentIndex = 0;
                bytesRead = stream.read(buffer);
                if (bytesRead <= 0) {
                    return -1;
                }
            }
            return buffer[currentIndex++];
        }

        public String readString() throws IOException {
            int c = read();
            while (!isPrintable(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (isPrintable(c));
            return result.toString();
        }

        public int readInt() throws Exception {
            int c = read();
            int sign = 1;
            while (!isPrintable(c)) {
                c = read();
            }
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                if ((c < '0') || (c > '9')) {
                    throw new InputMismatchException();
                }
                result *= 10;
                result += (c - '0');
                c = read();
            } while (isPrintable(c));
            return sign * result;
        }

        public long readLong() throws Exception {
            int c = read();
            int sign = 1;
            while (!isPrintable(c)) {
                c = read();
            }
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long result = 0;
            do {
                if ((c < '0') || (c > '9')) {
                    throw new InputMismatchException();
                }
                result *= 10;
                result += (c - '0');
                c = read();
            } while (isPrintable(c));
            return sign * result;
        }

        public double readDouble() throws Exception {
            int c = read();
            int sign = 1;
            while (!isPrintable(c)) {
                c = read();
            }
            if (c == '-') {
                sign = -1;
                c = read();
            }
            boolean fraction = false;
            double multiplier = 1;
            double result = 0;
            do {
                if ((c == 'e') || (c == 'E')) {
                    return sign * result * Math.pow(10, readInt());
                }
                if ((c < '0') || (c > '9')) {
                    if ((c == '.') && (!fraction)) {
                        fraction = true;
                        c = read();
                        continue;
                    }
                    throw new InputMismatchException();
                }
                if (fraction) {
                    multiplier /= 10;
                    result += (c - '0') * multiplier;
                    c = read();
                } else {
                    result *= 10;
                    result += (c - '0');
                    c = read();
                }
            } while (isPrintable(c));
            return sign * result;
        }

        private boolean isPrintable(int c) {
            return ((c > 32) && (c < 127));
        }
    }

    private static class OutputWriter {
        private PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
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
}