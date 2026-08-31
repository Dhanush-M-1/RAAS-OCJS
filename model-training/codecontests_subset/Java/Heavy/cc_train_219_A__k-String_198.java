import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main  {

    public static void main(String args[]) throws IOException {
        Reader.init(System.in);
        
        
        
        int k=Reader.nextInt();
        char a[]=Reader.next().toCharArray();
        int v[]=new int[26];
        
        for (int i = 0; i < a.length; i++) {
            v[a[i]-'a']++;
        }
        int s=Integer.MAX_VALUE;
        for (int i = 0; i < v.length; i++) {
            if(v[i]%k!=0)
            {
                System.out.println("-1");
                return;
            }
            else
                if(v[i]>0)
                s=Math.min(s, v[i]);
        }
        
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < v.length; j++) {

                if(v[j]>0)
                for (int l = 0; l < v[j]/k; l++) {
                    System.out.print((char)(j+'a'));
                }
            }
        }
        
        
        
    }
    
}
class Reader {

    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /**
     * call this method to initialize reader for InputStream
     */
    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }

    /**
     * get next word
     */
    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static public void nextIntArrays(int[]... arrays) throws IOException {
        for (int i = 1; i < arrays.length; ++i) {
            if (arrays[i].length != arrays[0].length) {
                throw new InputMismatchException("Lengths are different");
            }
        }
        for (int i = 0; i < arrays[0].length; ++i) {
            for (int[] array : arrays) {
                array[i] = nextInt();
            }
        }
    }

    static public void nextLineArrays(String[]... arrays) throws IOException {
        for (int i = 1; i < arrays.length; ++i) {
            if (arrays[i].length != arrays[0].length) {
                throw new InputMismatchException("Lengths are different");
            }
        }
        for (int i = 0; i < arrays[0].length; ++i) {
            for (String[] array : arrays) {
                array[i] = reader.readLine();
            }
        }
    }
}
