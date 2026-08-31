import java.util.Scanner;



public class Remainder {
   static int n;
   static int x;
   static int y;
   static int c = 0;
   static String number;
 public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        x = in.nextInt();
        y = in.nextInt();
        number = in.next();
        
        int num = n - y;
        //System.out.println(number.charAt(n - x ));
        //System.out.println(number.charAt(num -1));
        for (int i = n -  x ; i < n ;i++){
        if (number.charAt(i) == '1' && i != num - 1){
        c +=1;}
        }if (number.charAt(num - 1) == '0'){
        c +=1;
        }
        System.out.println(c);
        
        
 }
    
    
}
