
import java.util.*;


public class Class2 {

	public static void main(String[] args) {
		Scanner temp = new Scanner(System.in);
		int counter = 0;
		int queries = temp.nextInt();
		
		int list[] = new int[queries];
		//System.out.println(queries);
		
		while(counter<queries) {
			int l = temp.nextInt();
			int r = temp.nextInt();
			int d = temp.nextInt();
			//int multiplier = 1;
			int req = d;
			if(d>=l && d<=r) {
				list[counter] = r - (r%d) + d;
			}
			else {
			
			list[counter] = req;
			}
			counter = counter + 1;
		}
		for(int x:list) {
			System.out.println(x);
		}
		
	}
	
	}
	
		

	


