import java.util.*;
public class parityAlternatedDeletions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		
		PriorityQueue<Integer> odd=new PriorityQueue<>();
		PriorityQueue<Integer> even=new PriorityQueue<>();
		
		for(int i=0;i<n;i++) {
			
			int x=s.nextInt();
			
			if(x%2==0)
				even.add(x);
			else
				odd.add(x);
			
		}
		
		int dif=Math.abs(even.size()-odd.size());
		
		if(dif<=1)
			System.out.println(0);
		else
		{
			PriorityQueue<Integer> max;
			
			if(odd.size()>even.size())
				max=odd;
			else
				max=even;
			
			int ans=0;
			
			for(int i=0;i<dif-1;i++)
				ans+=max.poll();
			System.out.println(ans);
		}
		
		
		
	}

}
