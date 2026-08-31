import java.util.HashSet;
import java.util.Scanner;

public class problem_0005a {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashSet<String> hs = new HashSet<>(10_000);
		long sum = 0;
		while(in.hasNextLine()){
			String line = in.nextLine();
			if(line.equals("")) break;
			if(line.charAt(0) == '+'){
				String name = line.substring(1);
				hs.add(name);
			}
			else if(line.charAt(0) == '-'){
				String name = line.substring(1);
				hs.remove(name);
			}
			else{
				String[] parts = line.split(":");
				if(parts.length == 1) continue;
				sum += parts[1].length() * (long)hs.size();
			}
		}
		System.out.println(sum);
	}
}
