import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		while(true){
			int hour = stdIn.nextInt();
			int minute = stdIn.nextInt();
			int second = stdIn.nextInt();
			if(hour == -1 & minute == -1 & second == -1){
				break;
			}
			int tape = 7200 - 3600 * hour - 60 * minute - 1 * second;
			int tape3Times = tape * 3;
			System.out.println(String.format("%1$02d:%2$02d:%3$02d",(tape/3600),(tape%3600)/60,((tape%3600)%60)/1));
			System.out.println(String.format("%1$02d:%2$02d:%3$02d",(tape3Times/3600),(tape3Times%3600)/60,((tape3Times%3600)%60)/1));
		}
	}
}