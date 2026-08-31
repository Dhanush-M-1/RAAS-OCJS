import java.io.*;
import java.util.*;

public class A{
	public static boolean DEBUG = true;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int n = nextInt(br);
		
		String lv = br.readLine();
		HashSet<Integer> set = new HashSet<Integer>();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		
		for(int i = 0; i < n; i++){
			if(lv.charAt(i) == '*'){
				set.add(i);
				lst.add(i);
			}
		}
		
		boolean good = false;
		
		for(int i = 0; i < lst.size(); i++){
			for(int j = i+1; j < lst.size(); j++){
				int d = lst.get(j) - lst.get(i);
				if(set.contains(lst.get(j)+d) && lst.contains(lst.get(j)+2*d) && lst.contains(lst.get(j)+3*d)){
					good = true;
					break;
				}
			}
			if(good){
				break;
			}
		}
		
		if(good){
			pw.println("yes");
		} else {
			pw.println("no");
		}
		
		br.close();
		pw.close();
	}
	
	public static void debug(Object o){
		if(DEBUG){
			System.out.println("~" + o);
		}
	}
	
	public static StringTokenizer getst(BufferedReader br) throws Exception{
		return new StringTokenizer(br.readLine(), " ");
	}
	
	public static int nextInt(BufferedReader br) throws Exception{
		return Integer.parseInt(br.readLine());
	}
	
	public static int nextInt(StringTokenizer st) throws Exception{
		return Integer.parseInt(st.nextToken());
	}
}