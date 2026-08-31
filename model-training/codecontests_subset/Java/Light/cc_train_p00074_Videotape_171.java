import java.util.*;
class Main{
    public static void main(String[] args){
	new Main().run();
    }
    Scanner sc = new Scanner(System.in);

    void run(){
	int h = sc.nextInt();
	int m = sc.nextInt();
	int s = sc.nextInt();
	while(!(h==-1 && m==-1 && s==-1)){
	    int tape = 120*60 - (h*3600+m*60+s);
	    solve(tape);
	    solve(tape*3);
	    h = sc.nextInt();
	    m = sc.nextInt();
	    s = sc.nextInt();
	}
    }

    void solve(int t){
	int ah=0, am=0, as=0;	
	while(t >= 3600){
	    ah++;
	    t -= 3600;
	}
	while(t >= 60){
	    am++;
	    t -= 60;
	}
	as = t;
	print(ah, am, as);
    }

    void print(int ah, int am, int as){
	if(ah/10==0)
	    System.out.print("0");
	System.out.print(ah+":");
	if(am/10==0)
	    System.out.print("0");
	System.out.print(am+":");
	if(as/10==0)
	    System.out.print("0");
	System.out.println(as);
    }
}