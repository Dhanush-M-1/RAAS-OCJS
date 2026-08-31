import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String args[])throws IOException
    {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         PrintWriter pr=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
         int n,c,max=0,i,diff;
         //System.out.println("enter");
         StringTokenizer input=new StringTokenizer(br.readLine());
         n=Integer.parseInt(input.nextToken());
         c=Integer.parseInt(input.nextToken());
         int arr[]=new int[n];
         StringTokenizer inp=new StringTokenizer(br.readLine());
         for(i=0;i<n;i++)
         arr[i]=Integer.parseInt(inp.nextToken());
         //for(i=0;i<n;i++)
         // System.out.println(arr[i]);
         for(i=0;i<n-1;i++)
         {
             diff=arr[i]-arr[i+1];
             if(max<diff)
             max=diff;
              //System.out.println(diff);
         }
            if((max-c)>0)
           pr.println((max-c));
           else
           pr.println("0");
           pr.close();
        
    }
}
            
         