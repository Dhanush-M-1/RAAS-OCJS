

import java.io.*;

public class Main {
    private final Reader reader;

    private final Writer writer;

    public static void main(String[] args) throws IOException {
        new Main().solve();

    }

    private void solve() throws IOException {
        int coins[] = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            coins[i] = reader.nextUnsignedInt();
            sum += coins[i];
        }

        if (sum % 5 != 0 || sum == 0) {
            writer.print("-1\n");
            writer.flush();
            return;
        }

        writer.print(sum / 5 + "\n");
        writer.flush();
    }

    Main(InputStream in, OutputStream out) {
        this.reader = new Reader(in);
        this.writer = new Writer(out);
    }

    public Main() {
        this.reader = new Reader();
        this.writer = new Writer();
    }


}

class Reader {

    private final int BUFFER_SIZE = 65536;

    private final DataInputStream din;

    private final byte[] buffer;

    private int bufferPointer, bytesRead;

    Reader() {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader(InputStream in) {
        din = new DataInputStream(in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public long nextUnsignedLong() throws IOException {
        long ret = 0;
        byte c = read();
        while (c <= 32) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0');
        return ret;
    }

    public int nextUnsignedInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= 32) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0');
        return ret;
    }

    public int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) {
            c = read();
        }
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0');
        if (neg) {
            return -ret;
        }
        return ret;
    }

    public String nextString(int MAX) throws IOException {
        int cnt = 0;
        char[] buf = new char[MAX];
        byte c;
        while ((c = read()) < 33) ;
        buf[cnt++] = (char) c;
        while ((c = read()) >= 33) {
            buf[cnt++] = (char) c;
        }
        return new String(buf, 0, cnt);
    }

    public char firstCharOfNextUnSpacedString() throws IOException {
        byte c;
        char res;
        while ((c = read()) < 33) ;
        res = (char) c;
        while ((c = read()) >= 33) ;
        return res;
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
}

class Writer {
    private final BufferedWriter out;

    Writer() {
        out = new BufferedWriter(new OutputStreamWriter(System.out), 512);
    }

    public Writer(OutputStream out) {
        this.out = new BufferedWriter(new OutputStreamWriter(out), 512);
    }

    void print(char c) throws IOException {
        out.write(c);
    }

    void print(String str) throws IOException {
        out.write(str);
    }

    void println() throws IOException {
        out.write("\n");
    }

    void flush() throws IOException {
        out.flush();
    }

    @Override
    protected void finalize() throws IOException {
        out.flush();
    }
}