import sun.reflect.generics.tree.Tree;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;
import java.io.*;




public class Main {
    private static Scanner in;
    private static int all = (1 << 30) - 1;
    private static int read() throws Exception{
        int res = in.nextInt();
        if (res == -2) throw new Exception("recieved " + res);
        return res;
    }
    private static int ask(int a,int b) throws Exception{
        System.out.println("? " + a + " " + b);
        System.out.flush();
        return read();
    }
    public static void main(String[] args) throws Exception {
//        IO io ;
//        try {
//            io = new IO("in.in", null);
//        } catch (IOException e) {
//            io = new IO(null, null);
//        }
        in = new Scanner(System.in);
        boolean [] known = new boolean[30];

        int A = 0,B = 0;
        int done = 0;
        for(int b = 29;b >= 0;) {
            int c = ask(A,B);
            if (c == 0) break;
            while (b >= 0 && ask(A^(1<<b),B^(1<<b)) == c) b--;
            if (b == -1) throw new Exception("fail");
            known[b] = true;
            if (c == 1) A |= 1 << b;
            else B |= 1 << b;
            b--;
        }

        for (int b = 29;b >= 0;b--) if (!known[b]){
            int ma = A ,mb = B ;
            ma ^= 1 << b;
            int res = ask(ma,mb);
            if (res == 0) throw new Exception("O.o");
            if (res == -1) {
                A |= 1 << b;
                B |= 1 << b;
            }
        }
        System.out.println("! " + A + " " + B);
        System.out.flush();
//        io.close();
    }
    private static final int onebillion7 = 1000000007;
}



class Buffer{
    ArrayList<Character> AS;
    public Buffer(){
        AS = new ArrayList<>();
    }
    public void append(String s){
        for (char c : s.toCharArray())
            AS.add(c);
    }
    public void appendLine(String s) {
        append(s);
        AS.add('\n');
    }
    public void clear(){
        AS.clear();
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (char c : AS)
            sb.append(c);
        return sb.toString();
    }
}

class IO{
    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter writer;
    private String inputFile,outputFile;

    public boolean hasMore() throws IOException{
        if(st != null && st.hasMoreTokens()) return true;
        if(br != null && br.ready()) return true;
        return false;
    }

    public String getNext() throws FileNotFoundException, IOException{
        while(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    public String getNextLine() throws FileNotFoundException, IOException{
        return br.readLine().trim();
    }

    public int getNextInt() throws FileNotFoundException, IOException{
        return Integer.parseInt(getNext());
    }
    public long getNextLong() throws FileNotFoundException, IOException{
        return Long.parseLong(getNext());
    }

    public void print(double x,int num_digits) throws  IOException{
        writer.printf("%." + num_digits + "f" ,x);
    }
    public void println(double x,int num_digits) throws  IOException{
        writer.printf("%." + num_digits + "f\n" ,x);
    }
    public void print(Object o) throws  IOException{
        writer.print(o.toString());
    }

    public void println(Object o) throws  IOException{
        writer.println(o.toString());
    }
    public IO(String x,String y) throws FileNotFoundException, IOException{
        inputFile = x;
        outputFile = y;
        if(x != null) br = new BufferedReader(new FileReader(inputFile));
        else br = new BufferedReader(new InputStreamReader(System.in));
        if(y != null) writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
        else writer = new PrintWriter(new OutputStreamWriter(System.out));
    }

    protected void close() throws IOException{
        br.close();
        writer.close();
    }
    public void outputArr(Object [] A) throws IOException{
        int L = A.length;
        for (int i = 0;i < L;i++) {
            if(i > 0) writer.print(" ");
            writer.print(A[i]);
        }
        writer.print("\n");
    }
}