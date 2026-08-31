import java.util.Map;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Collection;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {

    Set<Long> allowed;
    Map<Long, Integer> distance;

    int[] dx = new int[]{-1,-1,-1,0,0,1,1,1};
    int[] dy = new int[]{-1,0,1,-1,1,-1,0,1};


    public void solve(int testNumber, InputReader jin, PrintWriter jout) {
        int x0 = jin.int32();
        int y0 = jin.int32();

        int x1 = jin.int32();
        int y1 = jin.int32();

        long start = convertToLong(x0, y0);
        long target = convertToLong(x1, y1);

        allowed = new HashSet<Long>();
        distance = new HashMap<Long, Integer>();

        int n = jin.int32();
        for(int i = 0; i < n; i++) {
            int row = jin.int32();
            int cols = jin.int32();
            int cole = jin.int32();
            for(int j = cols; j <= cole; j++) {
                allowed.add(convertToLong(row, j));
            }
        }

        Queue<Long> que = new LinkedList<Long>();
        que.add(start);
        distance.put(start, 0);
        while(!que.isEmpty()) {
            long curr = que.poll();
            if(curr == target) {
                break;
            }
            int[] coords = convertToIntArr(curr);
            for(int k = 0; k < dx.length; k++) {
                int nx = coords[0] + dx[k];
                int ny = coords[1] + dy[k];

                long np = convertToLong(nx, ny);
                if(!allowed.contains(np)) continue;
                if(distance.containsKey(np)) continue;
                que.add(np);
                distance.put(np, distance.get(curr) + 1);
            }
        }

        if(distance.containsKey(target)) {
            jout.println(distance.get(target));
        } else {
            jout.println(-1);
        }

    }

    private int[] convertToIntArr(long curr) {
        long mask = (1L << 32) - 1;
        int ny = (int)(curr & mask);
        int nx = (int)((curr >> 32) & mask);
        return new int[]{nx, ny};
    }

    private long convertToLong(int nx, int ny) {
        return ((1L * nx) << 32) | ny;
    }
}

class InputReader {
    private static final int bufferMaxLength = 1024;
    private InputStream in;
    private byte[] buffer;
    private int currentBufferSize;
    private int currentBufferTop;
    private static final String tokenizers = " \t\r\f\n";

    public InputReader(InputStream stream) {
        this.in = stream;
        buffer = new byte[bufferMaxLength];
        currentBufferSize = 0;
        currentBufferTop = 0;
    }

    private boolean refill() {
        try {
            this.currentBufferSize = this.in.read(this.buffer);
            this.currentBufferTop = 0;
        } catch(Exception e) {}
        return this.currentBufferSize > 0;
    }

    public String line() {
        StringBuffer tok = new StringBuffer();
        Byte first;
        while((first = readChar()) != null) {
            tok.append((char)first.byteValue());
            if((char)first.byteValue() == '\n')
                break;
        }
        return tok.toString();
    }

    public Byte readChar() {
        if(currentBufferTop < currentBufferSize) {
            return this.buffer[this.currentBufferTop++];
        } else {
            if(!this.refill()) {
                return null;
            } else {
                return readChar();
            }
        }
    }

    public String token()  {
        StringBuffer tok = new StringBuffer();
        Byte first;
        while((first = readChar()) != null && (tokenizers.indexOf((char) first.byteValue()) != -1));
        if(first == null) return null;
        tok.append((char)first.byteValue());
        while((first = readChar()) != null && (tokenizers.indexOf((char) first.byteValue()) == -1)) {
            tok.append((char)first.byteValue());
        }
        return tok.toString();
    }


    public String next() {
        return token();
    }

    public Integer int32() throws NumberFormatException {
        String tok = token();
        return tok == null? null : Integer.parseInt(tok);
    }

    public Long int64() throws NumberFormatException {
        String tok = token();
        return tok == null? null : Long.parseLong(tok);
    }
}

