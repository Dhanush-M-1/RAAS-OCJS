import java.util.Scanner;

public class Chat_Servers_Outgoing_Traffic {

    public static void main(String[] args) {
	Scanner scn = new Scanner(System.in);

	int active = 0, bytes = 0;
	while (scn.hasNextLine()) {
	    String line = scn.nextLine();
	    char first = line.charAt(0);
	    if (first == '+')
		active++;
	    else if (first == '-')
		active--;
	    else {
		bytes += line.substring(line.indexOf(":") + 1).length() * active;
	    }
	}
	System.out.println(bytes);
	scn.close();
    }

}