import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[]args){ConsoleIO io=new ConsoleIO();new Main(io).solve();io.flush();}
    ConsoleIO io;
    Main(ConsoleIO io) {this.io = io;}

    public void solve() {
        int n = io.readInt();
        char[] c = io.readLine().toCharArray();
        for (int s = 1; s < 28; s++) {
            for (int q = 0; q + s + s + s + s < c.length; q++) {
                if (c[q] == '*' && c[q + s] == '*' && c[q + s + s] == '*' && c[q + s + s + s] == '*' && c[q + s + s + s + s] == '*') {
                    io.writeLine("yes");
                    return;
                }
            }
        }
        io.writeLine("no");
    }

}

class ConsoleIO {
    BufferedReader br;
    PrintWriter out;
    public ConsoleIO(){br = new BufferedReader(new InputStreamReader(System.in));out = new PrintWriter(System.out);}
    public void flush(){
        this.out.close();
    }
    public void writeLine(String s) {
        this.out.println(s);
    }
    public void writeInt(int a) {this.out.print(a);this.out.print(' ');}
    public void writeWord(String s){
        this.out.print(s);
    }
    public String readLine() {try {return br.readLine();}catch (Exception ex){ return "";}}
    public long readLong() {
        return Long.parseLong(this.readLine());
    }
    public int readInt() {
        return Integer.parseInt(this.readLine());
    }
    public int[] readIntArray() {
        String[]n=this.readLine().split(" ");int[]r=new int[n.length];
        for(int i=0;i<n.length;i++)r[i]=Integer.parseInt(n[i]);
        return r;
    }
}

