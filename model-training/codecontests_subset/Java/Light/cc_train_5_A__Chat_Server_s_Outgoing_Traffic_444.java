import java.util.Scanner;

public class Main {
	public static void main(String[] args){		
		Scanner input = new Scanner(System.in);	
		String line = "";
		int online = 0,res = 0;
		while(input.hasNext()){
			line = input.nextLine();
			if(line.charAt(0) == '+')++online;
			else if(line.charAt(0) == '-')--online;
			else{
				int x = line.indexOf(":") + 1;
				String temp = line.substring(x);
				res += online * temp.length();
			}
		}
		System.out.println(res);
	}	
}