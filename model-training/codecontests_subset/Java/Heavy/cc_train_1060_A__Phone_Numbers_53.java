
import com.sun.org.apache.bcel.internal.classfile.InnerClass;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author o-i-i-
 */
public class JavaApplication59 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();

        String str = in.next();
        if (str.contains("8") && x >= 11) {
            int z = x - str.replaceAll("8", "").length();
            x/=11;
            if (z<=x){
                System.out.println(z);
            }else {
                System.out.println(x);
            }

        } else {
            System.out.println("0");
        }
    }
}
