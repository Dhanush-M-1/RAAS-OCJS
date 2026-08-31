import java.util.*;

public class dproblem
{
  public static void main(String args[])
  {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    
    int k = in.nextInt();
    
    int maxli = (int)Math.pow(2,19);
    int arr[] = new int[maxli];
    
    for(int i =0;i<n;i++)
    {
     	int a = in.nextInt();
     	arr[a]++;
    }
    
    long max =(long)Math.pow(10,18);
    

    for(int i =1;i<maxli;i++)
    {
      int j =2*i;
      int count=arr[i]; 
      int mul=1;
      long val =0;
      int lol=2;
      while(j<maxli&&count<k)
      {
        
      	for(int gay=0;gay<lol;gay++)
      	{
      	 
      	 if(count==k)
      	  break;
      	 
      	 if(arr[j+gay]+count<k)
      	 {
      	  val = val + mul*arr[j+gay];
      	  count = count+arr[j+gay];
         }
         else
         {
        	val = val+ (k-count)*mul;
         	count=k;
         }
        }
        lol=2*lol;
      	j=2*j;
      	mul++;  	
      }
      if(count>=k)
      {
       max = Math.min(max,val);
      }	
    }

     System.out.println(max);

  }	
}