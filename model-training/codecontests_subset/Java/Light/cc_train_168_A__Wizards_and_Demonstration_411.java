import java.util.*;

public class A{
    
    public static void main(String[] args){
        Scanner inp = new Scanner(System.in);
        
        int n = inp.nextInt();
        int x = inp.nextInt();
        int y = inp.nextInt();
        // p = y * n / 100 - x
        
        int p = (int)Math.ceil(((double) (y*n))/100 - (double)x);
        
        if (p > 0){
            System.out.println(p);
        }
        else{
            System.out.println("0");
        }
    }
}