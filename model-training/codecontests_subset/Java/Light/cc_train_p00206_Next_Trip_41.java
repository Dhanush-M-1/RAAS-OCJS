import java.util.*;
public class Main{
    public static void main(String[] args){
	new Main().run();
    }

    Scanner kbd = new Scanner(System.in);

    void run(){
	while(kbd.hasNext()){
	    int n = kbd.nextInt();
	    if(n!=0) solve(n);
	}
    }

    void solve(int n){
	int ans = -1;
	for(int i=1; i<=12; i++){
	    int a = (kbd.nextInt() - kbd.nextInt());
	    //System.out.println(a);
	    if(n>0 && n<=a) ans = i;
	    n -= a;
	}
	if(ans!=-1)
	    System.out.println(ans);
	else
	    System.out.println("NA");
    }
}