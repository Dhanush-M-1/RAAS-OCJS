import java.util.*;

public class C{
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder str = new StringBuilder();
		for(int z = 0;z<t;++z){
			String s = in.next();
			if(s.length() == 1){
				str.append(0 + "\n");
				continue;
			}
			int res = 0;
			int[] flag = new int[s.length()];
			if(s.charAt(0) == s.charAt(1)){
				flag[1] = 1;
				res++;
			}
			for(int i = 2;i<s.length();++i){
				if(s.charAt(i) == s.charAt(i-2) && flag[i-2] == 0){
					flag[i] = 1;
					res++;
				}
				if(s.charAt(i) == s.charAt(i-1) && flag[i] == 0 && flag[i-1] == 0){
					flag[i] = 1;
					res++;
				}
			}
			
			
			str.append(res + "\n");
		}
		System.out.println(str.toString());
	}
	
}
					