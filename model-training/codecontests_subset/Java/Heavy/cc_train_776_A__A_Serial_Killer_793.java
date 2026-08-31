import java.io.*;
import java.util.*;
import java.util.regex.*;
public class vk18
{
    public static void main(String[]stp) throws Exception
    {
    	Scanner scan=new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []s;
        String na1,na2;
        s=br.readLine().split(" ");
        na1=s[0];na2=s[1];
        //String na=na1+" "+na2;
        //System.out.println(na);
        System.out.println(na1+" "+na2);
        int n=Integer.parseInt(br.readLine());
        while(n!=0)
        {
        	s=br.readLine().split(" ");
        	String s1=s[0],s2=s[1];
        	//System.out.println(s1+" "+s2+" "+na1+" "+na2);
        	if(s1.equals(na1)){ na1=s2;}
        	else na2=s2;
        	System.out.println(na1+" "+na2);

        	n--;
        }
        

    }
}