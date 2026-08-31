import java.util.*;
public class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int i,j,k;
		int point = N-1;
		String w,w2;
		StringBuilder sb = new StringBuilder();
		for(i = 0;i < N;i++){
			sb.append("a");
		}
		w = sb.toString();
		System.out.println(w);
		for(i = 0;i < N-1;i++){
			w2 = w.substring(0,point);
			w2 += "b";
			Addabc(N,w2);
			point--;
		}
	}
	public static void Addabc(int max,String w2){
		char buf = 'a';
		String buf2 = "a";
		if(w2.length() == max){
			System.out.println(w2);
		}else{
			int i = 0;
			while(w2.contains(buf2)){
				buf += i;
				buf2 = String.valueOf(buf);
				w2 += buf2;
				Addabc(max,w2);
				i = 1;
				w2 = w2.substring(0,(w2.length()) - 1);
			}
		}
	}
}
