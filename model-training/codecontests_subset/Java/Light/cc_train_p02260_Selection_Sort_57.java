
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		
		int n=cin.nextInt(),c=0;List<Integer> A=new ArrayList<>();
		for(int i=0;i<n;i++)A.add(cin.nextInt());
		
		boolean flag=true;
		for(int i=0;i<n-1;i++) {
			int min=i;
			for(int j=i+1;j<n;j++) {
				if(A.get(j)<A.get(min))min=j;
			}
			if(min!=i) {
				Collections.swap(A, i, min);
				c++;
			}
		}
		
		
		for(int i=0;i<n;i++) {
			System.out.print(A.get(i));
			if(i!=n-1)System.out.print(" ");
		}
		System.out.println();
		System.out.println(c);
	}

}

