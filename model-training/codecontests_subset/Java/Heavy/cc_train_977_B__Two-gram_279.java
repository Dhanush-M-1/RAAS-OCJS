import java.util.*;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int limit=sc.nextInt();
		String data=sc.next();

		ArrayList<String>al=new ArrayList<String>();
		for(int i=0;i<data.length()-1;i++)
		{
			String sub=data.substring(i,i+2);
			al.add(sub);
			
				
			
		}
		int max=Collections.frequency(al, al.get(0));
		String output=al.get(0);
		for(int i=1;i<al.size();i++)
			
		{
			String s=al.get(i);
			if(max<Collections.frequency(al, s))
			{
				max=Collections.frequency(al, s);
				output=s;
			}
			
		}
		System.out.print(output);
		
	
		//System.out.println(data);
	
	}
}