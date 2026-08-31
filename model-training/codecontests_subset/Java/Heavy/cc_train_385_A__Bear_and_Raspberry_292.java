
import java.util.Scanner;
public class BearAndRaspberry {

    
    public static void main(String[] args) 
    {
     Scanner in=new Scanner(System.in);
      int n=in.nextInt();
      int c=in.nextInt();
      int max=0;
      int ar[]=new int[n];
      
        for (int i = 0; i < n; i++) 
        {
            ar[i]=in.nextInt();
        }
        for (int i = 0; i < n; i++) 
        {
          if (i+1<n)
          {
              if (ar[i]-ar[i+1]>max)
              {
                  max=ar[i]-ar[i+1];
              }
          }
        }
        if (max-c>0)
        {
            System.out.println(max-c);
        }
        else
        {
            System.out.println(0);
        }
        
    }
    
}
