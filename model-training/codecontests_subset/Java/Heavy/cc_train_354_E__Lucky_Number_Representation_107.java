import java.util.*;
import java.io.*;
public class LuckyNumberRepresentation {
	static ArrayList<Integer>[] opt;
	static String[] code = new String[43]; 
	public static void main(String[] args) throws Exception {
		opt = new ArrayList[10]; 
		for(int i = 0; i < 10; i++){
			opt[i] = new ArrayList<>();
		}
		for(int a = 0; a <= 6; a++){
			for(int b = 0; b <= 6; b++){
				for(int c = 0; c <= 6; c++){
					if(a+b+c==6){
						int k = 4*b + 7*c;
						opt[k%10].add(k);
						StringBuilder sb = new StringBuilder();
						for(int i = 0; i < a; i++){
							sb.append('0');
						}
						for(int i = 0; i < b; i++){
							sb.append('4');
						}
						for(int i = 0; i < c; i++){
							sb.append('7');
						}
						code[k] = sb.toString();
					}
				}
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int t = 0; t < T; t++){
			long x = Long.parseLong(br.readLine().trim());
			ArrayList<Integer> res = check(x, new ArrayList<Integer>());
			if(res == null){
				System.out.println(-1);
			}
			else{
				StringBuilder[] sb = new StringBuilder[6];
				for(int i = 0; i < 6; i++) sb[i] = new StringBuilder();
				for(int m: res){
					for(int i = 0; i < 6; i++){
						sb[i].append(code[m].charAt(i));
					}
				}
				StringBuilder ress = new StringBuilder();
				for(int i = 0; i < 6; i++){
					ress.append(Long.parseLong(sb[i].toString())+" ");
				}
				System.out.println(ress.toString().trim());
			}
		}
	}
	static ArrayList<Integer> check(long x, ArrayList<Integer> list){
		if(x < 0) return null;
		if(x == 0) return list;
		for(int d: opt[(int)(x%10)]){
			ArrayList<Integer> next = check(x/10 - d/10, list); 
			if(next != null){
				next.add(d); return next;
			}
		}
		return null;
	}
}
