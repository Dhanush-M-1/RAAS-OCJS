import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Solution {
    public static int count(long val)
    {
        int c=0;
        while(val!=0)
        {
            c++;
            val=val/10;
        }
        return c;
    }
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader(System.in);
        StringBuilder sb = new StringBuilder();
        int i,j,count=0,x,temp;
        long val,c,r,M= 998244353,sum1,sum2,tsum=0;
        int n=in.nextInt();
        long arr[]=new long[n];
        int cou[]=new int[n];
        int freq[]=new int[11];
        for(i=0;i<n;i++)
        {
            arr[i]=in.nextInt();
            cou[i]=count(arr[i]);
            freq[cou[i]]++;
        }
        for(i=0;i<n;i++)
        {
            for(j=1;j<=10;j++)
            {
                if(freq[j]==0)
                    continue;
                val=arr[i];
                temp=j;
                c=1;
                sum1=sum2=0;
                while(val!=0)
                {
                    if(temp>0)
                    {
                        temp--;
                        c=(c*10)%M;
                    }
                    r=val%10;
                    sum1=(sum1+(c*r)%M)%M;
                    c=(c*10)%M;
                    val=val/10;

                }
                c=1;
                temp=j;
                val=arr[i];
                while(val!=0)
                {
                    r=val%10;
                    sum2=(sum2+(c*r)%M)%M;
                    c=(c*10)%M;
                    val=val/10;
                    if(temp>0)
                    {
                        temp--;
                        c=(c*10)%M;
                    }
                }
                tsum=(tsum+(sum1+sum2)*freq[j])%M;

            }
        }
        System.out.println(tsum);



    }


}
class Node implements Comparable<Node>
{
    int pos,val;
    public Node(int pos,int val)
    {
        this.pos=pos;
        this.val=val;
    }
    public

    int compareTo(Node n2)
    {
        if(this.val>n2.val)
            return 1;
        else if(this.val<n2.val)
            return -1;
        else
            return 0;
    }
}
class FastReader {

    byte[] buf = new byte[2048];
    int index, total;
    InputStream in;

    FastReader(InputStream is) {
        in = is;
    }

    int scan() throws IOException {
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0) {
                return -1;
            }
        }
        return buf[index++];
    }

    String next() throws IOException {
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        StringBuilder sb = new StringBuilder();
        for (; c > 32; c = scan()) {
            sb.append((char) c);
        }
        return sb.toString();
    }

    String nextLine() throws IOException {
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        StringBuilder sb = new StringBuilder();
        for (; c != 10 && c != 13; c = scan()) {
            sb.append((char) c);
        }
        return sb.toString();
    }

    char nextChar() throws IOException {
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        return (char) c;
    }

    int nextInt() throws IOException {
        int c, val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }

    long nextLong() throws IOException {
        int c;
        long val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }
}