import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import javax.swing.*;
import java.awt.*;


public class Main {

    //StreamTokenizer in;
    BufferedReader in;
    PrintWriter out;

    public static void main(String args[]) throws IOException {
        new Main().run();
    }

    char[] line;
    int pos;
    int number;


    public int ni() throws IOException {
        number = 0;
        while(pos < line.length && (!Character.isDigit(line[pos]) && line[pos] != '-')) pos++;
        if(pos == line.length) {
            if(in.ready()) line = in.readLine().toCharArray();
            pos = 0;
        }
        boolean sign = (pos < line.length) ? line[pos] == '-' : false;
        if(line[pos] == '-') pos++;
        while(pos < line.length && Character.isDigit(line[pos])) {
            number *= 10;
            number += line[pos] - '0';
            pos++;
        }
        return sign ? -number : number;
    }

    public void run() throws IOException {

        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        //in = new StreamTokenizer(new BufferedReader(new FileReader("input.txt")));
        //in = new BufferedReader(new FileReader("input.txt"));
        //out = new PrintWriter(new FileWriter("output.txt"));

        solve();

        out.flush();
    }

    void solve2() throws IOException {
        line = in.readLine().toCharArray();
        pos = 0;
        int a = ni(), b = ni(), c = ni();
        c = -c;
        int[] x = new int[3];
        x = gcde(a, b);
        int d = x[2];
        if(c % d != 0) out.print(-1);
        else {
            long x1 = x[0], y1 = x[1];
            BigInteger x1b = new BigInteger(Long.toString(x1));
            BigInteger y1b = new BigInteger(Long.toString(y1));
            x1b =x1b.multiply(new BigInteger(Integer.toString(c)));
            x1b = x1b.divide(new BigInteger(Integer.toString(d)));
            y1b =y1b.multiply(new BigInteger(Integer.toString(c)));
            y1b = y1b.divide(new BigInteger(Integer.toString(d)));
            if(x1b.compareTo(new BigInteger("-5000000000000000000")) < 0 || x1b.compareTo(new BigInteger("5000000000000000000")) > 0) {
                out.print(-1); return;
            }
            if(y1b.compareTo(new BigInteger("-5000000000000000000")) < 0 || y1b.compareTo(new BigInteger("5000000000000000000")) > 0) {
                out.print(-1); return;
            }
            out.print(x1b); out.print(" ");
            out.print(y1b);
        }
    }

    int[] gcde(int a, int b) {
        if(a == 0) {
            return new int[] {0, 1, b};
        }
        if(b == 0) {
            return new int[] {1, 0, a};
        }
        int[] t = gcde(b%a, a);
        int[] x = new int[3];
        x[0] = t[1] - t[0]*(b/a);
        x[1] = t[0];
        x[2] = t[2];
        return x;
    }

    void solve() throws IOException {
        line = in.readLine().toCharArray();
        pos = 0;
        int t = ni();
        int m = ni();
        boolean[] usedNum = new boolean[t+1];
        int[] to = new int[t + 1];
        int lastU = 0;
        int[] leftNum = new int[t + 1];
        int[] rightNum = new int[t + 1];
        boolean[] usedByte = new boolean[m];
        for(int i = 0; i < t; i++) {
            line = in.readLine().toCharArray();
            pos = 0;
            switch(line[0]) {
                case 'a' :
                    int n = ni();
                    int j = 0;
                    while(true) {
                        for(; j < m; j++)
                            if(!usedByte[j]) break;
                        if(m - j < n) {
                            out.println("NULL");
                            break;
                        }
                        else {
                            boolean ok = true;
                            int k = 0;
                            for(; j < m && k < n && ok; k++, j++)
                                if(usedByte[j]) {
                                    ok = false;
                                    j--; k--;
                                }
                            if(ok) {
                                        out.println(++lastU);
                                        usedNum[lastU] = true;
                                        int num = lastU;
                                        usedNum[num] = true;
                                        rightNum[num] = j-1;
                                        leftNum[num] = j-n;
                                        for(int q = leftNum[num]; q <= rightNum[num]; q++)
                                            usedByte[q] = true;

                                break;
                            }
                        }
                    }
                    break;
                case 'e' :
                    int er = ni();
                    if(er >= t + 1 || er < 1 || !usedNum[er]) out.println("ILLEGAL_ERASE_ARGUMENT");
                    else {
                        for(j = leftNum[er]; j <= rightNum[er]; j++)
                            usedByte[j] = false;
                        usedNum[er] = false;
                    }
                    break;
                case 'd' :
                    int last = 0;
                    for(j = 0; j < m; j++) {
                        if(usedByte[j]) {
                            usedByte[j] = false;                            
                            usedByte[last++] = true;
                            for(int k = 1; k <= t; k++) {
                                if(usedNum[k]) {
                                    if(leftNum[k] == j) leftNum[k] = last-1;
                                    if(rightNum[k] == j) rightNum[k] = last-1;
                                }
                            }
                        }
                    }
            }
        }
    }
}
