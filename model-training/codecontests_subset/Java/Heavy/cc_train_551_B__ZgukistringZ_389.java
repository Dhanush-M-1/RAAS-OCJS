import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();
		int[] as = new int[30];
		int[] bs = new int[30];
		int[] cs = new int[30];
		int[] temp = new int[30];

		for(int i=0;i<a.length();i++){
			as[a.charAt(i)-'a']++;
		}
		for(int i=0;i<b.length();i++){
			bs[b.charAt(i)-'a']++;
		}
		for(int i=0;i<c.length();i++){
			cs[c.charAt(i)-'a']++;
		}
		int startb = 100000000 , startc = 100000000;
		for(int i=0;i<27;i++){
			if(bs[i]!=0){
				startb = Math.min(startb,as[i]/bs[i]);
			}
			if(cs[i]!=0){
				startc = Math.min(startc, as[i]/cs[i]);
			}
			temp[i]=as[i];
		}
		int resb=0,resc=0;
		while(true){
			if(startb==0 && startc==0)break;
			for(int i=0;i<27;i++)
				temp[i]=as[i];
			for(int i=0;i<27;i++)
				temp[i]-=bs[i];
			int currc = 100000000;
			for(int i=0;i<27;i++){
				if(cs[i]!=0)
					currc = Math.min(currc,temp[i]/cs[i]);
			}
			int diff1 = startc - currc ;
			for(int i=0;i<27;i++)
				temp[i]=as[i];
			for(int i=0;i<27;i++)
				temp[i]-=cs[i];
			int currb = 100000000;
			for(int i=0;i<27;i++){
				if(bs[i]!=0)
					currb = Math.min(currb,temp[i]/bs[i]);
			}
			int diff2 = startb-currb;
			if((diff1<diff2 && startb!=0)||(startb!=0 && startc==0)){
				resb++;
				startb--;
				for(int i=0;i<27;i++)
					as[i]-=bs[i];
				startc=currc;
			}
			else if(startc!=0){
				resc++;
				startc--;
				startb=currb;
				for(int i=0;i<27;i++)
					as[i]-=cs[i];
			}
		}
		StringBuilder out = new StringBuilder();
		for(int i=0;i<resb;i++){
			out.append(b);
		}
		for(int i=0;i<resc;i++)
			out.append(c);
		for(int i=0;i<27;i++){
			while(as[i]!=0){
				out.append((char)(i+'a'));
				as[i]--;
			}
		}
		System.out.println(out);
	}
}