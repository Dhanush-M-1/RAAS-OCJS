
import java.util.Scanner;


public class WizardsAndDemonstration {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner (System.in);
        
        int n = input.nextInt();
        int x = input.nextInt();
        int y = input.nextInt();
        
        int p = (int) Math.ceil((double)n * y / 100);
        
        if(x >= p)
            System.out.println("0");
        else
            System.out.println(p - x);
    }
    
}
