/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chris
 */
import java.util.*;

public class Codetest {

    public static void main(String args[]) {
        
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        
        int out = 0;
        int hours = 0;
        
        while (a > 0) {
            out++;
            if (out == b) {
                out = 0;
                a++;
            }
            a--;
            hours++;
        }
        
        System.out.println(hours);
        
    }
}
