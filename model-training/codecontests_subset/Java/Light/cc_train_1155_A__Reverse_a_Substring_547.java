
import java.util.Scanner;

/**
 *
 * @author kiendthe130795
 */
public class ReverseASubstring {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean find = false;
        int n;
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        String s1;
        s1 = sc.nextLine();
        for(int i=1; i<n; i++) {
            if(s1.charAt(i-1) > s1.charAt(i)) {
                System.out.println("YES\n"+(i)+" "+(i+1));
                find = true;
                break;
            }
        }
        if(find == false) System.out.println("NO");
    }   
}
