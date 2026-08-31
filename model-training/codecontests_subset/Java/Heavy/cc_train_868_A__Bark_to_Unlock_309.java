import java.util.*;
public class BarkToUnlock {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String pass = sc.next();
		int n = sc.nextInt();
		List<String> list = new ArrayList<>();
		for(int i =0;i< n;i++){
			list.add(sc.next());
		}
		//ya
		boolean lastMatched = false;
		boolean firstMatched = false;
		char c = pass.charAt(0);
		char d = pass.charAt(1);
		for(String temp:list){
			if(pass.equals(temp)){
				lastMatched= true;
				firstMatched=true;
				break;
			}
			if(temp.charAt(1)==c){
				lastMatched= true;
			}
			if(temp.charAt(0)==d){
				firstMatched = true;
			}
			

		}
		if(firstMatched && lastMatched){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	
		
		
		

	}

}
