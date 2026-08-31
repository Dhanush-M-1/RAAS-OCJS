import java.util.ArrayList;
import java.util.Scanner;

public class codeForcesD1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		ArrayList[] array=new ArrayList[n];
		
		
		for(int i=0;i<n;i++) {
			array[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<n-1;i++) {
			int t1=sc.nextInt()-1;
			int t2=sc.nextInt()-1;
			
			array[t1].add(t2);
			array[t2].add(t1);
			
		}
		
		{
			boolean answer=true;
			for(int i=0;i<n;i++) {
				int temp=array[i].size();
				if(temp==2) {
					answer=false;
				}
			}
			
			if(answer) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
		
		sc.close();
	}
}
