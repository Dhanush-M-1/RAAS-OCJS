import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class contestB {

	static ArrayList<ArrayList<Integer>> seg = new ArrayList<>();
	static HashMap<Integer,HashSet<Integer>> adjmat = new HashMap<>();
	public static int BFS(int xf,int yf,int xi,int yi) {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		HashMap<Integer,HashSet<Integer>> v = new HashMap<>();
		HashMap<Integer,HashMap<Integer,Integer>> count = new HashMap<>();
		qx.add(xi);
		qy.add(yi);
		count.put(xi, new HashMap<Integer,Integer>());
		count.get(xi).put(yi, 0);
		v.put(xi, new HashSet<Integer>());
		v.get(xi).add(yi);
		int c = 0;
		while(!qx.isEmpty()) {
			int tx = qx.remove();
			int ty = qy.remove();
			//System.out.println(tx + " " + ty);
			boolean t = false;
			if(tx>0 && tx<=1000000000 && ty+1>0 && ty+1<=1000000000)
			if(isTrue(tx,ty+1)) {
				if(!v.containsKey(tx))
					v.put(tx, new HashSet<Integer>());
				if(!v.get(tx).contains(ty+1)) {
				v.get(tx).add(ty+1);
				qx.add(tx);
				qy.add(ty+1);
				t = true;
				if(!count.containsKey(tx)) {
					count.put(tx, new HashMap<Integer,Integer>());
				}
				count.get(tx).put(ty+1, count.get(tx).get(ty)+1);
				
				}
			}
			if(tx>0 && tx<=1000000000 && ty-1>0 && ty-1<=1000000000)
			if(isTrue(tx,ty-1)) {
				if(!v.containsKey(tx))
					v.put(tx, new HashSet<Integer>());
				if(!v.get(tx).contains(ty-1)) {
				v.get(tx).add(ty-1);
				qx.add(tx);
				qy.add(ty-1);
				t = true;
				if(!count.containsKey(tx)) {
					count.put(tx, new HashMap<Integer,Integer>());
				}
				count.get(tx).put(ty-1, count.get(tx).get(ty)+1);
				}
			}
			if(tx+1>0 && tx+1<=1000000000 && ty>0 && ty<=1000000000)
			if(isTrue(tx+1,ty)) {
				if(!v.containsKey(tx+1))
					v.put(tx+1, new HashSet<Integer>());
				if(!v.get(tx+1).contains(ty)) {
				v.get(tx+1).add(ty);
				qx.add(tx+1);
				qy.add(ty);
				t = true;
				if(!count.containsKey(tx+1)) {
					count.put(tx+1, new HashMap<Integer,Integer>());
				}
				count.get(tx+1).put(ty, count.get(tx).get(ty)+1);
				}
			}
			if(tx-1>0 && tx-1<=1000000000 && ty>0 && ty<=1000000000)
			if(isTrue(tx-1,ty)) {
				if(!v.containsKey(tx-1))
					v.put(tx-1, new HashSet<Integer>());
				if(!v.get(tx-1).contains(ty)) {
				v.get(tx-1).add(ty);
				qx.add(tx-1);
				qy.add(ty);
				t = true;
				if(!count.containsKey(tx-1)) {
					count.put(tx-1, new HashMap<Integer,Integer>());
				}
				count.get(tx-1).put(ty, count.get(tx).get(ty)+1);
				}
			}
			if(tx-1>0 && tx-1<=1000000000 && ty-1>0 && ty-1<=1000000000)
			if(isTrue(tx-1,ty-1)) {
				if(!v.containsKey(tx-1))
					v.put(tx-1, new HashSet<Integer>());
				if(!v.get(tx-1).contains(ty-1)) {
				v.get(tx-1).add(ty-1);
				qx.add(tx-1);
				qy.add(ty-1);
				t = true;
				if(!count.containsKey(tx-1)) {
					count.put(tx-1, new HashMap<Integer,Integer>());
				}
				count.get(tx-1).put(ty-1, count.get(tx).get(ty)+1);
				}
			}
			if(tx-1>0 && tx-1<=1000000000 && ty+1>0 && ty+1<=1000000000)
			if(isTrue(tx-1,ty+1)) {
				if(!v.containsKey(tx-1))
					v.put(tx-1, new HashSet<Integer>());
				if(!v.get(tx-1).contains(ty+1)) {
				v.get(tx-1).add(ty+1);
				qx.add(tx-1);
				qy.add(ty+1);
				t = true;
				if(!count.containsKey(tx-1)) {
					count.put(tx-1, new HashMap<Integer,Integer>());
				}
				count.get(tx-1).put(ty+1, count.get(tx).get(ty)+1);
				}
			}
			if(tx+1>0 && tx+1<=1000000000 && ty-1>0 && ty-1<=1000000000)
			if(isTrue(tx+1,ty-1)) {
				if(!v.containsKey(tx+1))
					v.put(tx+1, new HashSet<Integer>());
				if(!v.get(tx+1).contains(ty-1)) {
				v.get(tx+1).add(ty-1);
				qx.add(tx+1);
				qy.add(ty-1);
				t = true;
				if(!count.containsKey(tx+1)) {
					count.put(tx+1, new HashMap<Integer,Integer>());
				}
				count.get(tx+1).put(ty-1, count.get(tx).get(ty)+1);
				}
			}
			if(tx+1>0 && tx+1<=1000000000 && ty+1>0 && ty+1<=1000000000)
			if(isTrue(tx+1,ty+1)) {
				if(!v.containsKey(tx+1))
					v.put(tx+1, new HashSet<Integer>());
				if(!v.get(tx+1).contains(ty+1)) {
				v.get(tx+1).add(ty+1);
				qx.add(tx+1);
				qy.add(ty+1);
				t = true;
				if(!count.containsKey(tx+1)) {
					count.put(tx+1, new HashMap<Integer,Integer>());
				}
				count.get(tx+1).put(ty+1, count.get(tx).get(ty)+1);
				}
			}
			if(tx==xf && ty == yf)
				break;
		}
		if(count.containsKey(xf))
			return count.get(xf).get(yf);
		else
			return -1;
	}
	public static boolean isTrue(int x,int y) {
		if(!adjmat.containsKey(x))
			return false;
		return adjmat.get(x).contains(y);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int xi = sc.nextInt();
		int yi = sc.nextInt();
		int xf = sc.nextInt();
		int yf = sc.nextInt();
		int n = sc.nextInt();
		for(int i=0;i<n;i++)
			seg.add(new ArrayList<Integer>());
		for(int i=0;i<n;i++) {
			int a = sc.nextInt();int b = sc.nextInt();int c = sc.nextInt();
			if(!adjmat.containsKey(a))
				adjmat.put(a, new HashSet<>());
			for(int j=b;j<=c;j++) {
				if(!adjmat.get(a).contains(j))
					adjmat.get(a).add(j);
			}
		}
		//System.out.println(isTrue(10,3));
		if(xi==xf && yi==yf)
			System.out.println(0);
		else {
			System.out.println(BFS(xf,yf,xi,yi));
		}
		
	}
}
 