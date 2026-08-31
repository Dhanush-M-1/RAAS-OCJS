import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ConsoleIO io = new ConsoleIO();
        new Main(io).solve();
        io.flush();
    }

    ConsoleIO io;

    Main(ConsoleIO io) {
        this.io = io;
    }

    public void solve() {
        int n  = Integer.parseInt(io.readLine());
        long px = Integer.MIN_VALUE;
        int res = 0;

        long[] xs = new long[n];
        long[] hs = new long[n];
        for(int i = 0;i<n;i++){
            int[] a = io.readIntArray();
            xs[i] = a[0];
            hs[i] = a[1];
        }
        for(int i = 0 ;i<n;i++){
            long x = xs[i], h = hs[i];
            if(x-h>px){
                res++;
                px = x;
            }
            else if(i==n-1 || x+h<xs[i+1]) {
                res++;
                px = x + h;
            }else{
                px = x;
            }
        }
        io.writeLine(""+res);
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

