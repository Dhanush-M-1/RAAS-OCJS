import java.util.*;
public class B {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		int[] count = new int[1000001];
		HashSet<Integer> hs = new HashSet();
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
			count[a[i]]++;
			hs.add(a[i]);
		}
		int[] temp = new int[hs.size()];
		int ii=0;
			Iterator<Integer> itr = hs.iterator();
			while(itr.hasNext()){
				temp[ii]=itr.next();
			    ii++;
			}
		Arrays.sort(temp);
		int alive=0;
		int len = hs.size();
		
		for(int i=0;i<len-1;i++){
			if(temp[i+1]>temp[i]+k){
				alive = alive + count[temp[i]];
			}
		}
		alive = alive + count[temp[len-1]];
		System.out.println(alive);
		
		
	}

}