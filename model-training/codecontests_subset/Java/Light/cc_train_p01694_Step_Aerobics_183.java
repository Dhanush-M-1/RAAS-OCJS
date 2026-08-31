
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		while(true) {
			int n=in.nextInt();
			if(n==0)break;
			List<String> odrs=new ArrayList<>();
			for(int i=0;i<n;i++)odrs.add(in.next());
			System.out.println(solve(odrs));
		}
	}
	
	static int solve(List<String> data) {
		int cnt=0;
		boolean LS=false,l=false,r=false;
		
		for(int i=0;i<data.size();i++) {
			switch (data.get(i)) {
			case "lu":
				l=true;
				break;
				
			case "ld":
				l=false;
				break;
				
			case "ru":
				r=true;
				break;
				
			case "rd":
				r=false;
				break;
			}
			
			if(!LS && (l && r)) {
				cnt++;
				LS=true;
			}
			else if(LS &&(!l && !r)) {
				cnt++;
				LS=false;
			}
		}
		return cnt;
	}
}

