
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author atindra.das
 */
public class Main {
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int temp = a*c-c*b;
        if(temp%b==0){
            System.out.println(temp/b);
        }
        else System.out.println((temp/b)+1);
    }
}
