 


import java.util.Scanner;

public class A5 {

	public static void main(String[] args) {

		int total = 0;
		int wait = 0;
		String command = "";
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			command = sc.nextLine();
			if (command.startsWith("+"))
				wait++;
			else if (command.startsWith("-"))
				wait--;
			else {
				String msg = command.substring(command.indexOf(":")+1);
				total += wait*msg.length();
			}

		}
		System.out.println(total);
	}

}
