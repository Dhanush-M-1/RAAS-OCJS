
import static java.lang.Math.abs;
import java.util.Scanner;

public class Square {

    
    public static void main(String[] args) {
      Scanner input =new Scanner(System .in);
      int x1=0,x2=0;
      x1=input.nextInt();
      x2=input.nextInt();
        int h= abs((x2-x1))/2;
  int  a=h;
    int b= abs((x2-x1))-h;
       
    int fac1=0,fac2=0;
        for (int i = 0; i <= a; i++) {
            fac1+=i;
        }
        for (int i = 0; i <= b; i++) {
            fac2+=i;
        }
        System.out.println(fac1+fac2);
    }
    
}
