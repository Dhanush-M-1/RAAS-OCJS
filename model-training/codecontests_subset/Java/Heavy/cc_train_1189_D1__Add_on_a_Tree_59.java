//segement tree
//balls circular
//DFS/BFS/recur

import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int n=in.nextInt();
		int[][] arr=new int[n][2];
		HashMap<Integer,Integer> lol = new HashMap<Integer,Integer>();
		for(int i=0;i<n-1;i++){
			arr[i][0]=in.nextInt();
			arr[i][1]=in.nextInt();

			if(lol.containsKey(arr[i][0]))
				lol.put(arr[i][0],lol.get(arr[i][0])+1);
			else lol.put(arr[i][0],1);

			if(lol.containsKey(arr[i][1]))
				lol.put(arr[i][1],lol.get(arr[i][1])+1);
			else lol.put(arr[i][1],1);
		}

		if(!lol.containsValue(2)) System.out.println("YES");
		else System.out.println("NO");
	}
		// PriorityQueue<Integer> p = new PriorityQueue<Integer>(5,new lolCompare());
		// TreeMap<Integer,Integer> lol = new TreeMap<Integer,Integer>();
		// LinkedList<Integer> l = new LinkedList<Integer>();

		// while(i<10)
		// 	{	i++;
		// 		int n=in.nextInt();
		// 		p.add(n);
		// 		lol.put(i+n,n);	
		// 		l.add(n);
		// 	}

		// while (!p.isEmpty()) { 
		// 	System.out.println(p.poll());
		// }

		// System.out.println(lol.entrySet());
		
		// // int x = lol.size();
		// // while (x > 0) {
		// // 	System.out.println(lol.get(x));
		// // 	x--;
		// // }

		// for(Map.Entry<Integer,Integer> mpa  : lol.entrySet()){
		// 	System.out.println(mpa.getKey()+" "+mpa.getValue());
		// }

		// Iterator<Integer> i1 = l.iterator(); 
		// //power(x,y,p);
		// while(i1.hasNext()){
			
		// 	System.out.println(i1.next());
		// }

	// public static void power(int x,int y,int p){

	// 	System.out.println(Math.pow(x,y));
	// 	int ans=1;

	// 	x=x%p;
		
	// 	while(y>0){
			
	// 		if(y%2 == 1)
	// 			ans=(ans*x) % p ;
			
	// 		y=y>>1;
	// 		x=(x*x)%p;
	// 	}

	// 	System.out.println(ans);
	// }
}

class lolCompare implements Comparator<Integer> {
	
	public int compare(Integer a,Integer b){
		if(a>b)return 1;
		else if(a<b) return -1;
		else return 0;
	}	
}