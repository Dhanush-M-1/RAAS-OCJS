import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class c{
    public static void main(String[] args)throws IOException{
	br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	int n = nextInt();
	int[] v = new int[n];
        int a = 0, b = 0, ans = 0;
        for(int i = 0; i<n-1;i++){
	    a = nextInt();
	    b = nextInt();
	    a--;b--;
	    v[a]+=1;
	    v[b]+=1;
	    if(v[a]==2){
		ans++;
	    }else if(v[a]==3){
		ans--;
	    }
	    if(v[b]==2){
		ans++;
	    }else if(v[b]==3){
		ans--;
	    }
	}
        if(ans==0){
	    out.println("YES");
	}else{
	    out.println("NO");
	}
        out.close();
    }

    static BufferedReader br;
    static StringTokenizer st = new StringTokenizer("");
    
    static String next()throws IOException{
	while(!st.hasMoreTokens()){
	    st = new StringTokenizer(br.readLine());
	}
	return st.nextToken();
    }
    static int nextInt()throws IOException{
	return Integer.parseInt(next());
    }     
}
