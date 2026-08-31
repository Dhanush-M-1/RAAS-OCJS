								//package Dynamic;
import java.io.*;
import java.util.*;
public class abc 
{
    static public void main(String[] args) throws IOException 
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String s=br.readLine();
//        while(t-->0)
//        {
//        	
//        }
//        StringTokenizer st=new StringTokenizer(br.readLine());
//        int a=Integer.parseInt(st.nextToken());
//        int b=Integer.parseInt(st.nextToken());
//        int c=Integer.parseInt(st.nextToken());
//        int d=Integer.parseInt(st.nextToken());
//        long a=Long.parseLong(st.nextToken());
//        long b=Long.parseLong(st.nextToken());
//        long c=Long.parseLong(st.nextToken());
//        long d=Long.parseLong(st.nextToken());
//        int ar[]=new int[n];
        int c=0;
        ArrayList<String> al=new ArrayList<>();
        int c1=0,c0=0;
        //String q="";
        for(int x=0;x<n;x++)
        {
        	//q+=s.charAt(x);
        	if(s.charAt(x)=='0')
        			c0++;
        	else
        		c1++;
        }
        if(c0!=c1)
        {
        	System.out.println("1");
        	System.out.println(s);
        }
        else
        {
        	System.out.println("2");
        	System.out.println(s.charAt(0)+" "+s.substring(1));
        }
    }
}