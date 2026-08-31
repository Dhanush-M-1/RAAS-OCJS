//Standard_JAVA_Template
/*@author SUMITESH NAITHANI somu_9 */
import java.io.*;
import java.util.*;
public class Messi
{
    public static void main(String[]args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        long a=0,b=0,c=0;
               for(int i=0;i<3;i++)
               {
                    String s[]=br.readLine().split(" ");
                    for(int j=0;j<s.length;j++)
                    {
                    	if(i==0)
                    		a+=Integer.parseInt(s[j]);
                    	else if(i==1)
                    		b+=Integer.parseInt(s[j]);
                    	else
                    		c+=Integer.parseInt(s[j]);
                    }
               }
               System.out.println(a-b);
               System.out.println(b-c);
    }
}