

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Jamshed
 * Date: 4/18/12
 * Time: 9:12 AM
 */
public class ProblemA implements Runnable {

    BufferedReader br;

    public static void main(String arguments[]) {
        new Thread(new ProblemA()).start();
    }

    public void solution() throws IOException {
        String line = null;

        int result = 0;
        int counter = 0;

        while((line = br.readLine()) != null) {

            if(line.charAt(0) == '+') {
                counter++;
            } else if(line.charAt(0) == '-') {
                counter--;
            } else {
                result += (line.length() - line.indexOf(':') - 1) * counter;
            }

        }

        System.out.println(result);
    }

    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            solution();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
