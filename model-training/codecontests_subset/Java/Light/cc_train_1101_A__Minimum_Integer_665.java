import java.util.*;
public class MyClass {
    public static void main(String args[]) 
    {
     Scanner sc = new Scanner(System.in);
     int q=sc.nextInt();
     while(q-- > 0)
     {
         int l =sc.nextInt();
         int r=  sc.nextInt();
         int d=sc.nextInt();
       //  int copy=d;
        if( d<l || d >r)
        {
            System.out.println(d);
            continue;
        }
        else
        {
             System.out.println(((r/d)+1)*d);
            continue;
        }
         
         
     }
     
       
    
     
    }
}