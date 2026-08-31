import java.util.*;
public class bulbs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		int m=s.nextInt();
		
		HashSet<Integer> set=new HashSet<>();
		
		for(int i=0;i<n;i++) {
			
			int x=s.nextInt();
			
			while(x!=0) {
				
				set.add(s.nextInt());
				x--;
				
			}
			
		}
		
		if(set.size()==m)
			System.out.println("YES");
		else
			System.out.println("NO");
		
	}

}
