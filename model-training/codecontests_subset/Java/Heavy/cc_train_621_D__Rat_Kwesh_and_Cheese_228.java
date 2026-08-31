
 import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
 

public class Fourth
{
    public static void main(String[] args) throws Exception
    {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        x = in.readDouble();
        y = in.readDouble();
        z = in.readDouble();
        double[] a = new double[12];
        Arrays.fill(a, -1e15);
        if( x==1 && y!=1 && z!=1 )
        {
        	
        	if( (y<1 && z<1) || (y>1 && z<1) || ( y<1 && z>1 ) )
        	{
        		a[0] = 1;
            	a[4] = Math.pow(y,Math.pow(x, z));
            	a[5] = Math.pow(y,Math.pow(z, x));
            	a[6] = Math.pow(y, x*z);
            	a[7] = Math.pow(y, x*z);
            	a[8] = Math.pow(z,Math.pow(x, y));
            	a[9] = Math.pow(z,Math.pow(y, x));
            	a[10] = Math.pow(z, y*x);
            	a[11] = Math.pow(z, y*x);
//            	System.out.println(Arrays.toString(a));
        	}
        	else
        	{
        		 a[4] = z*Math.log(x)+Math.log(Math.log(y));
                 a[5] = x*Math.log(z)+Math.log(Math.log(y));
                 a[6] = Math.log(x*z*Math.log(y));
                 a[7] = Math.log(x*z*Math.log(y));
                 a[8] =  y*Math.log(x)+Math.log(Math.log(z));
                 a[9] = x*Math.log(y)+Math.log(Math.log(z));
                 a[10] = Math.log(x*y*Math.log(z));
                 a[11] = Math.log(x*y*Math.log(z));
        	}
        }
        else if( x==1 && y==1 && z!=1 )
        {
        	if( z>1 )
        	{
        		a[8]=5;
        	}
        	else
        	{
        		a[0]=5;
        	}
        }
        else if( x==1 && y==1 && z==1 )
        {
        	a[0]=5;
        }
        else if( y==1 && z!=1 )
        {
        	if( (x<1 && z<1) || (x>1 && z<1) || ( x<1 && z>1 ) )
        	{
        		a[4] = 1;
            	a[0] = Math.pow(x,Math.pow(y, z));
            	a[1] = Math.pow(x,Math.pow(z, y));
            	a[2] = Math.pow(x, y*z);
            	a[3] = Math.pow(x, y*z);
            	a[8] = Math.pow(z,Math.pow(x, y));
            	a[9] = Math.pow(z,Math.pow(y, x));
            	a[10] = Math.pow(z, y*x);
            	a[11] = Math.pow(z, y*x);
        	}
        	else
        	{
        		a[0] = z*Math.log(y)+Math.log(Math.log(x));
                a[1] = y*Math.log(z)+Math.log(Math.log(x));
                a[2] = Math.log(y*z*Math.log(x));
                a[3] = Math.log(y*z*Math.log(x));
                a[8] =  y*Math.log(x)+Math.log(Math.log(z));
                a[9] = x*Math.log(y)+Math.log(Math.log(z));
                a[10] = Math.log(x*y*Math.log(z));
                a[11] = Math.log(x*y*Math.log(z));
        	}
        }
        else if( y==1 && z==1 )
        {
        	a[0] = Math.pow(x,Math.pow(y, z));
        	a[1] = Math.pow(x,Math.pow(z, y));
        	a[2] = Math.pow(x, y*z);
        	a[3] = Math.pow(x, y*z);
        	a[4] = 1;
        }
        else if( z==1 )
        {
        	if( (x<1 && y<1) || (x>1 && y<1) || ( x<1 && y>1 ) )
        	{
        		a[0] = Math.pow(x,Math.pow(y, z));
            	a[1] = Math.pow(x,Math.pow(z, y));
            	a[2] = Math.pow(x, y*z);
            	a[3] = Math.pow(x, y*z);
            	a[4] = Math.pow(y,Math.pow(x, z));
            	a[5] = Math.pow(y,Math.pow(z, x));
            	a[6] = Math.pow(y, x*z);
            	a[7] = Math.pow(y, x*z);
            	a[8] = 1;
        	}
        	else
        	{
        		a[0] = z*Math.log(y)+Math.log(Math.log(x));
                a[1] = y*Math.log(z)+Math.log(Math.log(x));
                a[2] = Math.log(y*z*Math.log(x));
                a[3] = Math.log(y*z*Math.log(x));
                a[4] = z*Math.log(x)+Math.log(Math.log(y));
                a[5] = x*Math.log(z)+Math.log(Math.log(y));
                a[6] = Math.log(x*z*Math.log(y));
                a[7] = Math.log(x*z*Math.log(y));
        	}
        }
        else if( x>1 && y>1 && z>1 )
        {
             a[0] = z*Math.log(y)+Math.log(Math.log(x));
             a[1] = y*Math.log(z)+Math.log(Math.log(x));
             a[2] = Math.log(y*z*Math.log(x));
             a[3] = Math.log(y*z*Math.log(x));
             a[4] = z*Math.log(x)+Math.log(Math.log(y));
             a[5] = x*Math.log(z)+Math.log(Math.log(y));
             a[6] = Math.log(x*z*Math.log(y));
             a[7] = Math.log(x*z*Math.log(y));
             a[8] =  y*Math.log(x)+Math.log(Math.log(z));
             a[9] = x*Math.log(y)+Math.log(Math.log(z));
             a[10] = Math.log(x*y*Math.log(z));
             a[11] = Math.log(x*y*Math.log(z));
            
        }
        else if( x<1 && y<1 && z<1 )
        {
        	a[0] = Math.pow(x,Math.pow(y, z));
        	a[1] = Math.pow(x,Math.pow(z, y));
        	a[2] = Math.pow(x, y*z);
        	a[3] = Math.pow(x, y*z);
        	a[4] = Math.pow(y,Math.pow(x, z));
        	a[5] = Math.pow(y,Math.pow(z, x));
        	a[6] = Math.pow(y, x*z);
        	a[7] = Math.pow(y, x*z);
        	a[8] = Math.pow(z,Math.pow(x, y));
        	a[9] = Math.pow(z,Math.pow(y, x));
        	a[10] = Math.pow(z, y*x);
        	a[11] = Math.pow(z, y*x);
        }
        else if( x<1 )
        {
        	if( y<1 )
        	{
                 a[8] =  Math.pow(x, y);
                 a[9] = Math.pow(y, x);
                 a[10] = x*y;
                 a[11] = x*y;
        	}
        	else if( z<1 )
        	{
        		a[4] =  Math.pow(x, z);
                a[5] = Math.pow(z, x);
                a[6] = x*z;
                a[7] = x*z;
        	}
        	else
        	{
        		 a[4] = z*Math.log(x)+Math.log(Math.log(y));
                 a[5] = x*Math.log(z)+Math.log(Math.log(y));
                 a[6] = Math.log(x*z*Math.log(y));
                 a[7] = Math.log(x*z*Math.log(y));
                 a[8] =  y*Math.log(x)+Math.log(Math.log(z));
                 a[9] = x*Math.log(y)+Math.log(Math.log(z));
                 a[10] = Math.log(x*y*Math.log(z));
                 a[11] = Math.log(x*y*Math.log(z));
        	}
        }
        else if( y<1 )
        {
        	if( z<1 )
        	{
        		a[0] =  Math.pow(y, z);
                a[1] = Math.pow(z, y);
                a[2] = z*y;
                a[3] = z*y;
        	}
        	else
        	{
        		a[0] = z*Math.log(y)+Math.log(Math.log(x));
                a[1] = y*Math.log(z)+Math.log(Math.log(x));
                a[2] = Math.log(y*z*Math.log(x));
                a[3] = Math.log(y*z*Math.log(x));
        		a[8] =  y*Math.log(x)+Math.log(Math.log(z));
                a[9] = x*Math.log(y)+Math.log(Math.log(z));
                a[10] = Math.log(x*y*Math.log(z));
                a[11] = Math.log(x*y*Math.log(z));
        	}
        }
        else if( z<1 )
        {
        	a[0] = z*Math.log(y)+Math.log(Math.log(x));
            a[1] = y*Math.log(z)+Math.log(Math.log(x));
            a[2] = Math.log(y*z*Math.log(x));
            a[3] = Math.log(y*z*Math.log(x));
            a[4] = z*Math.log(x)+Math.log(Math.log(y));
            a[5] = x*Math.log(z)+Math.log(Math.log(y));
            a[6] = Math.log(x*z*Math.log(y));
            a[7] = Math.log(x*z*Math.log(y));
        }
        
        double max = -1e15;
        for( int i=0 ; i<12 ; i++ )
        {
        	if( a[i]>max )
        	max = a[i];
        }
//        System.out.println(Arrays.toString(a));
//        System.out.println(max);
        String[] s = { "x^y^z","x^z^y","(x^y)^z","(x^z)^y","y^x^z","y^z^x","(y^x)^z","(y^z)^x","z^x^y","z^y^x","(z^x)^y","(z^y)^x"};
        for( int i=0 ; i<12 ; i++ )
        {
        	if( max==a[i] )
        	{
        		out.println(s[i]);
        		break;
        	}
        }
        
        out.close();
        
    }
 
    static double x=0,y=0,z=0;

 
    private static class InputReader
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
                    return res * Math.pow(10, readInt());
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
                        return res * Math.pow(10, readInt());
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
 
    private static class OutputWriter
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
 
        public void print(Object... objects)
        {
            for (int i = 0; i < objects.length; i++)
            {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }
 
        public void println(Object... objects)
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