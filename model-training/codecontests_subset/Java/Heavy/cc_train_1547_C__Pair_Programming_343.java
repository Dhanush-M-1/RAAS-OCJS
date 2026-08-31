// Problem: C. Pair Programming
// Contest: Codeforces - Codeforces Round #731 (Div. 3)
// URL: https://codeforces.com/contest/1547/problem/C
// Memory Limit: 512 MB
// Time Limit: 2000 ms

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
  static class InputReader {
    final private int BUFFER_SIZE = 1 << 16;

    private final DataInputStream din;

    private final byte[] buffer;

    private int bufferPointer, bytesRead;

    public InputReader() {
      din = new DataInputStream(System.in);
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
    }

    private void fillBuffer() throws IOException {
      bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
      if (bytesRead == -1)
        buffer[0] = -1;
    }

    private byte read() throws IOException {
      if (bufferPointer == bytesRead)
        fillBuffer();
      return buffer[bufferPointer++];
    }

    public void close() throws IOException {
      if (din == null)
        return;
      din.close();
    }

    public int nextInt() throws IOException {
      int ret = 0;
      byte c = read();
      while (c <= ' ') c = read();
      final boolean neg = c == '-';
      if (neg)
        c = read();
      do ret = ret * 10 + c - '0';
      while ((c = read()) >= '0' && c <= '9');
      if (neg)
        return -ret;
      return ret;
    }
  }
  static String getSeq(int k, int al, int bl, int[] a, int[] b) {
    StringBuilder sb = new StringBuilder();
    int ai = 0, bi = 0;
    int[] seq = new int[al + bl];
    int j = 0;
    while (ai < al && bi < bl) {
      if (a[ai] == 0) {
        seq[j++] = a[ai++];
        k++;
      } else if (b[bi] == 0) {
        seq[j++] = b[bi++];
        k++;
      } else if (a[ai] <= k) {
        seq[j++] = a[ai++];
      } else if (b[bi] <= k) {
        seq[j++] = b[bi++];
      } else
        return "-1";
    }
    while (ai < al) {
      if (a[ai] == 0) {
        seq[j++] = a[ai++];
        k++;
      } else if (a[ai] <= k) {
        seq[j++] = a[ai++];
      } else
        return "-1";
    }
    while (bi < bl) {
      if (b[bi] == 0) {
        seq[j++] = b[bi++];
        k++;
      } else if (b[bi] <= k) {
        seq[j++] = b[bi++];
      } else
        return "-1";
    }
    for (int e : seq) {
      sb.append(e).append(' ');
    }
    return sb.toString();
  }
  public static void main(final String args[]) throws Exception {
    final InputReader sc = new InputReader();
    final PrintWriter out = new PrintWriter(System.out);
    int n = sc.nextInt();
    while (n-- > 0) {
      int k = sc.nextInt();
      int al = sc.nextInt();
      int bl = sc.nextInt();
      int[] a = new int[al];
      int[] b = new int[bl];
      for (int i = 0; i < al; i++) a[i] = sc.nextInt();
      for (int i = 0; i < bl; i++) b[i] = sc.nextInt();
      out.println(getSeq(k, al, bl, a, b));
    }
    out.flush();
  }
}