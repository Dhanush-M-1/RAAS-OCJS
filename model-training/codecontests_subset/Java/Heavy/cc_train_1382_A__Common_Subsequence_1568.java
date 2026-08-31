/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
// import java.math.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter ot=new PrintWriter(System.out);
            int t=Integer.parseInt(br.readLine().trim());
            // int total=0;
            while(t-->0)
            {
                String s[]=br.readLine().trim().split(" ");
                int n1=Integer.parseInt(s[0]);
                int n2=Integer.parseInt(s[1]);
                ArrayList<Integer> a=new ArrayList<>();
                ArrayList<Integer> b=new ArrayList<>();
                String as[]=br.readLine().trim().split(" ");
                for(int i=0;i<n1;i++)
                a.add(Integer.parseInt(as[i]));
                String bs[]=br.readLine().trim().split(" ");
                for(int i=0;i<n2;i++)
                b.add(Integer.parseInt(bs[i]));
                boolean bool=false;
                for(int i=0;i<n1;i++)
                {
                    if(b.contains(a.get(i)))
                    {
                        ot.println("YES");
                        ot.println("1 "+a.get(i));
                        bool=true;
                        break;
                    }
                    
                }
                if(!bool)
                ot.println("NO");
            }
            ot.close();
            br.close();
            
        } catch(Exception e){
            System.err.println("ERROR");
            return;
        }
    }
    
}
    