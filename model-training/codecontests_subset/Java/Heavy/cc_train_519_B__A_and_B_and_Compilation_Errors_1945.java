
import java.awt.Point;
import java.awt.font.GraphicAttribute;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.naming.directory.SearchControls;
 

 
 
public class TestClass {
 

	

public static void main(String args[] ) throws IOException  {
 
 
 
  InputStream inputStream = System.in;
    InputReader in = new InputReader(inputStream);
    
    // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 // BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Sompathak\\Desktop\\yes.txt"));
   //Scanner in = new Scanner(new FileReader("C:\\Users\\Sompathak\\Desktop\\yes.txt"));
    //PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\Sompathak\\Desktop\\output.txt"));
   	//InputStream inputStream = System.in;
   	//InputReader in = new InputReader(inputStream);
  // Scanner in = new Scanner(new InputStreamReader(System.in));
// Scanner in = new Scanner(new FileReader("C:\\Users\\Sompathak\\Desktop\\yes.txt"));
	//we can we will ??? !!!!!! SOM     RISES

int n = in.nextInt();
int[] A = new int[n];
for(int i=0;i<n;i++) A[i]=in.nextInt();
Arrays.sort(A);
int[] B = new int[n-1];
for(int i=0;i<n-1;i++) B[i]=in.nextInt();
Arrays.sort(B);
int ans=-1;
for(int i=0;i<n-1;i++)
	if(A[i]!=B[i]){
		ans=A[i];
		break;
	}
if(ans==-1) ans =A[n-1];
System.out.print(ans+" ");
ans=-1;
A = new int[n-2];
for(int i=0;i<n-2;i++) A[i]=in.nextInt();
Arrays.sort(A);
for(int i=0;i<n-2;i++)
	if(A[i]!=B[i]){
		ans=B[i];
		break;
	}
if(ans==-1) ans=B[n-2];
System.out.println(ans);

}public static class InputReader
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
            } catch (IOException e)
            {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int nextInt()
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
        StringBuilder res = new StringBuilder();
        do
        {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }
    public double readDouble() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        double res = 0;
        while (!isSpaceChar(c) && c != '.') {
            if (c == 'e' || c == 'E')
                return res * Math.pow(10, nextInt());
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        if (c == '.') {
            c = read();
            double m = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }
    public long readLong() {
        int c = read();
        while (isSpaceChar(c))
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

    public interface SpaceCharFilter
    {
        public boolean isSpaceChar(int ch);
    }
}
 }