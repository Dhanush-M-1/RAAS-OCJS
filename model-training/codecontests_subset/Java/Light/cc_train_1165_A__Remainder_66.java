//package r560div3;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class A {
    public InputStream in = System.in;
    public PrintStream out = System.out;

    private Scanner scan;

    int n, x, y;
    int []a;
    String s;

    void p(Object value) {
        out.print(value);
    }
    void pln(Object value) {
        out.println(value);
    }

    A() {
        scan = new Scanner(in);
    }

    public A redirectIO(InputStream in, PrintStream out) {
        this.in = in;
        this.out = out;
        scan = new Scanner(in);
        return this;
    }

    public static long test(InputStream inBuffer, PrintStream outBuffer){
        A task = new A().redirectIO(inBuffer, outBuffer);
        long from = System.nanoTime();
        task.run();
        return System.nanoTime() - from;
    }

    public static void main(String[] args) {
        new A().run();
    }

    void run(){
        n = scan.nextInt();
        x = scan.nextInt();
        y = scan.nextInt();
        s = scan.next();

        char c;
        int k = 0;
        for (int i = n-1; i >= 0 ; i--){
            c = s.charAt(i);
            if (n - i <= y && c != '0')
                k++;

            else if (n - i == y+1 && c != '1')
                k++;

            else if (n-i > y+1 && n - i <= x && c != '0')
                k++;

            if (n-i > x)
                break;
        }

        pln(k);
    }
}

