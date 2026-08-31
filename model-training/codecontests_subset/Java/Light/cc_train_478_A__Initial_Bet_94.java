import java.util.Scanner;

public class Main
{  public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c = 0;
        
        for (int i = 0; i < 5; i++) {
        	c += in.nextInt();
        }
        
        if (c % 5 == 0 && c / 5 != 0) {
        	System.out.println(c / 5);
        }
        else {
        	System.out.println(-1);
        }
        
	}
}