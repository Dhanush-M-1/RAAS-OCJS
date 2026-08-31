/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
        String s0[]=inp.readLine().split(" ");
        int n=Integer.parseInt(s0[0]);
        int m=Integer.parseInt(s0[1]);
        String s1[]=inp.readLine().split(" ");
        String s2[]=inp.readLine().split(" ");
        int[] array=new int[n+1];
        int ammay[]=new int[m+1];
        boolean[] bool = new boolean[n+1];
        int[] ini=new int[n+1];
        int count=1;
        Stack st=new Stack();
        Stack rt=new Stack();
        int ans=0;
        for(int i=1;i<n+1;i++)
            {
                array[i]=Integer.parseInt(s1[i-1]);

            }

        for(int j=1;j<m+1;j++)
            {
                ammay[j]=Integer.parseInt(s2[j-1]);
                

            }
        
        for(int i=1;i<m+1;i++)
            {
                //System.out.println(ammay[i]);
                if(bool[ammay[i]]==false)
                {
                    ini[count]=ammay[i];
                    bool[ammay[i]]=true;
                    count++;
                }
            }
      // System.out.println("count"+count);
        for(int i=count-1;i>0;i--)
            {
                //System.out.println(ini[i]);
                st.push(new Integer(ini[i]));
            }
            
        for(int i=1;i<m+1;i++)
           {
            while(true)
              {
             //     System.out.println("pushinh");
               int num=(int)st.pop();
               
               if(num!=ammay[i])
                 {
                    rt.push(num);
                    ans=ans+array[num];
                 }
                 else if(num==ammay[i])
                 {
                    while(rt.empty()!=true)
                       st.push(rt.pop());
                        st.push(num);
                         break;
                 }
                
              }
           }
         System.out.println(ans);
    }
}