import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Cf2802D {
    private static InputReader in = new InputReader(System.in);
    private static OutputWriter out = new OutputWriter(System.out);




    private static void solve() throws Exception{
        int n = in.readInt();
        int k = in.readInt();
        int a = in.readInt();
        int b = in.readInt();
        int q = in.readInt();
        long[] orders1 = new long[n+1];
        long[] orders2 = new long[n+1];
        fenwickTree ft = new fenwickTree(n);
        for(int i=0; i<q; ++i){
            int type  = in.readInt();
            if(type==1){
                int d = in.readInt();
                int o = in.readInt();
                if(orders1[d]+o<=b){
                    orders1[d] += o;
                    ft.update1(d,o);
                }
                else{
                    ft.update1(d,b-orders1[d]);
                    orders1[d] = b;
                }
                if(orders2[d]+o<=a){
                    orders2[d] += o;
                    ft.update2(n-d+1,o);
                }
                else{
                    ft.update2(n-d+1,a-orders2[d]);
                    orders2[d] = a;
                }
            }
            else{
                int p = in.readInt();
                long result = ft.prefixSum(p-1)+ft.suffixSum(n+1-p-k);
                out.println(result);
            }
        }

    }



    public static void main(String[] args) throws Exception {
        solve();
        out.close();
    }

    private static class fenwickTree{

        long[] prefix;
        long[] suffix;
        int length;

        public fenwickTree(int n){
            length = n+1;

            prefix = new long[length];
            suffix = new long[length];
        }

        public void update1(int index, long value){

            while(index<length){
                prefix[index] += value;
                int temp = index&(index-1);
                index <<= 1;
                index -= temp;
            }
        }

        public void update2(int index, long value){

            while(index<length){

                suffix[index] += value;
                int temp = index&(index-1);
                index <<= 1;
                index -= temp;
            }
        }

        public long prefixSum(int index){

            long sum = 0;
            while(index>0){
                sum += prefix[index];
                index = index&(index-1);
            }
            return sum;
        }

        public long suffixSum(int index){

            long sum = 0;
            while(index>0){
                sum += suffix[index];
                index = index&(index-1);
            }
            return  sum;
        }
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