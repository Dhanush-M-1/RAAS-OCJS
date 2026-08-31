import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codeforces {

    public static void main(String[] args) throws java.lang.Exception {
        /* your code goes here */
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
       int t = Integer.parseInt(buf.readLine());
        StringBuilder sb = new StringBuilder();
       for (int i = 0; i < t; i++) {
           String st=buf.readLine();
           String st1[]=(buf.readLine()).split(" ");
           int k=Integer.parseInt((st1[0]));
           int n=Integer.parseInt(st1[1]);
           int m=Integer.parseInt((st1[2]));
           int pl1[]=new int[n];
           int pl2[]=new int[m];
           String st2[]=(buf.readLine()).split(" ");
           String st3[]=(buf.readLine()).split(" ");
           for(int j=0;j<n;j++)
           {
               pl1[j]=Integer.parseInt(st2[j]);
           }
           for(int j=0;j<m;j++)
           {
               pl2[j]=Integer.parseInt(st3[j]);
           }
           ArrayList<Integer> adj=new ArrayList<Integer>();
           int j=0,z=0,flag=0;
           while(j<n && z<m)
           {
               if(pl1[j]==0)
               {
                   adj.add(pl1[j]);
                   k++;
                   j++;
               }
               else if(pl2[z]==0)
               {
                   adj.add(pl2[z]);
                   k++;
                   z++;
               }
               else
               {
                   if(pl1[j]<=k)
                   {
                       adj.add(pl1[j]);
                       j++;
                   }
                   else if(pl2[z]<=k)
                   {
                       adj.add(pl2[z]);
                       z++;
                   }
                   else
                   {
                       flag=1;
                       break;
                   }
               }
           }
           if(flag==0)
           {
               int flag2=0;
               while(j<n)
               {
                   if(pl1[j]==0)
                   {
                       adj.add(pl1[j]);
                       k++;
                       j++;
                   }
                   else
                   {
                       if(pl1[j]<=k)
                       {
                           adj.add(pl1[j]);
                           j++;
                       }
                       else
                       {
                           flag2=1;
                           break;
                       }
                   }
               }
               while(z<m)
               {
                   if(pl2[z]==0)
                   {
                       adj.add(pl2[z]);
                       k++;
                       z++;
                   }
                   else
                   {
                       if(pl2[z]<=k)
                       {
                           adj.add(pl2[z]);
                           z++;
                       }
                       else
                       {
                           flag2=1;
                           break;
                       }
                   }
               }
               if(flag2==0)
               {
                   for(j=0;j<adj.size();j++)
                       sb.append(adj.get(j)+" ");
               }
               else
                   sb.append("-1");
           }
           else
               sb.append("-1");
           sb.append("\n");
        }
        System.out.println(sb);
    }
}