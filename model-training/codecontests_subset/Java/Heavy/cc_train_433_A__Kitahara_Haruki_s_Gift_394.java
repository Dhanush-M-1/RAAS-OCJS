
import java.util.*;
public class Main
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int n200 = 0, n100 = 0;
        while(n-- > 0)
           if(input.nextInt() == 200) 
               n200++;
            else
               n100++;
        
        int i = 0;
        int friend1 = 0, friend2 =0;
        for(i = 0; i < n200; ++i)
        {
            if(friend1 <= friend2)friend1 += 200; 
            else
                friend2 += 200;
            
        }
        
        for(i = 0; i < n100; ++i)
        {
            if(friend1 <= friend2)friend1 += 100; 
            else
                friend2 += 100;
            
           
        }
        
     
        if(friend1 == friend2)System.out.println("YES");
        else
            System.out.println("NO");
    }
}
