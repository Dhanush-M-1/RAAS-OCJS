import java.util.*;


public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		String st=s.next();
		HashMap<String,Integer> h=new HashMap<String,Integer>();
		String tmp;
		for(int j=0;j<st.length()-1;j++)
		{
			tmp=st.substring(j, j+2);
			if(!h.containsKey(tmp))
				h.put(tmp, 1);
			else
				h.put(tmp, (h.get(tmp))+1);
		}
		String ans="";int x=0,y;
		for(Map.Entry<String,Integer> ma:h.entrySet())
		{
			y=ma.getValue();
			tmp=ma.getKey();
			if(x<y)
			{
				ans=tmp;
				x=y;
			}
		}
		System.out.println(ans);
		

	}

}
