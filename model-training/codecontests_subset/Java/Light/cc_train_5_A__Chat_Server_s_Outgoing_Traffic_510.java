import java.util.Scanner;
public class AChatServer {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String input=null;
		int msgLength;
		int serverTraffic = 0;
		int activeUsers = 0;
		while(in.hasNext()) {
			input = in.nextLine();
			if(input.startsWith("+")) {
				activeUsers++;
			}else if(input.startsWith("-")) {
				activeUsers--;
			}else {
				msgLength = input.substring(input.indexOf(":")+1).length();
				serverTraffic = serverTraffic + msgLength * activeUsers;
			}
		}
		
		System.out.println(serverTraffic);

	}

}
// 1519855456807
