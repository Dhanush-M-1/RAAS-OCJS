import java.util.*;


public class King
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      String s = in.next();
      char[] charray = new char[n];
      for(int i=0;i<n;i++)
         charray[i]=s.charAt(i);
      for(int gap=1;gap<25;gap++)
      {
         for(int start = 0;start<=n;start++)
         {
            int two = start + gap;
            int three = start + gap*2;
            int four = start + gap*3;
            int five = start + gap*4;
            if(five>=n)
               break;
            if(charray[start]=='*' && charray[two]=='*' && charray[three]=='*' && charray[four]=='*' && charray[five]=='*')
            {
               System.out.println("yes");
               System.exit(0);
            }
         }
      }
      System.out.println("no");
   }
}