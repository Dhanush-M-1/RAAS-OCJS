
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
        StringBuilder s = new StringBuilder(scanner.nextLine());
        int a = scanner.nextInt();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.toLowerCase(c) - 'a' < a) {
                s.setCharAt(i, Character.toUpperCase(s.charAt(i)));
            } else {
                s.setCharAt(i, Character.toLowerCase(s.charAt(i)));
            }
        }
        System.out.println(s);
    }
}
