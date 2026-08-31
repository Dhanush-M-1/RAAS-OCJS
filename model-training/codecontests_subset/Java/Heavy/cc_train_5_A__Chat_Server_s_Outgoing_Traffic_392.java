import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FiveA {
    public static void main(String[] args) throws IOException {
        BufferedReader readInput = new BufferedReader(new InputStreamReader(System.in));
        String command;
        int peopleInChannel = 0;
        int bytesSoFar = 0;
        while((command = readInput.readLine()) != null && command.length() != 0) {
            char identifier = command.charAt(0);
            if(identifier == '+') peopleInChannel++;
            else if(identifier == '-') peopleInChannel--;
            else {
                int messageStart = command.indexOf(':');
                int numBytes = peopleInChannel * (command.length() - messageStart - 1);
                bytesSoFar += numBytes;
            }
        }
        System.out.println(bytesSoFar);
    }
}
