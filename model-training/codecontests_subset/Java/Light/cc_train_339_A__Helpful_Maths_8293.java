
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author houssem
 */
public class HelpfulMaths {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic her
        Scanner sc = new Scanner(System.in);
        String ch = sc.nextLine();
        int x1 = 0, x2 = 0, x3 = 0;
        for (int i = 0; i < ch.length(); i++) {
            switch (ch.charAt(i)) {
                case '1':
                    x1++;
                    break;
                case '2':
                    x2++;
                    break;
                case '3':
                    x3++;
                    break;
            }
        }
        String ch2 = "";
        for (int i = 0; i < x1; i++) {
            ch2 += "1+";

        }
        for (int i = 0; i < x2; i++) {
            ch2 += "2+";

        }
        for (int i = 0; i < x3; i++) {
            ch2 += "3+";

        }
        System.out.println(ch2.substring(0, ch2.length() - 1));

    }

}
