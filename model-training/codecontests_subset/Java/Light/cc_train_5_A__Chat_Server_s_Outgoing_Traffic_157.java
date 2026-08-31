
import java.util.*;
public class Main {
	static List<String> list = new ArrayList<String>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long ans = 0;
		String s = "";
		while(sc.hasNextLine()){
			s = sc.nextLine();
			if(s.charAt(0) == '+'){
				s = s.substring(1);
				list.add(s);
			}
			else if(s.charAt(0) == '-'){
				s = s.substring(1);
				list.remove(s);
			}
			else{
				String t[] = s.split(":");
				if(t.length == 1)
					continue;
				int len = t[1].length();
				ans += len*list.size();
			}
		}
		System.out.println(ans);
	}
}