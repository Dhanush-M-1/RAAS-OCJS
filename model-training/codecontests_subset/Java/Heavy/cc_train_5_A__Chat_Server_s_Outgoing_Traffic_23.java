import java.util.Scanner;

public class ChatServersOutgoingTraffic {


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int bytes = 0; // Amount of outgoing traffic.
		int users = 0; // Number of current users.
		int count = 0;
		while (scan.hasNextLine())
		{
			String line = scan.nextLine();
			if (line.length() > 0)
			{
				if (line.charAt(0) == '+')
				{
					users++;
				}
				else if (line.charAt(0) == '-')
				{
					users--;
				}
				else
				{
					String message = line.substring(line.indexOf(":")+1);
					bytes = bytes + message.length() * users;
				}
			}
			count++;
		}
		System.out.println(bytes);

	}

}
