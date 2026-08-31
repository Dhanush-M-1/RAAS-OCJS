import java.util.ArrayList;
import java.util.Scanner;

public class tri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		ArrayList<Long> list ;
		
		long l;
		
		for(int i = 0; i < n; i++) {
			
			l = s.nextLong();
			list = new ArrayList<Long>();
			
			for(int j = 0; j < l; j++) {
				
				list.add(s.nextLong());
				
			}
			
			if(list.get(0) + list.get(1) <= list.get(list.size()-1))
				System.out.println("1 2 " + list.size());
			else
				System.out.println("-1");
			
		}

	}

}