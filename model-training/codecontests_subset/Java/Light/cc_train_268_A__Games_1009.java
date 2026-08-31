import java.util.*;
public class Games {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		
		HashMap<Integer,Integer> home=new HashMap<>();
		HashMap<Integer,Integer> guest=new HashMap<>();
		
		int ans=0;
		
		for(int i=0;i<n;i++) {
			
			int hcolour=s.nextInt();
			int gcolour=s.nextInt();
			
			if(guest.containsKey(hcolour))
				ans+=guest.get(hcolour);
			
			int val=1;
			
			if(home.containsKey(hcolour))
				val=home.get(hcolour)+1;
			
				home.put(hcolour,val);
			
			
			if(home.containsKey(gcolour))
				ans+=home.get(gcolour);
			
					 val=1;
			
			if(guest.containsKey(gcolour))
				val=guest.get(gcolour)+1;
			
				guest.put(gcolour,val);
			
		}
		
		System.out.println(ans);
		
		
	}

}
