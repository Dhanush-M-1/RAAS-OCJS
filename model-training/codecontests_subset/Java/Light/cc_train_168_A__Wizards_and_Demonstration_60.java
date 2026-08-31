
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CF_Chores {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        int x = s.nextInt();
        int y = s.nextInt();
        
        int c = 0;
        while(true){
            int wiz = x + c;
            if((1.0*wiz)/n>=1.0*y/100.0){
                System.out.println(c);
                return ;
            }
            c++;
        }
    }
    
    
}
