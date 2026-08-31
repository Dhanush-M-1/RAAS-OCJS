
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;


public class Challenge 
{
    static InputReader in = new InputReader(System.in);
    static OutputWriter out = new OutputWriter(System.out);
    static Scanner scan_in = new Scanner(System.in);

    static String seq;
    static int N, posit, negat, curr, p, p1, p2;
    static int[] numbers = new int[110];
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception 
    {            
        seq = scan_in.nextLine();
        
        p = seq.indexOf('=') + 2;
        
        while(p < seq.length()  &&  seq.charAt(p) >= '0'  &&  seq.charAt(p) <= '9')
        {
            N = N * 10 + seq.charAt(p) - '0';
            ++p;
         }
        
        posit = 1;
        
        for(int i=0; i<seq.length(); ++i)
        {
            if(seq.charAt(i) == '+')
                ++posit;
           
            else if(seq.charAt(i) == '-')
                ++negat;
        }
        
        curr = posit - negat;
                
        for(int i=0; i<posit; ++i)
        {
            numbers[i] = 1;
                        
            //out.printLine(curr + " " + N);

            if(curr < N)
            {
                int temp = numbers[i];
                numbers[i] = Math.min(numbers[i] + N - curr, N);
                curr += numbers[i] - temp;
            }
            
            //out.printLine(curr + " " + N + " " + numbers[i]);
        }
        
        for(int i=posit; i<posit+negat; ++i)
        {
            numbers[i] = -1;
            
            //out.printLine(curr + ", " + N);

            if(curr > N)
            {
                int temp = numbers[i];
                numbers[i] = Math.max(numbers[i] - (curr - N), -N);
                curr += numbers[i] - temp;
            }
            
           // out.printLine(curr + ", " + N + " " + numbers[i]);
        } 
        
        if(curr != N)
        {
            out.printLine("Impossible");
            out.close();
            return;
        }
        
        p2 = posit;
       
        out.printLine("Possible");

        for(int i=0; i<seq.length(); ++i)
        {
            if(i == 0  ||  (seq.charAt(i) == '?'  &&  seq.charAt(i-2) == '+'))
            {
                out.print(numbers[p1]);
                ++p1;
            }
            
            else if(seq.charAt(i) == '?'  &&  seq.charAt(i-2) == '-')
            {
                out.print(-numbers[p2]);
                ++p2;
            }
            
            else
                out.print(seq.charAt(i));
        }
        
        out.printLine();
        out.close();
    }
  
    
    static interface SpaceCharFilter 
    {
        public boolean isSpaceChar(int ch);
    }
    
    static class InputReader
    {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

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
            int sgn = 1, res = 0;

            while (isSpaceChar(c))
                    c = read();

            if (c == '-') 
            {
                sgn = -1;
                c = read();
            }

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
              
        public long readLong() 
        {
            int c = read();
            int sgn = 1;
            long res = 0;

            while (isSpaceChar(c))
                    c = read();

            if (c == '-') 
            {
                sgn = -1;
                c = read();
            }

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

            StringBuilder res = new StringBuilder();

            do 
            {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) 
        {
            if (filter != null)
                    return filter.isSpaceChar(c);

            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() 
        {
            return readString();
        }
    }
 
    static class OutputWriter 
    {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) 
        {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) 
        {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object...objects) 
        {
            for (int i = 0; i < objects.length; i++) 
            {
                if (i != 0)
                    writer.print(' ');

                writer.print(objects[i]);
            }
        }

        public void printLine(Object...objects) 
        {
            print(objects);
            writer.println();
        }

        public void close() 
        {
            writer.close();
        }

        public void flush()
        {
            writer.flush();
        }
    }
}
