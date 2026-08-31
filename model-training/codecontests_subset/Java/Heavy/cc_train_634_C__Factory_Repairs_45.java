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
        SegmentTree st1 = new SegmentTree(orders1);
        SegmentTree st2 = new SegmentTree(orders2);
        for(int i=0; i<q; ++i){
            int type  = in.readInt();
            if(type==1){
                int d = in.readInt();
                int o = in.readInt();
                if(orders1[d]+o<=b){
                    orders1[d] += o;
                    st1.update(d,o);
                }
                else{
                    st1.update(d,b-orders1[d]);
                    orders1[d] = b;
                }
                if(orders2[d]+o<=a){
                    orders2[d] += o;
                    st2.update(d,o);
                }
                else{
                    st2.update(d,a-orders2[d]);
                    orders2[d] = a;
                }
            }
            else{
                int p = in.readInt();
                long result = st1.rangeSum(0,p-1);
                result = result+st2.rangeSum(p+k,n);
                out.println(result);
            }
        }

    }



    public static void main(String[] args) throws Exception {
        solve();
        out.close();
    }

    private static class SegmentTree {
        Node[] heap;
        long[] elements;
        int size;
        public SegmentTree(long[] a) {
            int n = a.length;
            if((n&(n-1))==0){
                size = n;
            }
            else{
                size = 1;
                while(n!=0){
                    n >>=1;
                    size <<=1;
                }
            }
            elements = Arrays.copyOf(a,size);
            heap = new Node[2*size];
            build(1,0,size);
        }

        void build(int v, int start, int size){
            heap[v]= new Node(start,size);
            if(size==1){
                heap[v].sum = elements[start];
                return;
            }
            else{
                build(2*v,start,size/2);
                build(2*v+1,start+size/2,size/2);
            }
            heap[v].sum = heap[2*v].sum+heap[2*v+1].sum;
        }


        public long rangeSum(int from, int to){
            return  rangeSum(1,from,to);
        }

        private long rangeSum(int v, int from, int to){
            Node n = heap[v];
            if(n.to<from||(n.from>to)){
                return 0;
            }
            if(n.from>=from&&n.to<=to){
                return n.sum;
            }
            long left = rangeSum(2*v,from,to);
            long right = rangeSum(2*v+1, from,to);
            return left+right;
        }

        public void update(int index, long value){
            update(1,index,value);
            elements[index] += value;
        }

        private void update(int v, int index, long value){
            Node n = heap[v];
            if((index>=n.from)&&(index<=n.to)) {
                n.sum += value;
                if (n.size == 1) {
                    return;
                }
                update(2 * v, index, value);
                update(2 * v + 1, index, value);
            }
        }

        private static class Node{
            int from,to,size;
            long sum = 0;
            Node(int from, int size){
                this.from = from;
                this.size = size;
                to = from+size-1;
            }

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