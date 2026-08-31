import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		byte colorHome, colorGuest, numberOfTeams = sc.nextByte();
		short numberOfGames = 0;
		byte[] homeColors  = new byte[numberOfTeams];
		byte[] guestColors = new byte[numberOfTeams];
		
		for(byte i =0; i < numberOfTeams; i++){
			colorHome  = sc.nextByte();
			colorGuest = sc.nextByte();
			homeColors[i]  = colorHome;
			guestColors[i] = colorGuest;
		}
		
		for(byte i =0; i < numberOfTeams; i++){
			for(byte j=0; j < numberOfTeams; j++){
				if(homeColors[i] == guestColors[j]){
					numberOfGames+=1;
				}
			}
		}
		
		System.out.println(numberOfGames);
	}

}
