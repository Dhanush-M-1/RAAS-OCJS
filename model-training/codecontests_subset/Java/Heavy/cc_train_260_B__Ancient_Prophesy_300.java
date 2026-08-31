import java.util.PriorityQueue;
import java.util.Scanner;


public class Codeforces {
	static PriorityQueue<String> PQ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String in = sc.next();
		PQ = new PriorityQueue<String>();
		int L = "01-01-2013".length();
		for(int a=0;a<=in.length()-L;a++){
			if(valid(""+in.subSequence(a, a+L)))
			{
				PQ.add(""+in.subSequence(a, a+L));
			}
		}
		String best = "";
		String cur = "";
		int bestmany = 0;
		int curmany = 0;
		
		while(!PQ.isEmpty()){
			
			String temp = PQ.poll();;
			if(temp.compareTo(cur)==0)curmany++;
			else{
				if(bestmany<curmany){
					bestmany=curmany;
					best = cur;
				}
				cur = temp;
				curmany = 1;
			}
		}
		if(bestmany<curmany){
			bestmany=curmany;
			best = cur;
		}
		System.out.println(best);

	}
	private static boolean valid(String test) {
	//	System.out.println(test);
		String[] out = test.split("-");
		if(out.length!=3)return false;
		if(out[0].length()!=2)return false;
		if(out[1].length()!=2)return false;
		if(out[2].length()!=4)return false;
		try{
			int d = Integer.parseInt(out[0]);
			int m = Integer.parseInt(out[1]);
			int y = Integer.parseInt(out[2]);
			if(m>=1&&m<=12&&d>=1&&d<=31&&y>=2013&&y<=2015){
				switch (m){
				case 2: if(d>28)return false;
				case 4:
				case 6:
				case 9:
				case 11: if(d==31)return false;
				default: return true;
				}
			}
		}
		catch(Exception e){
			return false;
		}
		
		return false;
	}

}
