import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args)throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	String s[] = br.readLine().split(" ");
	int n = Integer.parseInt(s[0]);
	int k = Integer.parseInt(s[1]);
	String l[] = br.readLine().split(" ");
	ArrayList<Integer> v = new ArrayList<Integer>();;
	int cn[] = new int[1000001];
	int x;
	for(int i = 0; i<n;i++){
	    x = Integer.parseInt(l[i]);
	    cn[x]++;
	    v.add(x);
	}
	Collections.sort(v);
	int ans = n;
	for(int i = 1;i<n;i++){
	    if(v.get(i)>v.get(i-1) && v.get(i)<=(v.get(i-1)+k)){
		ans-=cn[v.get(i-1)];
	    }
	}
	out.println(ans);
	out.close();
    }
}
