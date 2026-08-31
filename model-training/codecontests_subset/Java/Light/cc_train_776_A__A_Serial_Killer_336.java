
import java.util.Scanner;

import static sun.swing.MenuItemLayoutHelper.max;

public class Main {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        String a= in.next();
        String b = in.next();

        int n = in.nextInt();


        System.out.println(a+" "+b);
        for(int i = 1;i<n+1;i++){
           String murdered = in.next();
           String replaced = in.next();

            if(murdered.equals(a)){
                a = replaced;
            }else{
                b = replaced;
            }
            System.out.println(a+" "+b);
        }



    }

}