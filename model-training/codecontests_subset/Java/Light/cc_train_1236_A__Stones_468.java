

import java.util.Scanner;


public class JavaApplication75 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        while(x != 0){
            x--;
            
        int pile1 = sc.nextInt();
        int pile2 = sc.nextInt();
        int pile3 = sc.nextInt();
        int res =0;
        while(pile2 >= 1 && pile3 >=2){
         res +=3;
         pile2 -=1; pile3 -=2;
        } 
        while(pile1 >=1 && pile2 >=2){
          res +=3;
          pile1 -=1; pile2 -=2;
        } 
        
        System.out.println(res);
        }

        
        
    }
    
}
