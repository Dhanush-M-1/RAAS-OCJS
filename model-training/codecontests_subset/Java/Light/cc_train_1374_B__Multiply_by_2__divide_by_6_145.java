import java.util.Scanner;
public class JavaApplication12 {
    public static void main(String[] args) {
         int t,n,count;
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        while(t-- > 0)
        {
             count=0;
              n=sc.nextInt();
               System.out.println(ans(n));    
            
        }
                  
    }
    public static int ans(int n)
    {
        int count=0;
        while(n >=1)
        {
            if(n == 1)
                return count;
            if(n / 6 == 1 && (n%6 == 0))
            {
                count++;
                return count;
            }
           else if(n % 6 == 0)
           {
                count++;
                n=n/6; 
           }
           else
           {  
                n=n*2;
                count++;
                if(n / 6 == 1 && n% 6==0)
                {
                  count++;
                  return count;
                }
               else if(n % 6 == 0)
               {
                   count++;
                   n=n/6; 
               }
               else return -1;
                
           }
        }
           
        return count;
    }
    
}
