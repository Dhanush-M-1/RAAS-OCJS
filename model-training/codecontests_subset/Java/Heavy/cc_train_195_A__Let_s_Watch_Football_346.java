import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
        System.out.println(Math.max((a * c + b - 1) / b - c, 0));
    }

}

final class FastScanner {
    private StringTokenizer stringTokenizer = null;
    private BufferedReader bufferedReader; 
    
    public FastScanner(InputStream in) {
        bufferedReader = new BufferedReader(new InputStreamReader(in));
        try {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String next() {
        while (!stringTokenizer.hasMoreTokens())
            try {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        return stringTokenizer.nextToken();
    }
    
    public int nextInt() {
        return Integer.parseInt(next());
    }
    
    public long nextLong() {
        return Long.parseLong(next());
    }
    
    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public boolean hasNext() {
        return stringTokenizer.hasMoreTokens();
    }
    
    public void nextLine() {
        try {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}