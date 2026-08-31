import java.util.*;

public class C {
	
	public static void main(String[] args) {
		
		Scanner qwe = new Scanner(System.in);
		
		char[] in =qwe.next().toCharArray();
		boolean impos = false;
		int delta = 0;
		int lastdex = -1;
		int numHash = 0;
		for (int i = 0; i < in.length; i++) {
			if(in[i] == '(') delta++;
			else delta--;
			
			if(in[i] == '#'){
				numHash++;
				lastdex = i;
			}
		}
		if(delta < 0) impos = true;
		int needToAdd = delta;
		
		int running = 0;
		for (int i = 0; i < in.length; i++) {
			if(in[i] == '(') running++;
			else if(i == lastdex) running -= needToAdd+1;
			else running --;
			
			if(running < 0) impos = true;
			
		}
		if(running != 0) impos = true;
		
		if(impos) System.out.println(-1);
		else{
			for(int i =0; i < numHash-1; i++){
				System.out.println(1);
			}
			
			if(numHash > 0) System.out.println(needToAdd+1);
			
		}
		
		qwe.close();
	}

}
