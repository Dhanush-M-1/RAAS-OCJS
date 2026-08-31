
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	
	
	
	
	public static void main (String [] args) throws NumberFormatException, IOException{
		
		
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String line; StringTokenizer X;
		while((line=input.readLine())!=null){
			X = new StringTokenizer(line);
			
			int n = Integer.parseInt(X.nextToken());
			
			int [] initial = new int [n];
			int [] second = new int [n-1];
			int [] third = new int [n-2];

			
			X = new StringTokenizer(input.readLine());
			for(int i=0;i<initial.length;i++) 
				initial[i] = Integer.parseInt(X.nextToken());		
			
			X = new StringTokenizer(input.readLine());

			for(int i=0;i<second.length;i++) 
				second[i] = Integer.parseInt(X.nextToken());
			
			X = new StringTokenizer(input.readLine());

						for(int i=0;i<third.length;i++) 
				third[i] = Integer.parseInt(X.nextToken());		
			
			Arrays.sort(initial);
			Arrays.sort(second);
			Arrays.sort(third);
			int first = 0;
			for(int i=0;i<initial.length;i++) {
				if(i == initial.length-1){
					first = initial[i];
				break;
				}
				if(initial[i] == second[i])
					continue;
				
				if(second[i]>initial[i]) {
					first = initial[i];
					break;
				}
			}
			int tany = 0;
			for(int i=0;i<second.length;i++) {
				if(i == second.length-1){
					tany = second[i];
				break;
				}
				if(second[i] == third[i])
					continue;
				
				if(third[i]>second[i]) {
					tany = second[i];
					break;
				}
			}
			
			System.out.println(first);
			System.out.println(tany);

		}
		
		
	}

}
