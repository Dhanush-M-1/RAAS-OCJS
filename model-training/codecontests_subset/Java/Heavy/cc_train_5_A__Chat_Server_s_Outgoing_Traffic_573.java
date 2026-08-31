import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * Created with IntelliJ IDEA. User: qchen Date: 10/1/14 Time: 6:27 PM To change this template use File | Settings |
 * File Templates.
 */
public class ChatOutgoingTraffic
{
  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    Set<String> users = new HashSet<String>();
    int count = 0;
    while(stdin.hasNextLine()) {
      String line = stdin.nextLine();
      if(line.startsWith("+")) {
        users.add(line.substring(1));
      } else if(line.startsWith("-")) {
        users.remove(line.substring(1));
      } else {
        String[] send = line.split(":");
        if(send.length == 2) {
          count += users.size() * send[1].length();
        }
      }
    }
    System.out.println(count);
  }
}
