import java.util.*;
import java.math.*;
public class A
{
   public static void main(String[] args) throws Exception
   {
      Scanner sc=new Scanner(System.in);
      int T=0;
      if(sc.hasNextInt())
       T=sc.nextInt();
      while(T-->0)
      {
         int x=0;
         //int r1=0,r2=0;
         int s1=sc.nextInt();
         int s2=sc.nextInt();
         int[] arr=new int[s2];
         List<Integer> l=new ArrayList<>();
         for(int i=0;i<s1;i++)
         l.add(sc.nextInt());
         
         for(int i=0;i<s2;i++)
         {
           arr[i]=sc.nextInt();
           if(l.contains(arr[i]))
           x=arr[i];
         }
         if(x==0)
         System.out.println("NO");
         else
         {
          System.out.println("YES");
          System.out.println(1+" "+x);
         }
         
         
        
         
         
         }
         
         
      }
   }