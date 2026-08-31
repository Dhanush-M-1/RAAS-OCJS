import java.util.*;

public class B {
	
	public static void main(String[] args) {
		
		Scanner qwe = new Scanner(System.in);
		
		String[] line = qwe.nextLine().split(" ");
		int numneg = 0;
		int n = 0;
		int numpos = 1;
		for (int i = 0; i < line.length; i++) {
			char s = line[i].charAt(0);
			if(s == '+') numpos++;
			else if(s == '-') numneg++;
			else if(s != '?' && s != '='){
				n = Integer.parseInt(line[i]);
			}
		}
		
		
		String[] ans = Arrays.copyOf(line, line.length);
		boolean impos =false;
		if(numneg > numpos || numpos <= n+numneg){
			int need = n+numneg-numpos;
			boolean prevpos = true;
			for (int i = 0; i < ans.length; i++) {
				char s = ans[i].charAt(0);
				if(prevpos && s == '?'){
					int place = Math.min(n-1, need);
					ans[i] = Integer.toString(place+1);
					need -= place;
				}else if(s == '?'){
					ans[i] = Integer.toString(1);
				}
				
				if(s == '+') prevpos = true;
				if(s == '-') prevpos = false;
			}
			if(need != 0) impos = true;
		}
		else{
			int tosub = numpos-n-numneg;
			boolean prevpos = true;
			for (int i = 0; i < ans.length; i++) {
				char s = ans[i].charAt(0);
				if(!prevpos && s == '?'){
					int place = Math.min(n-1, tosub);
					ans[i] = Integer.toString(place+1);
					tosub -= place;
				}else if(s == '?'){
					ans[i] = Integer.toString(1);
				}
				
				if(s == '+') prevpos = true;
				if(s == '-') prevpos = false;
			}
			if(tosub != 0) impos = true;
			
		}
		
		if(impos) System.out.println("Impossible");
		else{
			System.out.println("Possible");
			for(int i =0; i < ans.length; i++){
				System.out.print(ans[i] + " ");
			}
			System.out.println();
		}
		
		
	}

}
