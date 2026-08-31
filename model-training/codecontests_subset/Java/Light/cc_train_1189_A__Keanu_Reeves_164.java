//package keanureeves;
import java.util.Scanner;
/**
 *
 * @author Roundabout
 */
public class KeanuReeves {
    public static void main(String[] args) {
        Scanner breathtaking = new Scanner(System.in);
        int n = breathtaking.nextInt();
        breathtaking.nextLine();
        String s = breathtaking.nextLine();
        if(n%2 != 0){
            System.out.println(1);
            System.out.println(s);
            return;
        }
        
        if(isGood(s, n)){
            System.out.println(1);
            System.out.println(s);
            return;
        }
        
        System.out.println(2);
        System.out.println(s.substring(0, n-1) + " " + s.charAt(n-1));
        
    }
    static boolean isGood(String s, int n){
        int n0 = 0, n1 = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '0'){
                n0++;
            }else{
                n1++;
            }
        }
        return (n0 != n1);
    }
}