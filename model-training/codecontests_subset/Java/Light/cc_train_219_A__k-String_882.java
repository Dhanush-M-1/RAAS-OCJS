import java.util.*;

public class Main {
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		
		String s = sc.next();
		int cnt[] = new int[26];
		
		for(char c:s.toCharArray()){
			cnt[c-'a']++;
		}
		
		boolean ok =true;
		String ans = "";
		for(int i=0;i<26;i++){
			if(cnt[i]%k!=0){
				ok = false;
				break;
			}
			for(int j=0;j<cnt[i]/k;j++){
				ans += (char)(i+'a');
			}
		}
		
		if(!ok)
			System.out.println(-1);
		else
			for(int i=0;i<k;i++)
				System.out.print(ans);
	}
}