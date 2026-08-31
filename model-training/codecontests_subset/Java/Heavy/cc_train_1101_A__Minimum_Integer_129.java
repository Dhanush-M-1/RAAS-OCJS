// javaapplication73;
import java.util.*;
public class JavaApplication73 {
    public static void main(String[] args) {
        
       Scanner r=new Scanner(System.in);
       int t=r.nextInt();
        
        
        while(t>0)
        {
          //  System.out.println("hi");
            int cv=r.nextInt();
            int vb=r.nextInt();
            int sd=r.nextInt();
            
            int p=0;
            
            
             if(sd==1)
            {
                if(cv!=1)
                {
                    System.out.println(1); 
                }
                else
                     System.out.println(vb+1);
            }
             
             
            if(sd!=1)
            {
                
                
            if(sd>vb)
            {
                System.out.println(sd);
                p=1;
               // break;
            }
                
                
            if(sd<=vb)    
            //for(;;)
            //{
              if(cv>sd)
             {
                 System.out.println(sd); 
                 p=1;
                // break;
             }
             else if(cv==sd)
             {
                int w=vb/sd;
                for(;;)
                {
                int sum=w*sd;
                if(sum>vb)
                {
                    System.out.println(sum);
                    p=1;
                    break;
                }
                else
                {
                    w++;
                }
                }
             }
             
          //  }
            
            
            
            
           
            
            
            
            
            if(p==0)
            {
                int w=vb/sd;
                for(;;)
                {
                int sum=w*sd;
                if(sum>vb)
                {
                    System.out.println(sum);
                    break;
                }
                else
                {
                    w++;
                }
                }
                
            }
            }
            
           t--; 
            
        }
    }
    
}
