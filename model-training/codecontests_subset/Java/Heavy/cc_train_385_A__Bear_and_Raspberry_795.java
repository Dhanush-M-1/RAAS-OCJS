
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] str = reader.readLine().split(" ");
            int d = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);

            str = reader.readLine().split(" ");
            int[] arr = new int[str.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            int min = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                int temp = arr[i] - arr[i + 1] - k;
                if (temp > min) {
                    min = temp;
                }
            }
            System.out.println(min);
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
