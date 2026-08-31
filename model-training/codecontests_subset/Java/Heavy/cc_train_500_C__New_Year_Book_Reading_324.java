import java.io.*;
import java.math.BigInteger;
import java.util.*;

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

            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
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


    public BigInteger bigFactorial(int num) throws IOException {
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

    public long factorial(int num) throws IOException{
        long res=1;
        for(int i=2;i<=num;i++){
            res*=i;
        }
        return res;
    }

    public int[] readIntArr(int n) throws IOException{
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = readInt();
        }
        return a;
    }


    public class Pair implements Comparable{
        long a1;
        long a2;

        public long getA1() {
            return a1;
        }

        public long getA2() {
            return a2;
        }

        public void setA1(int a1) {
            this.a1 = a1;
        }

        public void setA2(int a2) {
            this.a2 = a2;
        }

        @Override
        public int compareTo(Object a) {
            Pair b=(Pair) a;
            if(this.a1>((Pair) a).a1){
                return 1;
            }
            if(this.a1==((Pair) a).a1)
                return 0;
            return -1;
        }
    }

    public class Triple implements Comparable{
        int a1;
        int a2;
        int a3;

        public int getA1() {
            return a1;
        }

        public void setA1(int a1) {
            this.a1 = a1;
        }

        public int getA2() {
            return a2;
        }

        public void setA2(int a2) {
            this.a2 = a2;
        }

        public int getA3() {
            return a3;
        }

        public void setA3(int a3) {
            this.a3 = a3;
        }
        @Override
        public int compareTo(Object a) {
            Triple b=(Triple) a;
            if(this.a1>((Triple) a).a1){
                return 1;
            }
            if(this.a1==((Triple) a).a1)
                return 0;
            return -1;
        }
    }



    void solve() throws IOException{
        int n=readInt();
        int m=readInt();
        int[] w=readIntArr(n);
        int[] pow=readIntArr(m);
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i=0;i<m;i++){
            if(a.indexOf(pow[i])<0) {
                a.add(pow[i]);
            }
        }

        long res=0;
        for(int i=0;i<m;i++){
            int sum=0;
            for(int j=0;j<a.size();j++){
                if(a.get(j)==pow[i]){
                    res+=sum;
                    int del=a.get(j);
                    a.remove(j);
                    a.add(0,del);
                }
                else{
                    sum+=w[a.get(j)-1];
                }
            }
        }
        System.out.println(res);





    }


    public long fn() throws IOException{
        return 0;
    }
}