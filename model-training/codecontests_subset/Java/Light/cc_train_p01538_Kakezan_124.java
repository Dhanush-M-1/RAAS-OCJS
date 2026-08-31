import java.util.*;
public class Main{
    static Scanner kbd = new Scanner(System.in);
    public  static void main(String[] args){
	int n = kbd.nextInt();
	while(n>0){
	    solve(n);
	    n--;
	}
    }

    static void solve(int n){
	String s = kbd.next();
	int cnt = 0;
	while(s.length()>1){
	    //System.out.println(s);
	    s = cut(s);
	    cnt++;
	    if(cnt > (100000000)){
		cnt = -1;
	    }
	    //System.out.println(n+"ぐるぐるっ！");
	}
	System.out.println(cnt);
    }

    static String cut(String s){
	int ans = 0;
	int a, b, i;
	for(i=1; i<s.length(); i++){
	    a = Integer.parseInt(s.substring(0, i));
	    b = Integer.parseInt(s.substring(i, s.length()));
	    if(a*b > ans) ans = a*b;
	    //System.out.println(ans);
	}
	return Integer.toString(ans);
    }
}