import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class VideoScratch {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] input = reader.readLine().split("\\s");
            
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
 
            writer.write(String.valueOf(timeToWait(a, b, c)));
        }
    }
 
    static int timeToWait(int a, int b, int c) {
        int bad = 0;
        int good = a * c / b;
 
        while (good - bad > 1) {
            int t = (good + bad) / 2;
            if (isEnough(a, b, c, t)) {
                good = t;
            } else {
                bad = t;
            }
        }
 
        return good;
    }
 
    private static boolean isEnough(int a, int b, int c, int t) {
        return (t + c) * b >= a * c;
    }
}