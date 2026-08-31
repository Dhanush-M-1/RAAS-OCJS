


import java.util.Scanner;

/**
 *
 * @author noflaxe
 */
public class Codeforces2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Scanner scan = new Scanner(System.in);
     double n = scan.nextInt();
     double x = scan.nextInt();
     double y = scan.nextInt();
     int number = 0;
     double needed = (n*y)/100;
     
     while((number+x) < needed)
     {
     number++;
     }
    System.out.println(number);
    }
}
