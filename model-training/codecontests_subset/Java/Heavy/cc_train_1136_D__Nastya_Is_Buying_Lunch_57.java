import javafx.util.*;
import java.util.*;
import java.io.*;

public class Prg6 {

    Random rnd = new Random();
    PrintWriter pw = new PrintWriter(System.out);
    HashSet<Integer>[] l;
    int[] p, s;
    int a;

    void run(){
        a = ni();
        l = new HashSet[a];
        for(int q=0; q<a; q++) l[q] = new HashSet<>();
        TreeSet<Integer> t = new TreeSet<>();
        int  k =ni();
        p = new int[a];
        for(int q=0; q<a; q++) p[q] = ni()-1;
        int n=  p[a-1];
        for(int q=0; q<k; q++){
            int x = ni()-1, y = ni()-1;
            l[x].add(y);
        }
        for(int q=0; q<a-1; q++) if(l[p[q]].contains(p[q+1])) t.add(q);
        for(; t.size()>0; ){
            int i = t.pollLast();
            if(l[p[i]].contains(p[i+1])){
                l[p[i]].remove(p[i+1]);
                l[p[i+1]].remove(p[i]);
                p[i]^=p[i+1]^=p[i];
                p[i+1]^=p[i];
                if(i+2<a){
                    if(l[p[i+1]].contains(p[i+2])) t.add(i+1);
                }
                if(i>0){
                    if(l[p[i-1]].contains(p[i])) t.add(i-1);
                }
            }
        }
        //for(int u : p) System.out.print(u+" ");System.out.println();
        int o = 0;
        for(int q=a-1; q>=0 && p[q]!=n; q--) o++;
        pw.print(o);
        pw.flush();
    }

    static class PyraSort {

        private static int heapSize;

        public static void sort(int[] a) {
            buildHeap(a);
            while (heapSize > 1) {
                swap(a, 0, heapSize - 1);
                heapSize--;
                heapify(a, 0);
            }
        }

        private static void buildHeap(int[] a) {
            heapSize = a.length;
            for (int i = a.length / 2; i >= 0; i--) {
                heapify(a, i);
            }
        }

        private static void heapify(int[] a, int i) {
            int l = 2 * i + 2;
            int r = 2 * i + 1;
            int largest = i;
            if (l < heapSize && a[i] < a[l]) {
                largest = l;
            }
            if (r < heapSize && a[largest] < a[r]) {
                largest = r;
            }
            if (i != largest) {
                swap(a, i, largest);
                heapify(a, largest);
            }
        }

        private static void swap(int[] a, int i, int j) {
            a[i] ^= a[j] ^= a[i];
            a[j] ^= a[i];
        }
    }

    public static void main(String[] args) {
        new Prg6().run();
    }

    InputStream is = System.in;
    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;

    private int readByte()
    {
        if(lenbuf == -1)throw new InputMismatchException();
        if(ptrbuf >= lenbuf){
            ptrbuf = 0;
            try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
            if(lenbuf <= 0)return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
    private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }

    private double nd() { return Double.parseDouble(ns()); }
    private char nc() { return (char)skip(); }

    private String ns()
    {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceChar(b))){
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private String nline(){
        int b = readByte();
        StringBuilder sb = new StringBuilder();
        while (b!=10) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n)
    {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while(p < n && !(isSpaceChar(b))){
            buf[p++] = (char)b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private char[][] nm(int n, int m)
    {
        char[][] map = new char[n][];
        for(int i = 0;i < n;i++)map[i] = ns(m);
        return map;
    }

    private int[] na(int n)
    {
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = ni();
        return a;
    }

    private int ni()
    {
        int num = 0, b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }
        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long nl()
    {
        long num = 0;
        int b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }
        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
}