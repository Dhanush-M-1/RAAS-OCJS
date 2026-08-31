import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		 int n=in.nextInt();
		 List<Integer> A=new ArrayList<>();
		 
		 for(int i=0;i<n;i++)A.add(Integer.parseInt(in.next()));
		 in.close();
		 
		 int swap=selection(A);
		 for(int i=0;i<n-1;i++)System.out.print(A.get(i)+" ");
		 System.out.println(A.get(n-1));
		 System.out.println(swap);
	}
	
	static int selection(List<Integer> A) {
		int sw=0;
		
		for(int i=0;i<A.size();i++) {
			int min=i;
			for(int j=i;j<A.size();j++) {
				if(A.get(j)<A.get(min))min=j;
			}
			
			if(min>i) {
				Collections.swap(A, i, min);
				sw++;
			}
			
		}
		
		return sw;
	}
}

