import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String[] data = input.readLine().split("\\+");

        Arrays.sort(data);

        for(int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
            if(i < data.length - 1) {
                System.out.print("+");
            }
        }

        System.out.println();

    }

}
