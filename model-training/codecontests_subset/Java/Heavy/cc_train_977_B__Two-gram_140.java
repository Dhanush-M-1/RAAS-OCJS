import java.util.*;

public class Two_gram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner Reader=new Scanner(System.in);
		
		int size=Reader.nextInt();
		
		String s=Reader.next();
		
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		
		String bool="";
		String least="";
		long l=0;
		
		for(int i=1;i<size;i++) {
			
			String temp= s.substring(i-1,i+1);
			
			if(!bool.contains(temp)) {
				map.put(temp,1);
				bool+=temp+"_";
				if(l==0)
				{
					l=1;
					least=temp;
				}
			}
			
			else { int x=map.get(temp);
			map.put(temp,x+1);
			//System.out.println(map.get(temp));
				if(l<map.get(temp)) {
					l=map.get(temp);
				//	System.out.println(l);
					least=temp;
			}
			}
		}
		System.out.println(least);
		//System.out.println(l);
	}

}
