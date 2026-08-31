
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P15 {
        
	public static void main(String args[]) throws Exception
	{
        	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                String tmp[]=br.readLine().split(" ");
               int n=Integer.parseInt(tmp[0]);
               int x=Integer.parseInt(tmp[1]);
               int y=Integer.parseInt(tmp[2]);
               String str=br.readLine();
               char arr[]=str.toCharArray();
               int count =0;
               for(int i=0;i<x;i++)
                   if(arr[n-1-i]!=(i==y?'1':'0'))
                       count++;
               System.out.println(count);
                
        }

}
