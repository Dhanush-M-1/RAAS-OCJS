import java.io.*;
import java.util.*;
public class Candle
    {
        public static void main(String ar[])
            {
                InputReader in=new InputReader(System.in);
                int a=in.readInt(),b=in.readInt(),ans=a;
                while(a>=b)
                    {
                        ans+=a/b;
                        a=a/b+a%b;
                    }
                System.out.println(ans);
            }
public static class InputReader
    {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        public InputReader(InputStream stream)
            {
                this.stream = stream;
            }
        public int read() 
            {
                if (numChars == -1)
                throw new InputMismatchException();
                if (curChar >= numChars) 
                    {
                        curChar = 0;
                        try 
                            {
                                numChars = stream.read(buf);
                            }
                        catch (IOException e) 
                            {
                                throw new InputMismatchException();
                            }
                        if (numChars <= 0)
                            return -1;
                    }
                return buf[curChar++];
            }
        public int readInt() 
            {
                int c = read();
                while (isSpaceChar(c))
                    c = read();
                int sgn = 1;
                if (c == '-') 
                    {
                        sgn = -1;
                        c = read();
                    }
                int res = 0;
                do 
                    {
                        if (c < '0' || c > '9')
                            throw new InputMismatchException();
                        res *= 10;
                        res += c - '0';
                        c = read();
                    } while (!isSpaceChar(c));
                return res * sgn;
            }
        public String readString() 
            {
                int c = read();
                while (isSpaceChar(c))
                    c = read();
                StringBuffer res = new StringBuffer();
                do 
                    {
                        res.appendCodePoint(c);
                        c = read();
                    } while (!isSpaceChar(c));
                return res.toString();
            }
        public static boolean isSpaceChar(int c) 
            {
                return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
            }
    }
    }