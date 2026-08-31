
import java.util.Scanner;


public class JavaApplication1 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
     
        int a = s.nextInt();
        int b = s.nextInt();
        int out = 0;
        int hours = 0;
        
        while(a > 0) {
            a--;
            hours++;
            out++;
            if(out==b) {
                out = 0;
                a++;
            }
            
        }
        
        System.out.println(hours);
    }
    
}

        

    

