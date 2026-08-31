import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        Scan sc = new Scan();
        char[] n = sc.scanString().toCharArray();
        int k = sc.scanInt();
        
        // for less
        long[] res1 = new long[k+1];
        
        // for equality
        res1[0] = 1;
        res1[1] = n[0]-'0'-1;
        long res2 = 1;
        
        int ct = 1;
        
        for(int ind = 1, end = n.length; ind < end; ++ind){
            int curr = n[ind]-'0';
            long[] newr = new long[k+1];
            newr[0] = res1[0];
            if(curr == 0){
                for(int i = 1; i <= k; ++i){
                    // adding digit 0
                    newr[i] += res1[i];
                    // adding any other digit
                    newr[i] += res1[i-1]*9;
                }
            }
            else {
                for(int i = 1; i <= k; ++i){
                    // adding digit 0
                    newr[i] += res1[i];
                    // adding any other digit
                    newr[i] += res1[i-1]*9;
                }
                ++ct;
                if(ct <= k) {
                    newr[ct] += res2*(curr-1);
                    newr[ct-1] += res2*1;
                }
                else {
                    newr[k] += res2*1;
                    res2 = 0;
                }
            }
            res1 = newr;
        }
        System.out.println(res1[k] + (ct>=k?res2:0));
    }
}

class Scan
{
    private byte[] buf=new byte[1024];
    private int index;
    private InputStream in;
    private int total;
    public Scan()
    {
        in=System.in;
    }
    public int scan()throws IOException
    {
        if(total<0)
        throw new InputMismatchException();
        if(index>=total)
        {
            index=0;
            total=in.read(buf);
            if(total<=0)
            return -1;
        }
        return buf[index++];
    }
    public int scanInt()throws IOException
    {
        int integer=0;
        int n=scan();
        while(isWhiteSpace(n))
        n=scan();
        int neg=1;
        if(n=='-')
        {
            neg=-1;
            n=scan();
        }
        while(!isWhiteSpace(n))
        {
            if(n>='0'&&n<='9')
            {
                integer*=10;
                integer+=n-'0';
                n=scan();
            }
            else throw new InputMismatchException();
        }
        return neg*integer;
    }
    public double scanDouble()throws IOException
    {
        double doub=0;
        int n=scan();
        while(isWhiteSpace(n))
        n=scan();
        int neg=1;
        if(n=='-')
        {
            neg=-1;
            n=scan();
        }
        while(!isWhiteSpace(n)&&n!='.')
        {
            if(n>='0'&&n<='9')
            {
                doub*=10;
                doub+=n-'0';
                n=scan();
            }
            else throw new InputMismatchException();
        }
        if(n=='.')
        {
            n=scan();
            double temp=1;
            while(!isWhiteSpace(n))
            {
                if(n>='0'&&n<='9')
                {
                    temp/=10;
                    doub+=(n-'0')*temp;
                    n=scan();
                }
                else throw new InputMismatchException();
            }
        }
        return doub*neg;
    }
    public String scanString()throws IOException
    {
        StringBuilder sb=new StringBuilder();
        int n=scan();
        while(isWhiteSpace(n))
        n=scan();
        while(!isWhiteSpace(n))
        {
            sb.append((char)n);
            n=scan();
        }
        return sb.toString();
    }
    private boolean isWhiteSpace(int n)
    {
        if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1)
        return true;
        return false;
    }
}