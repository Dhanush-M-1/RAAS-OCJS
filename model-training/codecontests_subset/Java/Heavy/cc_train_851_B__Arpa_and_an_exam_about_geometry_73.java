import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
  public static Scanner scanner = new Scanner(System.in);
  
  public static double distance(int ax, int ay, int bx, int by) {
	return Math.sqrt(Math.pow(bx - ax, 2) + Math.pow(by - ay,2));
  }
  
  public static double slope(int ax, int ay, int bx, int by) {
    double top = by - ay;
    double down = bx - ax;
    return top/down;
  }
  
  public static void main(String[] args) {
    
    long x1,y1,x2,y2,x3,y3,k1,k2,d1,d2;
    while(scanner.hasNext()) {
      x1 = scanner.nextInt();
      y1 = scanner.nextInt();
      x2 = scanner.nextInt();
      y2 = scanner.nextInt();
      x3 = scanner.nextInt();
      y3 = scanner.nextInt();
      d1=(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
      d2=(x2-x3)*(x2-x3)+(y2-y3)*(y2-y3);
      if(d1!=d2) System.out.println("NO");
      else if((x2-x3)*(y1-y2)==(x1-x2)*(y2-y3)){
        System.out.println("NO");
      }
      else System.out.println("YES");
    }
  }
}
