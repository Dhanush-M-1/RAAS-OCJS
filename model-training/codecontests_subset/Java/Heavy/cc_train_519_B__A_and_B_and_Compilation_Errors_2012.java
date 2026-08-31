
import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;

import java.util.*;
import java.io.*;
public class Test {


	public static void main(String[] args) throws Exception{
		
		
		Scan s=new Scan();
		int n=s.scanInt();
	    
		long sumA=0,sumB=0,sumC=0;
		for(int i=0;i<n;i++)
		{
			int temp=s.scanInt();
			sumA+=temp;
		}
		
		for(int i=0;i<n-1;i++)
		{
			int temp=s.scanInt();
			sumB+=temp;
		}
		
		for(int i=0;i<n-2;i++)
		{
			int temp=s.scanInt();
			sumC+=temp;
		}
		
		System.out.println(sumA-sumB);
		System.out.println(sumB-sumC);
	}
}
class Scan
{
   // BufferedReader br;
    StringTokenizer st;
   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String scanString() throws IOException
    {
        while(st==null||!st.hasMoreTokens())
        {
            st=new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }
   long scanLong() throws IOException
    {
        return parseLong(scanString());
    }
   int scanInt() throws IOException
   {
       return parseInt(scanString());
   }
    
    
}