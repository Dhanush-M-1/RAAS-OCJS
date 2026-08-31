import java.util.Scanner;

/**
 *
 * @author stanislav.svorovsky
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int max = 0;
//        int[] arr = new int[1000000];
//        
//        for (int i = 0; i < 1000000; i++) {
//            arr[i] = 0 ;
//        }
        for (int i = 0; i < n; i++) {
            int index = in.nextInt();
            index --;
            if (index == 499999) {
                System.out.print(499999);
                return;
            }
            if (index < 499999) {
                if (max < index) {
                    max = index;
                }
            }
            if (index > 499999) {
                if (max < 999999 - index) {
                    max = 999999 - index;
                }
            }
        }
        
        System.out.print(max);

        // TODO code application logic here
    }

}