import java.util.ArrayList;
import java.util.Scanner;

public class C977 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String s = sc.nextLine();

		


		ArrayList<String> pairs = new ArrayList<>();

		for(int i=0; i<26; i++){
			for(int j=0; j<26; j++){
				char l = (char)('A' + i);
				char r = (char)('A' + j);
				String x  = (l + "" + r );
				pairs.add(x);
			}
		}
		int maxCount = 1;
		String maxCountPair = s.substring(0,2);
		for(String p: pairs){
			int count = 0;
			for(int i=0; i<n-1; i++){
				if(s.substring(i,i+2).equals(p))
					count++;
			}

			if(maxCount < count){
				maxCount = count;
				maxCountPair = p;
			}

		}

		System.out.print(maxCountPair);
	}
	
}
