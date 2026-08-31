import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

    public class OutgoingTraffic {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String curCommand;
        int totalTraffic = 0;
        Set<String> participants = new HashSet<>();
        while((curCommand = bufferedReader.readLine()) != null) {
            if(curCommand.length() == 0) break;
            if(curCommand.charAt(0) == '+') {
                participants.add(curCommand.substring(1));
            } else if(curCommand.charAt(0) == '-'){
                participants.remove(curCommand.substring(1));
            } else {
                String[] messageWithSender = curCommand.split(":");
                totalTraffic = totalTraffic + (participants.size() * (messageWithSender.length == 2 ? messageWithSender[1].length() : 0));
            }
        }
        bufferedReader.close();
        System.out.println(totalTraffic);
    }
}
