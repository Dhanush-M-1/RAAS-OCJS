import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input;
        int chatters = 0;
        int totalTraffic = 0;
        while ((input = br.readLine()) != null) {
            if (input.length() > 0) {
                if (input.charAt(0) == '+') {
                    chatters++;
                } else if (input.charAt(0) == '-') {
                    chatters--;
                } else {
                    String[] message = input.split(":");
                    if (message.length > 1) {
                        totalTraffic += message[1].length()*chatters;
                    }
                }
            } else {
                break;
            }
        }
        
        System.out.println(totalTraffic);

    }

}
