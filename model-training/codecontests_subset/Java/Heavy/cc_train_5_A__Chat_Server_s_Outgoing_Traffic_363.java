
//highlight: kako čitati input u Javi do kraja: morat ćemo sami poslati EOF na kraju (na Windowsima CTRL+z), pogledaj kako je petlja napravljena, samo tako radi, nije radilo kad sam u vanjski WHILE stavio uvjet s.hasNextLine()
import java.util.Scanner;

public class ChatServersOutgoingTraffic_5A {
	public static void main(String[] args) {
		int count = 0;
		Scanner s = new Scanner(System.in);
		int beginIndex, endIndex;
		String command;
		int persons = 0;
		while (true) {
			if (s.hasNextLine()) {
				command = s.nextLine();
				if (command.startsWith("+")) {
					persons++;
				} else if (command.startsWith("-")) {
					persons--;
				} else {
					beginIndex = command.indexOf(':') + 1;
					endIndex = command.length();
					if (beginIndex >= endIndex) {
						continue;
					}
					count += persons * command.substring(beginIndex, endIndex).length();
				}
			} else {
				break;
			}
		}
		System.out.println(count);
	}
}
