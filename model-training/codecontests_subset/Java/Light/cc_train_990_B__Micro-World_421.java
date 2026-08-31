import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
     
public class Main{
    public static class in{
	int i;
	in(int i){
	    this.i = i;
	}
    }
    
    public static void main(String[] args)throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	PrintWriter out = new PrintWriter(System.out);
    	String s[] = br.readLine().split(" ");
    	int n = Integer.parseInt(s[0]);
    	int k = Integer.parseInt(s[1]);
    	String l[] = br.readLine().split(" ");
    	in v[] = new in[n];
    	int cn[] = new int[1000001];
    	for(int i = 0; i<n;i++){
    	    v[i] =new in( Integer.parseInt(l[i]));
    	    cn[v[i].i]++;
    	}
    	Arrays.sort(v,(x,y)->{return x.i-y.i;});
    	int ans = n;
    	for(int i = 1;i<n;i++){
    	    if(v[i].i>v[i-1].i && v[i].i<=(v[i-1].i+k)){
    		ans-=cn[v[i-1].i];
    	    }
    	}
    	out.println(ans);
    	out.close();
    }
}
