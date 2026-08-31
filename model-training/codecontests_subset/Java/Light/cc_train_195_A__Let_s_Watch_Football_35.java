/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sachin
 */
import java.util.Scanner;
public class A195 {

    public static void main(String args[])
    {
        Scanner input=new Scanner(System.in);
        int a=input.nextInt();
        int b=input.nextInt();
        int c=input.nextInt();
        System.out.println((int)(Math.ceil(a*c*1.0/b)-c));
    }
}
