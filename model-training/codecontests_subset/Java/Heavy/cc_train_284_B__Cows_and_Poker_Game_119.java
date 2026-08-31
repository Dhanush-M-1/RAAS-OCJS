
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 11x256
 */
public class CowsandPokerGame {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String k = in.readLine();

        int count = 0;
        int res = 0;;
        for (int i = 0; i < n; i++) {
            if (k.charAt(i) == 'I') {
                count++;
            }

            if (k.charAt(i) == 'A') {
                res++;
            }
        }

        if (count > 1) {
            System.out.println("0");
            return;
        }

        if (count == 0) {
            System.out.println(res);
        }

        if (count == 1) {
            System.out.println(1);
        }


    }
}
