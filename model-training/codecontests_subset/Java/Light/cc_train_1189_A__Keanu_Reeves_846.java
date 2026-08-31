import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class problem {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        char[] string = reader.readLine().toCharArray();

        int onecounter = 0;
        int zerocounter = 0;

        for (int i = 0; i < string.length; i++) {
            if (string[i] == '1') {
                onecounter++;
            } else {
                zerocounter++;
            }
        }

        if (onecounter == zerocounter) {
            writer.println(2);
            writer.print(string[0]);
            writer.print(" ");
            for (int i = 1; i < string.length; i++) {
                writer.print(string[i]);
            }
        } else {
            writer.println(1);
            for (int i = 0; i < string.length; i++) {
                writer.print(string[i]);
            }
        }

        writer.close();


    }


}
