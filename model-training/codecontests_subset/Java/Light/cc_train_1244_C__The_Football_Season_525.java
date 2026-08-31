// created by Whiplash99
import java.io.*;
import java.util.*;
public class C
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int i;

        String s[]=br.readLine().trim().split(" ");
        long N=Long.parseLong(s[0]);
        long P=Long.parseLong(s[1]);
        long W=Long.parseLong(s[2]);
        long D=Long.parseLong(s[3]);

        long y=0;

        while(y<W&&(P-D*y)%W!=0)++y;
        if(y<W)
        {
            long x=(P-D*y)/W;
            long z=N-x-y;

            if(x>=0&&z>=0)
                System.out.println(x+" "+y+" "+z);
            else
                System.out.println(-1);
        }
        else
            System.out.println(-1);
    }
}