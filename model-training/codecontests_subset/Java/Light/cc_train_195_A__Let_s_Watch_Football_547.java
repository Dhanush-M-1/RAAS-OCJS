import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Avinash
 * Date: 18/8/12
 * Time: 10:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[]args){
         Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();int b=sc.nextInt();int c=sc.nextInt();
        System.out.print((c*(a-b)-1)/b +1);


    }
}
