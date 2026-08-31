
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by joshua on 3/25/15.
 */
public class ChatServersOutgoingTraffic {

	public static void main(String[] args) throws IOException
	{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String temp = new String();
		ArrayList<String> people = new ArrayList<>();
		int maxSize = 0;

		int trafficAmount = 0;
		while((temp = console.readLine()) != null)
		{
			if(temp.charAt(0) == '+') {
				people.add(temp.substring(1));
			}
			else if(temp.charAt(0) == '-') {
				people.remove(temp.substring(1));
			}
			else {
				if(temp.charAt(temp.length()-1) != ':') {
					String[] sendMessage = temp.split(":");
					trafficAmount += sendMessage[1].length() * people.size();
				}
			}
		}

		console.close();
		System.out.println(trafficAmount);
	}
}
