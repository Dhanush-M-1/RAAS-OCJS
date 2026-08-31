import java.util.*;
import static java.lang.Math.*;

public class B {
	static void p(Object...o){System.out.println(Arrays.deepToString(o));}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int M = sc.nextInt();
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> idx = new HashMap<Integer,Integer>();
		int at = 0;
		for(int t = 0; t < T;t++){
			String op = sc.next();
			if(op.equals("alloc")){
				int N = sc.nextInt();
				boolean found = false;
				for(int i = 0; i < M-N+1;i++){
					boolean legal = true;
					for(Map.Entry<Integer, Integer> m:hm.entrySet()){
						int st = m.getKey();
						int en = m.getValue()+st;
						
						if(bet(st,en,i))
							legal = false;
						if(bet(st,en,i+N))
							legal = false;
						if(bet(i,i+N,st))
							legal = false;
						if(bet(i,i+N,en))
							legal = false;
						if(st == i && en == i+N)
							legal = false;
					}
					if(legal){
						hm.put(i, N);
						idx.put(at++, i);
						found = true;
						break;
					}
				}
				if(!found)
					System.out.println("NULL");
				else
					System.out.println(at);
			}else if(op.equals("erase")){
				long NN = sc.nextLong()-1;
				int N = (int)NN;
//				p(N);
				if(NN < Integer.MAX_VALUE && NN >= 0 && idx.containsKey(N)){
					int to = idx.get(N);
					idx.remove(N);
					hm.remove(to);
				}else{
					System.out.println("ILLEGAL_ERASE_ARGUMENT");
				}
			}else{
				int last = 0;
				HashMap<Integer,Integer> hm2 = new HashMap<Integer,Integer>();
				HashMap<Integer,Integer> idx2 = new HashMap<Integer,Integer>();
				for(int i = 0; i < 200;i++){
					if(hm.containsKey(i)){
						int len = hm.get(i);
						int id = 0;
						for(int j = 0; j < 200;j++)
							if(idx.containsKey(j) && idx.get(j) == i)
								id = j;
						idx2.put(id, last);
						hm2.put(last, len);
						last += len;
					}
				}
				hm = hm2;
				idx = idx2;
			}
		}
	}
	private static boolean bet(int st, int en, int i) {
		return st < i && i < en;
	}
}
