import java.io.IOException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    Integer citizens = scan.nextInt();
    Integer wizards = scan.nextInt();
    Integer percent = scan.nextInt();
    double percentage = percent * 0.01;
    double target = citizens * percentage;
    Integer targetRounded = (int) Math.ceil(target);
    Integer needed = targetRounded - wizards;
    if (needed <= 0) {
      System.out.println(0);
    } else {
      System.out.println(needed);
    }
  }

}
			 		    						 				    				