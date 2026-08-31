
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
public class Orange {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder();


        String x = in.readLine();
        int y = Integer.parseInt(in.readLine());


        for (char z : x.toCharArray()) {
            
            z = Character.toLowerCase(z);
              if (z < 97 +y) {
                str.append(Character.toUpperCase(z));
            } else {
                str.append(z);
            }
        }
        System.out.println(str.toString());

    }
}
