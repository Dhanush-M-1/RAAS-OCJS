//package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AppDiv {
	
  public static void main(String[] args) {
	InputReader reader = new InputReader(System.in);
	int size = reader.nextInt();
	int hunds =0; 
	int thunds = 0;
	for(int i=0; i<size; i++){
		if(reader.nextInt() == 100)hunds++;
		else thunds++;
	}
	int total = 100 * hunds + 200 * thunds;
	if((total/2 & 1) == 1)System.out.println("NO");
	else{
		//take all hundreds
		int target = total /2;
		if(hunds * 100  >= target){
			if(hunds * 100  == target)
			System.out.println("YES");
			else if(target%100 ==0 ){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}else{
			int tws = 0;
			boolean solvable = false;
			while(hunds * 100 + tws * 200 <=target){
				if(hunds * 100 + tws * 200 == target){
					solvable = true;
					break;
				}
				tws++;
			}
			
			while(!solvable && hunds >0){
				if(hunds * 100 + tws * 200 == target){
					solvable = true;
					break;
				}
				hunds --;
				if(hunds * 100 + tws * 200 > target){
					hunds --;
					tws++;
				}
			}
			System.out.println(solvable?"YES":"NO");
		}
	}
	
}	
	static class InputReader {
	    private BufferedReader reader;
	    private StringTokenizer stt;
	 
	    public InputReader(InputStream stream) {
	        reader = new BufferedReader(new InputStreamReader(stream));
	    }
	 
	    public String nextLine() {
	        try {
	            return reader.readLine().trim();
	        } catch (IOException e) {
	            return null;
	        }
	    }
	 
	    public String nextString() {
	        while (stt == null || !stt.hasMoreTokens()) {
	            stt = new StringTokenizer(nextLine());
	        }
	        return stt.nextToken();
	    }
	 
	    public int nextInt() {
	        return Integer.parseInt(nextString());
	    }
	 
	}


}
