import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main{
    public static void main(String[] args)throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	int c = Integer.parseInt(br.readLine());
	while(c-->0){
	    int m = Integer.parseInt(br.readLine());
	    int v[] = new int[m];
	    int w[] = new int[m];
	    for(int i = 0; i<m;i++){
		String d[] = br.readLine().split(" ");
		v[i] = Integer.parseInt(d[0]);
		w[i] = Integer.parseInt(d[1]);

	    }
	    boolean ans = v[0]>=w[0];
	    for(int i = 1; i<m;i++){
		if(w[i]>v[i]){
		    ans = false;
		    break;
		}
		if(v[i]<v[i-1]){
		    ans = false;
		    break;
		}
		if((v[i]-v[i-1])<(w[i]-w[i-1])){
		    ans = false;
		    break;
		}
		if(w[i]<w[i-1]){
		    ans = false;
		    break;
		}
	    }
	    if(ans){
		out.println("YES");
	    }else{
		out.println("NO");
	    }
	}
	out.close();
    }
}
