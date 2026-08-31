import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        int count = 0;
        int output = 0;
        while (line != null) {

            if (line.charAt(0) == '+') {
                count++;
            } else if (line.charAt(0) == '-') {
                count--;
            } else {
                int index = line.length() - line.indexOf(':') - 1;
                output += index*count;
            }

            line = in.readLine();
        }
        System.out.println(output);
    }
}