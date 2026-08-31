
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input;
        char[] c;
        char swap;
        boolean notSwaped;

        Scanner in = new Scanner(System.in);
        input = in.nextLine();

        c = input.toCharArray();
        for (int j = 0; j < input.length(); j++) {
            notSwaped = true;
            for (int i = 0; i < input.length() - 2; i++) {
                if (c[i] == '+') {
                } else if (c[i + 2] < c[i]) {
                    swap = c[i];
                    c[i] = c[i + 2];
                    c[i + 2] = swap;
                    notSwaped = false;
                }
            }
            if(notSwaped){break;}
        }

        input = new String(c);

        System.out.println(input);
    }
}
