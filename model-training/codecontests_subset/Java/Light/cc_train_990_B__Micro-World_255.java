import java.util.*;
public class remove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		ArrayList<Integer> a=new ArrayList<Integer>();
		HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
		for(int i=0;i<n;i++){
			int t=sc.nextInt();
			a.add(t);
			
		}
		ArrayList<Integer> b=new ArrayList<Integer>();
		Collections.sort(a);
		for(int i=0;i<n;i++){
			if(!h.containsKey(a.get(i))){
				h.put(a.get(i),1);
				b.add(a.get(i));
			}
			else{
				h.put(a.get(i),h.get(a.get(i))+1);
			}
		}
		//int i=0;
		int x=b.get(0);
		//System.out.println(h);
		for(int i=1;i<b.size();i++){	
			if(b.get(i)>b.get(i-1)){
				if(b.get(i)<=b.get(i-1)+m){
					n=n-h.get(b.get(i-1));
				}
			}
		}
		System.out.println(n);

	}

}
