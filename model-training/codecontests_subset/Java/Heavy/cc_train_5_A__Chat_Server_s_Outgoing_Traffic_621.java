import java.util.*;
import java.io.*;

public class Driver {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int chatSize = 0;
        long messageLength = 0;
        int traffic = 0;

        while((line = br.readLine()) != null) {
            if(line.charAt(0) == '+') {
                chatSize++;
            }
            else if(line.charAt(0) == '-') {
                chatSize--;
            }
            else {
                /**
                * If our message isn't empty, add it to the traffic * chatSize
                */
                String[] message = line.split(":");
                if(message.length > 1) {
                    traffic += message[1].length() * chatSize;
                }
            }
        }

        System.out.println(traffic);
        System.exit(0);
    }
}