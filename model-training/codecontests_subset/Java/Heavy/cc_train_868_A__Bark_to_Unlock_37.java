import java.io.*;
import java.util.*;
public class file
{ 
   public static void main(String args[])throws IOException
   {
      BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
      String s = reader.readLine();
      int t = Integer.parseInt(reader.readLine());
      String s1[] = new String[t];
      for(int i=0;i<t;i++)
      {
        s1[i]=reader.readLine();  
      }
      boolean check = false;
      for(int i=0;i<t;i++)
      {
        for(int j=0;j<t;j++)
        {
           String c = s1[i]+s1[j];
           if(c.contains(s))
           {
             check=true;
             break;
           }
        }
      }
      if(check)
      {
        System.out.println("YES");  
      }
      else
      {
        System.out.println("NO");  
      }
   }
   }