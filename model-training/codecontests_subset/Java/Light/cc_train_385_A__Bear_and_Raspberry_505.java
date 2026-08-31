import java.util.*;
 
public class Akash
{
  public static void main(String[] args)
  {
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      int c=sc.nextInt();
      int arr[]=new int[n];
      for(int i=0;i<n; i++)
      {
          arr[i]=sc.nextInt();
      }
     int max=0;
     for(int i=0; i<n-1; i++)
     {
         int profit=arr[i]-arr[i+1]-c;
         if(max<profit)
         {
             max=profit;
         }
     }
     System.out.println(max);
      
      
  }
}