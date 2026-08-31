import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		String pass = scan.next();
		int num = scan.nextInt();
		
		String firsts = "";
		String second = "";
		
		boolean flag = false;
		for(int i = 0; i < num; i++){
			String entry = scan.next();
			firsts += entry.charAt(0);
			second += entry.charAt(1);
			
			if(!flag && entry.equals(pass)){
				flag = true;
			}
		}
		
		if(!flag){
			flag = firsts.indexOf(pass.charAt(1))!= -1 && second.indexOf(pass.charAt(0))!= -1;
		}
		
		System.out.println(flag? "YES" : "NO");
		
		scan.close();
	}
}