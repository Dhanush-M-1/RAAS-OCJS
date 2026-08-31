import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CF_339_A {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		String s = in.next();
		
		for(int i = 0;i<s.length();i++){       	// 1 = 49, 3 = 51
			char c = s.charAt(i);
			if(c>=49 && c<=51){
				al.add(Integer.parseInt(Character.toString(c)));
			}
		}
		
		Collections.sort(al);
		System.out.print(al.get(0));
		
		for(int i = 1;i<al.size();i++){
			System.out.print("+");
			System.out.print(al.get(i));
			
		}
		
					
	}

}

