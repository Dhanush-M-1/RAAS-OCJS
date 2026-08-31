import java.util.*;

class Main{
	
	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		String key = "keyence";
		int left = 0;
		int right = 0;
		int n = 0;
		while(n<key.length()){
			if(S.charAt(n) == key.charAt(n)){
				n++;
			}else{
				break;
			}
		}
		left = n;
		n=0;
		while(n<key.length()){
			if(S.charAt(S.length()-1-n) == key.charAt(key.length()-1-n)){
				n++;
			}else{
				break;
			}
		}
		right = n;
		
		if(left + right >= 7){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}
}