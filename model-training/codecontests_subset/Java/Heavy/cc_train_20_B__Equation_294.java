import java.util.Scanner;
import java.math.BigDecimal;

public class Uravnenie{
  public static void main (String[] args){
    Scanner input = new Scanner (System.in);
    double A = input.nextInt();
    double B = input.nextInt();
    double C = input.nextInt();

    if (A == 0 && B==0 && C==0){
      System.out.println(-1);
    }
    else if (A == 0 && B==0){
      System.out.println(0);
    }
    else if (A == 0){
      System.out.println(1);
      double x = ((-C)/B);
      BigDecimal xO = new BigDecimal(x);
      System.out.println(xO.setScale(6,BigDecimal.ROUND_HALF_EVEN));
    }
    else if ((A == 0 && C == 0)||(B == 0 && C == 0)){
      System.out.println(1);
      System.out.println(0);
    }
    else if ((Math.pow(B,2) - 4 * A * C) < 0){
      System.out.print(0);
    }
    else if ((Math.pow(B,2) - 4 * A * C) == 0){
      System.out.println(1);
      BigDecimal x = new BigDecimal(-B/(2*A));
      System.out.println(x.setScale(6,BigDecimal.ROUND_HALF_EVEN));
    }
    else{
      System.out.println(2);
        double x1 = (-B + Math.sqrt(Math.pow(B,2) - 4*A*C))/(2*A);
        double x2 = (-B - Math.sqrt(Math.pow(B,2) - 4*A*C))/(2*A);
        BigDecimal x3 = new BigDecimal(x1);
        BigDecimal x4 = new BigDecimal(x2);
      if (x1 > x2){
        System.out.println(x4.setScale(6,BigDecimal.ROUND_HALF_EVEN));
        System.out.println(x3.setScale(6,BigDecimal.ROUND_HALF_EVEN));
      }
      else {
        System.out.println(x3.setScale(6,BigDecimal.ROUND_HALF_EVEN));
        System.out.println(x4.setScale(6,BigDecimal.ROUND_HALF_EVEN));
      }
    }
  }
}
