import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String line = null;
        int l = 0;
        int r = 0;
        while ((line = reader.readLine()) != null) {           
            String[] split = line.split(" ");
            l = Integer.parseInt(split[0]);
            r = Integer.parseInt(split[1]);
        }
        int answer = 0;
        if (l == r) {
            int bound = (int) Math.sqrt(l);
            if (bound <= 3) {
                answer = l;               
            }
            for (int ii = 3; ii < bound; ii++) {              
                if (l % ii == 0) {
                    answer = ii;
                    break;
                }
                if (ii == bound - 1) {
                    answer = l;
                    break;
                }
            }
            writer.write(answer + "");
        } else{
            writer.write("2");
        }
        writer.newLine();
        writer.flush();
    }
}   