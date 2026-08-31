import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Message {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
		//DataInputStream d = new DataInputStream(new BufferedInputStream(System.in));
		int count = 0;
		int cost = 0;
		String str = null;
		
		while ((str = br.readLine()) != null && str.length() != 0){
			//String str = sc.nextLine();
			//str = br.readLine();
			
			if (str.startsWith("+")) {
				count++;
			} else if (str.startsWith("-")) {
				count--;
			} else {
				cost += (count) * (str.length()- 1 - str.indexOf(":"));
			}
			//System.out.println(cost);
		}
		//br.close();
		System.out.println(cost);
	}

}
