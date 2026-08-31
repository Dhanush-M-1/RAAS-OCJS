import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CowsandPokerGame {
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int players = Integer.parseInt(br.readLine());
			String poke = new String(br.readLine());
			//AFAFFAAF
			if(poke.indexOf("I") != -1){
				if(poke.lastIndexOf("I") == poke.indexOf("I")){
					System.out.println(1);
					return;
				}
				else{
					System.out.println(0);
					return;
				}
			}
			else{
				poke = poke.replaceAll("F", "");
				System.out.println(poke.length());
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
