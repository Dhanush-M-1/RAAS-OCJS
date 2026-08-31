
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author anhnth37
 */
public class A_0931 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int aTiredness = 1;
        int bTiredness = 1;
        int r = 0;
        while (a != b) {
            if (a < b) {
                if (b - a == 1) {
                    r += aTiredness;
                    a++;
                    aTiredness++;
                } else {
                    r += aTiredness + bTiredness;
                    a++;
                    b--;
                    aTiredness++;
                    bTiredness++;
                }
            } else {
                if (a - b == 1) {
                    r += bTiredness;
                    b++;
                    bTiredness++;
                } else {
                    r += bTiredness + aTiredness;
                    b++;
                    a--;
                    aTiredness++;
                    bTiredness++;
                }
            }
        }
        
        System.out.println(r);
    }
}
