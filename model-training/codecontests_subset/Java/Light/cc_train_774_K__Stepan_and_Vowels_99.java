import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();

            line = line.replaceAll("u+", "u");
            line = line.replaceAll("a+", "a");
            line = line.replaceAll("i+", "i");
            line = line.replaceAll("y+", "y");
            line = line.replaceAll("ooo+", "o");
            line = line.replaceAll("eee+", "e");

            System.out.println(line);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
