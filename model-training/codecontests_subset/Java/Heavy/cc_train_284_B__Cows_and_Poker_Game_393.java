

import java.util.Scanner;

/**
 *
 * @author COMPUTER SHAHR
 */
public class Poker {

   
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s;
        
        int f = 0,a = 0 ,in = 0, n;
        n = input.nextInt();
        s = input.next();
        for (int i = 0; i < s.length(); i++) {
            if( s.substring(i, i + 1).equals("A")){
                a++;
            }
            else if( s.substring(i, i + 1).equals("F")){
                f++;
            }
            if( s.substring(i, i + 1).equals("I")){
                in++;
            }
            
            
        }
        if( in == 0){
            System.out.println(s.length() - f );            
        }
        else if( in == 1){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
}
