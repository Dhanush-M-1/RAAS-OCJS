import java.util.Arrays;
import java.util.Scanner;
public class Code 
{
    public static void main(String[] args)
     {
         int c=0;
      Scanner in=new Scanner(System.in);
      String str=in.next();
      char arr[]=new char[str.length()];
      for(int i=0;i<str.length();i++)
      {
          if(str.charAt(i)!='+')
          {
              arr[i]=str.charAt(i);
              c++;
          }
      }
      Arrays.sort(arr);
     String s=String.valueOf(arr);
    

   s=s.trim();
      
      for(int i=0;i<c-1;i++)
      {
          System.out.print(s.charAt(i));
          System.out.print("+");
      }
      System.out.print(s.charAt(c-1));
     
}
}


