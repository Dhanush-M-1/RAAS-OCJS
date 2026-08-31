import java.io.*;
import java.util.*;

public class HelpVasilisa
{     
   public static void main(String args[]) throws IOException
   { 
    BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
    int n=3;
    String[] ar = new String[n];
    int r=0;
    while(n-->0)
    {
      String s=cin.readLine();
      ar[r]=s;
      r++;
    }
   String[] tok1=ar[0].split(" ");  
   String[] tok2=ar[1].split(" ");
   String[] tok3=ar[2].split(" ");
   int r1=Integer.parseInt(tok1[0]);    
   int r2=Integer.parseInt(tok1[1]);    
   int c1=Integer.parseInt(tok2[0]);    
   int c2=Integer.parseInt(tok2[1]);
   int d1=Integer.parseInt(tok3[0]);    
   int d2=Integer.parseInt(tok3[1]);       
    
    int a,b,c,d;
    int x=0;
   for(a=1;a<=9;a++)
      {
        for(b=1;b<=9;b++)
        {
         if(b!=a)
         {
          for(c=1;c<=9;c++)
          {
            if(c!=b && c!=a)
            {
             for(d=1;d<=9;d++)
             {
                if(d!=c && d!=a && d!=b)
                {
                  if (((a+b)==r1) && ((c+d)==r2) && ((a+c)==c1) && ((b+d)==c2) && ((a+d)==d1) && ((b+c)==d2))
                     {
                       System.out.println(a + " " + b);               
                       System.out.println(c + " " + d);
                       x++;
                      }
                }
              else;
             }
           }
         else ;  
        }
      }
    else;
    }
}   
  if(x==0)
      System.out.println("-1");
  }
}     
      
                