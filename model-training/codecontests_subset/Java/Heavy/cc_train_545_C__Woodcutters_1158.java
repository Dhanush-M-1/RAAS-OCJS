/**
 * Created by Grand on 27.07.2015.
 */

import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main implements Runnable {

    final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    public static void main(String[] args) {
        new Thread(null, new Main(), "", 128 * (1L << 20)).start();

    }

    void init() throws FileNotFoundException {
        Locale.setDefault(Locale.US);
        if(ONLINE_JUDGE){
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }else {
            in = new BufferedReader(new FileReader("INPUT.TXT"));
            out = new PrintWriter("OUTPUT.TXT");
        }
    }

    long timeBegin, timeEnd;

    void time() {
        timeEnd = System.currentTimeMillis();
        System.err.println("Time = " + (timeEnd - timeBegin));
    }

    public void run() {
        try {
            timeBegin = System.currentTimeMillis();

            init();
            solve();

            out.close();
            time();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(-1);
        }
    }


    String readString() throws IOException {

        while (!tok.hasMoreTokens()) {
            try {
                tok = new StringTokenizer(in.readLine());
            } catch (Exception e) {
                return null;
            }
        }
        return tok.nextToken();
    }

    String readString(String s) throws IOException {
        while (!tok.hasMoreTokens()) {
            try {
                tok = new StringTokenizer(in.readLine(), s + "\n \t");
            } catch (Exception e) {
                return null;
            }
        }
        return tok.nextToken();
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    int readInt(String s) throws IOException {
        return Integer.parseInt(readString(s));
    }

    boolean isPrime(int a) throws IOException {
        int del = 0;
        if (a == 2) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(a) + 1; i++) {
            if (a % i == 0) {
                del = i;
                break;
            }
        }
        if (del > 0) {
            return false;
        } else return true;
    }


    public long factorial(int num) throws IOException {
        long res = 1;
        for (int i = 2; i <= num; i++) {
            res *= i;
        }
        return res;
    }
    public int[] readIntArr(int n) throws IOException {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = readInt();
        }
        return a;
    }

    void solve() throws Exception{
        int n=readInt();

        int[] x = new int[n];
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            x[i]=readInt();
            h[i]=readInt();
        }
        if(n==1){
            System.out.println(1);
            return;
        }
        boolean pred = false;
        int count = 1;
        for (int i = 1; i < n-1; i++) {
            if(x[i]-x[i-1]>h[i]){
                count++;
            }else{
                    if(x[i+1]-x[i]>h[i]){
                        x[i]=x[i]+h[i];
                        count++;
                    }
            }
        }
        count++;
        System.out.println(count);



    }



    





}
