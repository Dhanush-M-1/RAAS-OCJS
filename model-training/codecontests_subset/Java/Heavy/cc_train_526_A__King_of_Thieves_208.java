import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Reader.init(System.in);
        int n = Reader.nextInt() ; 
        char [] c = Reader.next().toCharArray() ;  
        for (int i=0 ; i<=c.length-5 ; i++)
        {
            if (c[i]=='*')
            {
                for (int j=1 ; (j*4)+i<c.length ; j++)           
                {             
                    if (c[i+j]=='*'&&c[i+(j*2)]=='*'&&c[i+(j*3)]=='*'&&c[i+(j*4)]=='*')
                    {
                        System.out.println("yes");    
                        return ;
                    }                     
                }
            }
        }  
        System.out.println("no");
   
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

    static byte nextByte() throws IOException {
        return Byte.parseByte(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}