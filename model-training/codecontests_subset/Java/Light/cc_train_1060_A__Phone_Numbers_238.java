
import java.util.Scanner;


public class Ew {

    public static void main(String[] args) {
  Scanner in = new Scanner(System.in);
  int n = in.nextInt(),p=0;
  String s=in.next();
        for (int i = 0; i < n; i++) {
            if(s.charAt(i)=='8')
            {p++;}
        }
        System.out.println(Math.min(p, n/11));
  
    }
    
}
