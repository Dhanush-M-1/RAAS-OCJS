import java.util.*;
public class Main{
    public static void main(String[] args){
	new Main().run();
    }
    Scanner sc = new Scanner(System.in);

    int n, count;
    boolean[] p;

    void run(){
	count = 0;
	p = new boolean[100000000];
	setP();
	while(sc.hasNext()){
	    n = sc.nextInt();
	    if(p[n]) {
		count++;
	     	p[n] = false;
	    }
	}
	System.out.println(count);
    }  

    void setP(){
	Arrays.fill(p, true);
	p[0] = p[1] = false;
	for(int i=2; i<p.length; i++)
	    if(p[i])
		for(int j=i*2; j<p.length; j+=i)
		    p[j] = false;
    }
}