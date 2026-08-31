import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class C500 {
	public static void main(String[] args) {
		C500 obj = new C500();
		obj.init();
	}
	
	private void init() 
	{
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		
		int[] costArr = new int[n];
		int[] liftArr = new int[m];
		//int[] seq = new int[n];
		ArrayList<Integer> seq = new ArrayList<>(0);
		HashMap<Integer, Boolean> addedMap = new HashMap<>();
		
		for(int i=0;i<n;i++)
			costArr[i] = scn.nextInt();
		
		for(int i=0;i<m;i++)
		{	
			liftArr[i] = scn.nextInt();
			
			if(!addedMap.containsKey(liftArr[i]))
			{	
				addedMap.put(liftArr[i], true);
				seq.add(liftArr[i]);
			}
			
		}

		int cost = 0;
		
		for(int i:liftArr)
		{
			for(int j=0;j<seq.size();j++)
			{
				if(seq.get(j) == i)
				{	
					if(j!=0)
					{
						int temp = seq.get(j);
						seq.remove(j);
						seq.add(0, temp);
					}
					break;
				}
				else
				{
					cost+=costArr[seq.get(j)-1];
				}
			}
		}
		
		System.out.println(cost);
		
	}
}
