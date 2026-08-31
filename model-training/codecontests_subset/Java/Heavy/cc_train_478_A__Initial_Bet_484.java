import java.io.*;
import java.math.BigInteger;
import java.util.Locale;
import java.util.StringTokenizer;

public class A implements Runnable {

    final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    public static void main(String[] args) {
        new Thread(null, new A(), "", 128 * (1L << 20)).start();

    }

    void init() throws FileNotFoundException {
        Locale.setDefault(Locale.US);

        if (ONLINE_JUDGE) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
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
        int del=0;
        if(a==2){
            return false;
        }
        for(int i=2;i<Math.sqrt(a)+1;i++){
            if(a%i==0){
                del=i;
                break;
            }
        }
        if(del>0){
            return false;
        }
        else return true;
    }

    public long factorialmin(int num) throws IOException {
        long fact = 1;
        for (int j=1;j<=num;j++) {
            fact = fact*j;
        }
        return fact;
    }


    public BigInteger factorialbig(int num) throws IOException {
        BigInteger fact = new BigInteger("1");
        BigInteger i = new BigInteger("1");
        BigInteger one = new BigInteger("1");
        for (int j=0;j<num;j++) {
            fact = fact.multiply(i);
            i=i.add(one);
            //out.println(fact.toString()+" "+i.toString());
        }
        //fact = fact.add(one);

        return fact;
    }

    public int[] readIntArr(int n) throws IOException{
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = readInt();
        }
        return a;
    }



    void solve() throws IOException{

        int res=0;

        for(int i=0;i<5;i++){
            res+=readInt();

        }
        if(res%5==0 && res!=0){
            out.println(res/5);
        }
        else{
            out.println("-1");
        }

    }

    public long fn(long n) throws IOException{
        return 0;
    }





  }
