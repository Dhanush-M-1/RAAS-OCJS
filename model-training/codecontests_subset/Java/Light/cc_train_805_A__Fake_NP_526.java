
import java.util.Scanner;

/**
 * @author <a href="mailto:sunyt@hzwesoft.com">sunyt</a>
 * @version v 0.1 2017年05月16日12点30分
 */


public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int l = in.nextInt();
        int r = in.nextInt();

        if( r - l >= 2 ){
            System.out.println("2");
        }else{
            System.out.println(l);
        }

    }

}
