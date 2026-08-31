import java.io.*;
import java.util.*;


public class Driver {

    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> hash = new HashMap<>();
        int biteTotal = 0;

        while(sc.hasNext()) {
     		String command = sc.nextLine();

     		if (command.charAt(0) == '+') {
     			if (!hash.containsKey(command.substring(1))) {
     				hash.put(command.substring(1), 1);
     			}
     		}

     		else if (command.charAt(0) == '-') {
				if (hash.containsKey(command.substring(1))) {
     				hash.remove(command.substring(1));
     			}
     		}

     		else {
				String[] message = command.split(":");
				if (message.length > 1) 
					biteTotal += message[1].length() * hash.size(); 
     		}
        }

        System.out.println(biteTotal);
    }
}
