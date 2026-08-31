
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MojtabaPC
 */
public class Main {

    /**
     * @param args the command line arguments
     *
     */

    public static void main(String[] args) throws IOException {
        //Scanner in = new Scanner(System.in);
        FastScanner in = new FastScanner((InputStream) System.in);
        //Scanner in=new Scanner(System.in);
        int[] coins=new int[3];
        int n=in.nextInt();
        int sum=0;
        for(int i=0 ; i<n ; i++){
            int temp=in.nextInt();
            sum += temp;
            coins[temp / 100]++;
            
        }
        System.err.println("100: " + coins[1]+ "\t200: "+ coins[2]+ "\tsum: "+sum);
        if(poolkhord(sum/2,coins) && poolkhord(sum/2,coins)){
            System.out.println("YES");
        }
        else{
        System.out.println("NO");}
    }

    private static boolean poolkhord(int n, int[] coins) {
        for(int i=coins.length-1 ; i>=0 ; i--){
            while(coins[i]>0 && n>=(i*100)){
                n-=(i*100);
                coins[i]--;
            }
        }
        return n==0;
    }
}
class FastScanner {

    private InputStream stream;
    private byte[] buffer = new byte[1024];
    private int curChar;
    private int numChars;

    public FastScanner(InputStream stream) {
        this.stream = stream;
    }

    int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buffer);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buffer[curChar++];
    }

    boolean isWhiteSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    boolean isEndline(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String next() {
        int c = read();
        while (isWhiteSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isWhiteSpaceChar(c));
        return res.toString();
    }

    String nextLine() {
        int c = read();
        while (isEndline(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndline(c));
        return res.toString();
    }
}
