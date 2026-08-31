import java.util.Scanner;

/**
 *
 * @author Фёдор
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();

        String line = in.next();
        int counter = 0;
        for(int i = n - 1; i > n - x - 1; i --){
           // System.out.println("DONE");
            if(i == n - y - 1 && line.charAt(i) != '1'){
                counter++;
                
               // System.out.println(line.charAt(i) + "!");
                continue;
            }
            if (i == n - y - 1) {
                continue;
            }
            if(line.charAt(i) == '1'){
                counter++;
               // System.out.println(line.charAt(i));
            }
           // System.out.println("DONE");
        }
        System.out.println(counter);
    }

}