import java.util.*;

public class Stone{
    
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        
        int t = scan.nextInt(); // number of test cases
        
        for(int i=0; i<t; i++) {
            
            int a = scan.nextInt(); // pile 1
            int b = scan.nextInt(); // pile 2
            int c = scan.nextInt(); // pile 3
            
            int ans = 0;
            
            int numOp2 = Math.min(b, c/2);
            
            ans = numOp2*3;
            
            b = b - numOp2;
            
            int numOp1 = Math.min(a, b/2);
            
            ans = ans + numOp1*3;
            
            System.out.println(ans);
            
            /*
            while(c>=2 && b>=1) {
                c = c-2;
                b = b-1;
                ans = ans+3;
            }
            while(b>=2 && a>=1) {
                b = b-2;
                a = a-1;
                ans = ans+3;
            }
            
            System.out.println(ans);
            */
            
        }
        
    }
}