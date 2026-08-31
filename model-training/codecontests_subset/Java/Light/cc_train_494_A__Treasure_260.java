import java.util.Scanner;


public class C_495 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		
		int count =0;
		int []solution = new int[s.length()];
		int last = s.lastIndexOf('#');
		for(int i =0; i<s.length() ;i++) {
			if(s.charAt(i) == ')') count--;
			else if (s.charAt(i)== '(') count++;
			else {
				solution[i] = 1;
				count--;
			}
		}
			
		if(count >0) 
			solution[last] += count;
		count=0;
		
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ')') count--;
			else if (s.charAt(i)== '(') count++;
			else {
				count-= solution[i];
			}
			if(count <0 ) {
				System.out.println(-1);
				scanner.close();
				return;
			}
		}
		if(count != 0) {
			System.out.println(-1);
			scanner.close();
			return;
		}
		
	for (int i = 0; i < solution.length; i++) {
		if(s.charAt(i) == '#')
			System.out.println(solution[i]);
	}
		
		scanner.close();
	}

}
