
import java.util.*;
public class hikk {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        int t = scan.nextInt();
        while(t-->0){
            long a = scan.nextLong(), b = scan.nextLong(), n = scan.nextLong();
            n = n%3;
            if(n == 0){System.out.println(a);}
            else if(n == 1){System.out.println(b);}
            else{System.out.println(a^b);}
        }
    }
}
