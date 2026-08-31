
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author N-AssassiN
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int A = 0, I = 0;
        String s = scanner.next();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                A++;
            } else if (s.charAt(i) == 'I') {
                I++;
            }
        }
        if (I > 1) {
            System.out.println("0");
        } else if (I == 1) {
            System.out.println("1");
        } else {
            System.out.println(A);
        }
    }
}
