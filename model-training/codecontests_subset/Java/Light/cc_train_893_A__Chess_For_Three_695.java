import java.util.*;

public class bloop{
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int numLines = reader.nextInt();
		String output = "YES";
		Map<Integer, Boolean> players = new HashMap<>();
		players.put(1, true);
		players.put(2, true);
		players.put(3, false);
		
		for(int count = 0; count<numLines; count++) {
			int winner = reader.nextInt();
			if(players.get(winner) == false) {
				output = "NO";
				break;
			}
			else {
				for(int i = 1; i<=3; i++) {
					if(i != winner) 
						players.put(i, !players.get(i));
				}
			}
		}
		System.out.println(output);
		reader.close();
	}
}