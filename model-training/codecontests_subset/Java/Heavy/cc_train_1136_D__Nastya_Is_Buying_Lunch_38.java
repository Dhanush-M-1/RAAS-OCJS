
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
// D
public class BuyingLunch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner scn=new Scanner(System.in);
		InputReader scn=new InputReader();
		int n=scn.nextInt();
		int m=scn.nextInt();
		int []arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=scn.nextInt();
		}
		HashMap<Integer,HashSet<Integer>> hmap=new HashMap<>();
		for(int i=0;i<m;i++) {
			int x=scn.nextInt();
			int y=scn.nextInt();
			if(hmap.containsKey(y)) {
				HashSet<Integer> a=hmap.get(y);
				a.add(x);
				hmap.put(y, a);
			}else {
				HashSet<Integer> a=new HashSet<Integer>();
				a.add(x);
				hmap.put(y, a);
			}
		}
		
		HashMap<Integer,Integer> notRightReachable=new HashMap<Integer,Integer>();
		int count=0;
		if(hmap.containsKey(arr[n-1])) {
			HashSet<Integer> h=hmap.get(arr[n-1]);
			Iterator<Integer> itr=h.iterator();
			while(itr.hasNext()) {
				int x=itr.next();
				notRightReachable.put(x, 1);
			}
			ArrayList<Integer> al=new ArrayList<Integer>();
			al.add(arr[n-1]);
			for(int i=n-2;i>=0;i--) {
				if(notRightReachable.containsKey(arr[i])) {
					if(notRightReachable.get(arr[i])==al.size()) {
						count++; // ans
					}else {
						al.add(arr[i]);
						if(hmap.containsKey(arr[i])) {
							HashSet<Integer> h1=hmap.get(arr[i]);
							Iterator<Integer> itr1=h1.iterator();
							while(itr1.hasNext()) {
								int x=itr1.next();
								if(notRightReachable.containsKey(x))
								 {
									notRightReachable.put(x,notRightReachable.get(x)+1 );
								}
							}
						}
					}
				}else {
					al.add(arr[i]);
					if(hmap.containsKey(arr[i])) {
						HashSet<Integer> h1=hmap.get(arr[i]);
						Iterator<Integer> itr1=h1.iterator();
						while(itr1.hasNext()) {
							int x=itr1.next();
							if(notRightReachable.containsKey(x))
							 {
								notRightReachable.put(x,notRightReachable.get(x)+1 );
							}
						}
					}
				}
				
			}
		}
		System.out.println(count);
	}
	public  static class InputReader{
		BufferedReader br;
		StringTokenizer st;
		InputReader(){
			br=new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while(st==null||!st.hasMoreTokens()) {
				try {
					st=new StringTokenizer(br.readLine());
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
