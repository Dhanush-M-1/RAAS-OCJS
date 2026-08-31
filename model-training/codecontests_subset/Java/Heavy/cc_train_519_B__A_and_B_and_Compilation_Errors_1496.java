import java.util.*;
public class AandBCompilationErrors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		
		ArrayList<Integer> ans=new ArrayList<>();
		
		int ar[]=new int[n];
		
		for(int i=0;i<n;i++)
			ar[i]=s.nextInt();
		
		int br[]=new int[n-1];
		
		for(int i=0;i<n-1;i++)
			br[i]=s.nextInt();
		
		int cr[]=new int[n-2];
		
		for(int i=0;i<n-2;i++)
			cr[i]=s.nextInt();
		
		Arrays.sort(ar);
		Arrays.sort(br);
		Arrays.sort(cr);
		
		for(int i=0;i<n-1;i++)
		{
			if(ar[i]!=br[i]) {
				ans.add(ar[i]);
				break;
			}
		}
		
		if(ans.size()==0)
			ans.add(ar[n-1]);
		
		for(int i=0;i<n-2;i++) {
			if(br[i]!=cr[i]) {
				ans.add(br[i]);
				break;
			}
		}
		
		if(ans.size()==1)
			ans.add(br[n-2]);
		
		System.out.println(ans.get(0));
		System.out.println(ans.get(1));
		
	}

}
