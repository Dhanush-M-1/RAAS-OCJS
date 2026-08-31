
import java.util.Scanner;


public class Bulbs {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner (System.in);
        
        int n = input.nextInt();
        int m = input.nextInt();
        
        boolean [] array = new boolean [m];
        
        for(int i = 0 ; i < n ; i++)
        {
            int x = input.nextInt();
            
            for(int j = 0 ; j < x ; j++)
                array[input.nextInt()-1] = true;
        }
        
        boolean b = true;
        
        for(int i = 0 ; i  < m ; i++)
            if(!array[i])
            {
                b = false;
                break;
            }
        
        if(b)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
    
}
