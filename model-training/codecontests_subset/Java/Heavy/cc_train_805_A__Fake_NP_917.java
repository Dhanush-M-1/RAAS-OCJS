/**
 * Created by Karan Jobanputra on 27-03-2017.
 */

import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;

import static java.lang.Math.*;

public class Main {
    static class InputReader {
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

        public String nextLine() {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public int nextInt() {
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
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong() {
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
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
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
            }
            while (!isSpaceChar(c));

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

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    static class Node implements Comparable<Node> {
        int u;
        int v;
        int w;

        Node(int u,int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        public int compareTo(Node node) {
            if(this.u==node.u && this.v == node.v && this.w == node.w) return 0;
            else return 1;
        }
    }

    static long gcd(long a,long b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
    static void initialize(int arr[],int size[])
    {
        for(int i=1;i<arr.length;i++)
        {
            arr[i] = i;
            size[i] = 1;
        }
    }
    static void union(int arr[],int size[],int a,int b)
    {
        int root_a = root(arr,a);
        int root_b = root(arr,b);
        if(root_a != root_b)
        {
            if(size[root_a]<size[root_b])
            {
                arr[root_a] = root_b;
                size[root_b] += size[root_a];
                size[root_a] = -1;
            }
            else
            {
                arr[root_b] = root_a;
                size[root_a] += size[root_b];
                size[root_b] = -1;
            }
        }
    }
    static int root(int arr[],int i)
    {
        while(i != arr[i])
        {
            arr[i] = arr[arr[i]];
            i = arr[i];
        }
        return i;
    }
    public static void main(String args[]) throws Exception {
        InputReader sc = new InputReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int l = sc.nextInt();
        int r = sc.nextInt();

        if(l==r) pw.println(l);
        else pw.println("2");

        pw.close();
    }


}