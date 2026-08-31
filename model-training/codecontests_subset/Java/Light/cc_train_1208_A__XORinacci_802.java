import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
public class Main
{
    public static void main(String[] args) 
    {
        
        Scanner ab=new Scanner(System.in);
        int x=ab.nextInt();
        while(x>0)
        {
            int a=ab.nextInt(),b=ab.nextInt(),c=ab.nextInt();
            
            c%=3;
            if(c==0)System.out.println(a);
            else if(c==1)System.out.println(b);
            else System.out.println(a^b);
            x--;
        }
        
        
        
    }
    
}
