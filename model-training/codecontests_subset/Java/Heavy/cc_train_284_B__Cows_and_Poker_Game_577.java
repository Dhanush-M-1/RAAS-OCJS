

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Artem_Mikhalevitch
 */
public class Main extends ASolver {

    int n;
    String str;

    public static void main(String[] args) throws ParseException {

        Main s = new Main();
        s.init();

        if (s.readData()) {
            //s.solve();
            s.writeData("" + s.solve());
        }
        

    }

    @Override
    public void init() {
        super.init();

    }

    @Override
    public boolean readData() {
        try {
            n = nextInt();
            str=next();

        } catch (Exception ex) {
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public double[] sort(double[] mas1, double[] mas2) {
        int l1 = mas1.length;
        int l2 = mas2.length;
        double[] result = new double[l1 + l2];
        int i1 = 0, i2 = 0;
        int i = 0;
        for (i = 0; i1 < l1 && i2 < l2; i++) {
            if (mas1[i1] <= mas2[i2]) {
                result[i] = mas1[i1++];
            } else {
                result[i] = mas2[i2++];
            }
        }
        for (int j = i; i1 < l1; j++) {
            result[j] = mas1[i1++];
        }
        for (int j = i; i2 < l2; j++) {
            result[j] = mas2[i2++];
        }
        return result;
    }

    public long solve() {
        long resultA =0;
        long resultI =0;
        for(int i=0;i<n;i++){
            if(str.charAt(i)=='I'){
                resultI++;
                if(resultI>1){
                    return 0;
                }
            }else if(str.charAt(i)=='A'){
            resultA++;
            }
        }
        if(resultI==1){
            return 1;
        }else{
            return resultA;
        }
    }

    public long sum(List<Integer> listForSum) {
        long result = 0;
        int size = listForSum.size();
        for (int i = 0; i < size; i++) {
            result += listForSum.get(i);
        }
        return result;
    }
}

abstract class ASolver {

    protected StringTokenizer tokens;
    protected BufferedReader input;
    protected PrintWriter output;

    public void init() {
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    public abstract boolean readData();

    public void writeData(String result) {
        System.out.println(result);
    }

    public void writeData(int result) {
        System.out.println(result);
    }

    public void writeData(long result) {
        System.out.println(result);
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public String next() throws IOException {
        while (tokens == null || !tokens.hasMoreTokens()) {
            tokens = new StringTokenizer(input.readLine());
        }
        return tokens.nextToken();
    }

    public String nextLine() throws IOException {
        while (tokens == null || !tokens.hasMoreTokens()) {
            tokens = new StringTokenizer(input.readLine(), "\n");
        }
        return tokens.nextToken();
    }

    public long infinityImitator(long a, long b) {
        if (a == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        } else {
            return a + b;
        }
    }

    public int infinityImitator(int a, int b) {
        if (a == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return a + b;
        }
    }

    /*
     * public long max(long... a) { long result = Long.MIN_VALUE; for (int i =
     * 0; i < a.length; i++) { result = Math.max(result, a[i]); } return result;
     * }
     */
    public int indexMax(int... a) {
        int result = 0;
        int index = -1;
        int length = a.length;
        for (int i = 0; i < length; i++) {
            if (a[i] > result) {
                result = a[i];
                index = i;
            }
        }
        return index;
    }

    public int indexMax(long... a) {
        long result = 0;
        int index = -1;
        int length = a.length;
        for (int i = 0; i < length; i++) {
            if (a[i] > result) {
                result = a[i];
                index = i;
            }
        }
        return index;
    }

    public int max(int... a) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            result = Math.max(result, a[i]);
        }
        return result;
    }

    public long max(long... a) {
        long result = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            result = Math.max(result, a[i]);
        }
        return result;
    }
}

class ABSComparator implements Comparator<Pair> {

    /**
     * Compares its two arguments for order. Returns a negative integer, zero,
     * or a positive integer as the first argument is less than, equal to, or
     * greater than the second.
     */
    @Override
    public int compare(Pair o1, Pair o2) {
        if (o1.getA() == o2.getA()) {
            return o2.getB() - o1.getB();
        }
        return o1.getA() - o2.getA();
    }
}

class Pair {

    int a;
    int b;
    int pos;

    public Pair() {
    }

    public Pair(int a, int b, int pos) {
        this.a = a;
        this.b = b;
        this.pos = pos;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getPos() {
        return pos;
    }
}

class ABSComparatorDesc implements Comparator<Pair> {

    /**
     * Compares its two arguments for order. Returns a negative integer, zero,
     * or a positive integer as the first argument is less than, equal to, or
     * greater than the second.
     */
    @Override
    public int compare(Pair o1, Pair o2) {
        if (o2.getB() == o1.getB()) {
            return o1.getA() - o2.getA();
        }
        return o2.getB() - o1.getB();
    }
}