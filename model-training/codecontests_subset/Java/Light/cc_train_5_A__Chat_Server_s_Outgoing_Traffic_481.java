import java.util.*;

public class CSOT{


	public static void main(String[] args){
		Scanner console = new Scanner(System.in); 
		String input, temp; int people = 0, result = 0; 
		while (console.hasNext()){
			input = console.nextLine();
			if (input.charAt(0) == '+')
				people++;
			else if (input.charAt(0) == '-')
				people--;
			else {
				temp = input.substring(input.indexOf(":")+1, input.length());
				result += people * temp.length();
			}
		}
		System.out.println(result);


	}
}