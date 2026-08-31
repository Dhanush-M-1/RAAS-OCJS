//package practice_on_java;
import java.util.Scanner;

public class Chapter_1 {
    
    public static void main(String[] args) {
      
        //Declare Scanner object for input
        Scanner input = new Scanner(System.in);
        
        int t = input.nextInt();
        int [] maxes = new int [t];
        
        for(int i = 0 ; i < t ; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();
            int max = 0 , k = 0;
            if(b != 0){
            k = c / 2;
            if(k >= b){
                max = b * 2 + b;
                b = 0;
            }
            else{
                max = k * 2 + k;
                b -= k;
            }
            
            if(b >= 2 && a >= 1){
                k = b / 2;
                if(k >= a){
                    max += a * 2 + a;
                    a = 0;
                }
                else{
                    max += k * 2 + k;
                }
                
             }
            }
            
            maxes[i] = max;
        }
        
        //output
        for(int i = 0 ; i < t ; i++)
            System.out.println(maxes[i]);
    }
    
}
