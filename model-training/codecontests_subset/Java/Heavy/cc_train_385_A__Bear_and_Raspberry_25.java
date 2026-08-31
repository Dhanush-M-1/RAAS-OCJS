import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;

public class hello{
    
    static final long Mod=1000000007;
     
    public static long GCD(long a,long b){
         
            if (b ==0)
               return a;
            else
               return GCD(b, a%b);
    }
 

    public static void main(String[] args) throws NumberFormatException, IOException{
     
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        
        
        
    int n=in.readInt();


    int c=in.readInt();
    
    int[] a=new int[n];
    
    for(int i=0;i<n;i++){
        a[i]=in.readInt();
    }
    
    int max=0;
    
    int profit;
    
    for(int i=0;i<n-1;i++){
        profit=a[i]-a[i+1]-c;
        if(profit>max)
            max=profit;
    }
        
    
    out.printLine(max);
         

         out.close();
    }
    
}



class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    
    public InputReader(InputStream stream) {
            this.stream = stream;
    }
    
    public int read(){
            if (numChars == -1)
            throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
    }
    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
    public long readLong() {
        int c = read();
        while(isSpaceChar(c))
            c = read();
    int sgn = 1;
    if (c == '-') {
        sgn = -1;
        c = read();
    }
    long res = 0;
    do {
        if (c < '0' || c > '9')
            throw new InputMismatchException();
        res *= 10;
        res += c - '0';
        c = read();
    } while (!isSpaceChar(c));
    return res * sgn;
    }
    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuffer res = new StringBuffer();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }
    public static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
    public String next() {
        return readString();
    }
    }
 
class OutputWriter {
    private final PrintWriter writer;
    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(outputStream);
    }
    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }
    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.print(objects[i]);
        }
    }
    public void printLine(Object... objects) {
        print(objects);
        writer.println();
    }
    public void close() {
    writer.close();
    }
    }  
