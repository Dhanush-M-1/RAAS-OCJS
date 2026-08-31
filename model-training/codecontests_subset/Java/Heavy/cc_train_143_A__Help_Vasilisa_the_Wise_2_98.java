
import java.io.*;
import java.util.*;
import java.math.*;

public class Contest102A implements Runnable {

    
    public void run() {
        int r1 = nextInt();
        int r2 = nextInt();
        int c1= nextInt();
        int c2 = nextInt();
        int d1 = nextInt();
        int d2 = nextInt();
        ArrayList<pair> arr = new ArrayList<pair>();
        for(int i=1; i<10; i++){
            for(int j=1; j<10; j++){
                if(i + j ==r1 ){
                    for(int k=1; k<10; k++){
                        for(int t=1; t<10; t++){
                            if(k+t == r2 && i+k == c1 && j+t ==c2 && i+t == d1 && j+k ==d2){
                                if(i!=j && i!= k && i!= t && j!=k && j!=t && k!=t){
                                    System.out.println(i+" "+ j);
                                    System.out.println(k +" "+t);
                                    out.close();
                                    System.exit(0);
                                return;
                                }
                            }
                            
                        }
                    }
                }
                
            }
        }
        
        System.out.println("-1");

        
        
        
        
//      -----------------------------------------------------------------------------------

        out.close();
        System.exit(0);
    }
    private static class pair{
        int a;
        int b;
    }

    
    private static boolean fileIOMode;
    private static String problemName = "xxx";
    private static BufferedReader in;
    private static PrintWriter out;
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        fileIOMode = false;
        if (fileIOMode) {
            in = new BufferedReader(new FileReader(problemName + ".in"));
            out = new PrintWriter(problemName + ".out");
        } else {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }
        tokenizer = new StringTokenizer("");

        new Thread(new Contest102A()).start();
    }

    private static String nextLine() {
        try {
            return in.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    private static String nextToken() {
        while (!tokenizer.hasMoreTokens()) {
            String str = nextLine();
            if(str==null) return null;
            tokenizer = new StringTokenizer(str);
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private static long nextLong() {
        return Long.parseLong(nextToken());
    }

    private static double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    private static BigInteger nextBigInteger() {
        return new BigInteger(nextToken());
    }

    private static void print(Object o) {
        if (fileIOMode) {
            System.out.print(o);
        }
        out.print(o);
    }

    private static void println(Object o) {
        if (fileIOMode) {
            System.out.println(o);
        }
        out.println(o);
    }

    private static void printf(String s, Object... o) {
        if (fileIOMode) {
            System.out.printf(s, o);
        }
        out.printf(s, o);
    }
}
