
import java.util.Scanner;
public class A_Minimum_Integer {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int l,r,d;
        
        while(n>=1){
            l = in.nextInt();
            r = in.nextInt();
            d = in.nextInt();
            if(d<l)
                System.out.println(d);
            else{
                if((r+1)%d!=0){
                    int x = ((r+1)/d)+1;
                    System.out.println(x*d);
                
                }
                else
                    System.out.println(r+1);
            }
            n--;
        }
 
    }
}
