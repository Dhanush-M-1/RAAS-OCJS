import java.io.*;
import java.io.ObjectInputStream.GetField;
import java.util.*;

public class B
{
    BufferedReader in;
    PrintWriter out;

    void run() throws IOException
    {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        solve();
        out.flush();
    }

    public static void main(String[] args) throws IOException
    {
        new B().run();
    }

    void solve() throws IOException
    {
        String s=in.readLine();
        Calendar start = Calendar.getInstance();
        start.set(2013, 0, 1);
        Calendar end = Calendar.getInstance();
        end.set(2015, 11,31);
        int maxF=0;
        String maxD = null;
        for (; !start.after(end); start.add(Calendar.DATE, 1)) {
            int y = start.get(start.YEAR);
            int m = start.get(start.MONTH)+1;
            int d = start.get(start.DATE);
            String mm,dd;
            if(d<=9)
                dd = "0"+d;
            else
                dd = ""+d;
            if(m<=9)
                mm = "0"+m;
            else
                mm = ""+m;
            String date = dd+"-"+mm+"-"+y;
            int freq = getF(date,s);
            if(freq>maxF)
            {
                maxF =freq;
                maxD = date;
            }
        }
        out.println(maxD);
    }

    private int getF(String date, String s)
    {
        int ind = s.indexOf(date, 0);
        int ctr = 0;
        while(ind!=-1)
        {
            ctr++;
            ind = s.indexOf(date, ind+1);
        }
        return ctr;
    }
}


class InputReader763
{
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public InputReader763(InputStream stream)
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

    public Long readLong()
    {
        return Long.parseLong(readString());
    }

    public Double readDouble()
    {
        return Double.parseDouble(readString());
    }

    public static boolean isSpaceChar(int c)
    {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}