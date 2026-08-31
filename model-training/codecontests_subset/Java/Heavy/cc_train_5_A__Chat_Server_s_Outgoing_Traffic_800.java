import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CF5A {
    public static void main(String... args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer trafficSize = 0;
        List<String> nicknames = new ArrayList<String>();
        String command;
        while ((command = bufferedReader.readLine()) != null && command.length() > 0) {
            if (command.startsWith("+")) {
                nicknames.add(command.substring(1));
            } else {
                if (command.startsWith("-")) {
                    nicknames.remove(command.substring(1));
                } else {
                    trafficSize += command.substring(command.indexOf(":") + 1).length() * nicknames.size();
                }
            }
        }
        System.out.print(trafficSize);
    }
}
