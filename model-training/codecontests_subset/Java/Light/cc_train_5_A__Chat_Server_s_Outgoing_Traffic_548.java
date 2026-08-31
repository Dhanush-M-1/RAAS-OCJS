import java.util.*;

public class A {
	public static void main(String[] args) {
		Set<String> names = new HashSet<String>();
		int result= 0;
		for (Scanner s = new Scanner(System.in); s.hasNextLine();) {
			String str = s.nextLine();
			if(str.startsWith("+")){
				names.add(str.substring(1));
			}else if(str.startsWith("-")){
				names.remove(str.substring(1));
			}else{
				result += str.substring(str.indexOf(":")+1).length() * names.size();
			}
		}
		System.out.println(result);
	}
}
