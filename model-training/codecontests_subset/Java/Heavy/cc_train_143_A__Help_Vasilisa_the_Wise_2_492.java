
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Eslam Ashraf
 */
public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int r1 = in.nextInt(), r2 = in.nextInt();
        int c1 = in.nextInt(), c2 = in.nextInt();
        int d1 = in.nextInt(), d2 = in.nextInt();


        boolean exist = false;
        int a = 0 , b  = 0, c  = 0,d = 0;
        for (int i = 1; i <10 && !exist; i++) {
            for (int j = 1; j < 10 && !exist; j++) {
                for (int k = 1; k < 10 && !exist; k++) {
                    for (int l = 1; l < 10 && !exist; l++) {


                           if(i+j == r1 && i!=j  &&
                                   k+l == r2 && k!=l
                                   && i+k==c1 && i!=k
                                   && j+l==c2 && j!=l
                                   && i+l==d1 && i!=l
                                   && j+k==d2 && j!=k) {
                               a = i ; b = j ; c = k ; d = l ;
                               exist = true;
                           }




                    }

                }

            }

        }
        if(!exist)System.out.println("-1");
        else{
            System.out.println(a+" "+b);
            System.out.println(c+" "+d);
        }


    }
}
