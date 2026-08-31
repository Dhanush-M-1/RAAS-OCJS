import java.util.*;
public class Main
{
    public static void main(String []argument) throws Exception
    {
         Scanner sc=new Scanner(System.in);
         int n1,x1,y1;String num;
         n1=sc.nextInt(); 
         x1=sc.nextInt();
         y1=sc.nextInt();
         int n,x,y,count=0;
        num=sc.next();
        for(int i=n1-1;i>=n1-x1;i--)
        {
            if(i>n1-y1-1)
            {
                if(num.charAt(i)=='1')
                count++;
                 
            }
           else if(i==n1-y1-1)
            {
                if(num.charAt(i)=='0')
                count++;
                
            }
            else
            {
                if(num.charAt(i)=='1')
                count++;
                
                
            }
            
            
            
            
        }
        
        System.out.println(count);   
           
           
         
         
         
    }
    
    
    
    
    
}