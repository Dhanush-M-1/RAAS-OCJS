import java.io.*;
import java.util.*;

public class A
{
public static void main(String[] args) throws IOException
    {		
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
        String in = br.readLine();
        StringTokenizer st = new StringTokenizer(in);

        int c = Integer.parseInt(st.nextToken());
        int v0 = Integer.parseInt(st.nextToken());
        int v1 = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int sum=0;int i=0;
        for( i =1; sum<c;i++)
        {
            if(i==1)
            {
                sum = sum+v0;
                if(v0+a<v1)
                v0+=a;
                else
                v0=v1;
            }
            else
            {
                sum = sum+v0-l;
                if(v0+a<v1)
                v0+=a;
                else
                v0=v1;
            }
        }
        System.out.println(i-1);
    }
}
