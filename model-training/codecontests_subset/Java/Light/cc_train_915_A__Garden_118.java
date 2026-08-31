import java.util.*;

public class m{

public static void main(String args[])
{
    Scanner sc=new Scanner(System.in);
    
    int n=sc.nextInt();
    
    int l=sc.nextInt();
    
    int ans=10000000;
    
    
    while(n-->0)
    {
        int x=sc.nextInt();
        
        if(l%x==0)
        {
            ans=Math.min(ans,l/x);
        }
        
        
    }
    
    System.out.println(ans);
    
    
    
    
}

  
}