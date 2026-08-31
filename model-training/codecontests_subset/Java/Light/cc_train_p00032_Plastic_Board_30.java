import java.util.*;
public class Main{
    public static void main(String[] args){
	new Main().run();
    }
    Scanner sc = new Scanner(System.in);

    int re, di;
    String s;
    int[] len;
    int i, j, k;

    void run(){
	re = 0;
	di = 0;
	while(sc.hasNext()){
	    s = sc.next();
	    len = new int[3];
	    j = 0;
	    k = 0;
	    for(i=0; i<3 && k<s.length(); i++){
		while(j<s.length() && !s.substring(j, j+1).equals(",")) j++;
		//System.out.println("*"+j+" "+k);
		len[i] = Integer.parseInt(s.substring(k, j));
		k = j+1;
		j++;
		//System.out.print(len[i]+" ");
	    }
	    //System.out.println();
	
	    check();
	}
	System.out.println(re);
	System.out.println(di);
    }

    void check(){
	// 辺1, 辺2, 対角線
	if(len[0]==len[1]) di++;
	if(len[0]*len[0]+len[1]*len[1] == len[2]*len[2]) re++;
    }
}