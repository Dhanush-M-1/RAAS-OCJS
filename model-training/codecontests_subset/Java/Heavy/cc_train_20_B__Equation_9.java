/*
 * Author: SKYDOS
 * E-mail: ACSKYDOS@gmail.com
 * SKYPE: sky-dos
 */
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.awt.geom.*;
import static java.lang.Integer.*;
import static java.lang.Long.*;
import static java.lang.Double.*;

public class Main implements Runnable {
    void solve(){
        console(!false);

        long a=Long(), b=Long(), c=Long();

        if(a==0 && b==0 && c==0){
				out.println(-1);
			} else if(a==0 && b==0){
				out.print(0);
			} else if(a==0){
				double x=-(double)c/b;
				out.println(1);
				if (c==0) out.printf("%.10f", 0.0);
				else out.printf("%.10f", x);
			} else {
				long d=b*b-4*a*c;
				if(d<0){
					print(0);
				} else if(d==0){
					println(1);
					if (b==0) out.printf("%.10f", 0.0); else
					out.printf("%.10f", -(double)b/(2*(double)a));
				} else {
					double x1=(-(double)b-sqrt((double)d))/(2*(double)a);
					double x2=(-(double)b+sqrt((double)d))/(2*(double)a);
					println(2);
					out.printf("%.10f\n", min(x1, x2));
					out.printf("%.10f", max(x1, x2));
				}
			}
    }

    StringTokenizer st;
    PrintWriter out;
    BufferedReader br;
    boolean eof = false, in_out = false, std = false;

    public static void main(String[] args) {
        new Thread(new Main()).start();
    }

    void println(Object o){ out.println(o); }
    void print(Object o){ out.print(o); }

    String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return "$";
            }
        }
        return st.nextToken();
    }

    String Line() {
        String ret = "";
        try {
            ret = br.readLine();
        } catch (Exception e) {
            ret = "";
        }
        if (ret == null) {
            eof = true;
            return "$";
        }
        return ret;
    }

    String String() {
        return nextToken();
    }

    int Int() {
        return Integer.parseInt(nextToken());
    }

    long Long() {
        return Long.parseLong(nextToken());
    }

    double Double() {
        return Double.parseDouble(nextToken());
    }

    void console(boolean f){
        if (f){
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new OutputStreamWriter(System.out));
        } else {
            try{
                br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"), "ISO-8859-1"));
                out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("output.txt"), "ISO-8859-1"));
            } catch(Exception e){
                e.printStackTrace();
                System.exit(111);
            }
        }
    }

    public void run() {
        long time = System.currentTimeMillis();
        try{
            solve();
        } catch (Exception e){
            e.printStackTrace();
            System.exit(111);
        }
        System.err.println(System.currentTimeMillis() - time);
        out.close();
    }
}
