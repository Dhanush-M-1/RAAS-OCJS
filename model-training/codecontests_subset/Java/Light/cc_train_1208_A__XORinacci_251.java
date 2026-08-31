import java.util.*;
import java.util.Arrays;
public class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        
        int testCases = sc.nextInt();
        
        for(int i=0 ; i<testCases ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            
            if(n%3 == 2) {
                System.out.println(a^b);
            }
            else if(n%3 == 1) {
                System.out.println(b);
            }
            else if(n%3 == 0) {
                System.out.println(a);
            }
        }
        
        
        
    }
}

