import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
public class Main {
    private static Reader scn = new Reader();
    private static BufferedOutputStream out = new BufferedOutputStream(System.out);
    private static final int delta = (int) 1e9 + 7;
    
    private static class Reader {
        
        final private int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;
        
        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        
        public String readLine() throws IOException {
            byte[] buf = new byte[1024];
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n' || c == ' ') {
                    break;
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
        
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            
            if (neg) {
                return -ret;
            }
            return ret;
        }
        
        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) {
                return -ret;
            }
            return ret;
        }
        
        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            
            if (neg) {
                return -ret;
            }
            return ret;
        }
        
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }
        
        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }
        
        public void close() throws IOException {
            if (din == null) {
                return;
            }
            din.close();
        }
        
        public int[] nextArray(int n) throws IOException {
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
    }
    private static void print(Object str) {
        try {
            out.write(str.toString().getBytes());
        } catch (IOException e) {
        }
    }
    private static void println(Object str) {
        try {
            out.write((str.toString() + "\n").getBytes());
        } catch (IOException e) {
        }
    }
    
    public static void main(String args[] ) throws Exception {
        int t = scn.nextInt();
        while(t-->0){
            int a = scn.nextInt();
            int b = scn.nextInt();
            int c = scn.nextInt();
            int c1=0,c2=0;
            if(a<=b/2){
                c1+=3*a;
                b-=2*a;
                if(b>0&&c>1){
                    if(b<=c/2){
                        c1+=3*b;
                    }else{
                        if(c%2==0)
                            c1+=3*c/2;
                        else
                            c1+=3*(c-1)/2;
                    }
                }
                b+=2*a;
            }else{
                if(b%2==0)
                    c1+=3*b/2;
                else
                    c1+=3*(b-1)/2;
            }
            if(b<=c/2){
                c2+=3*b;
            }else{
                if(c%2==0)
                    c2+=3*(c/2);
                else
                    c2+=3*(c-1)/2;
                b-=c/2;
                if(a<=b/2){
                    c2+=3*a;
                } else {
                    if (b % 2 == 0) {
                        c2 += 3 * b / 2;
                    } else {
                        c2 += 3 * (b - 1) / 2;
                    }
                }
            }
            //println(c1+" "+c2);
            println(Math.max(c1,c2));
        }
        out.flush();
    }
}
