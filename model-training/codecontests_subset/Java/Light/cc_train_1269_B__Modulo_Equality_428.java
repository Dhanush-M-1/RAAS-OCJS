import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main{
    public static void main(String[] args)throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	String s[] = br.readLine().split(" ");
	int n = Integer.parseInt(s[0]);
	int m = Integer.parseInt(s[1]);
	String pa[] = br.readLine().split(" ");
	String pb[] = br.readLine().split(" ");
	int a[] = new int[n];
	int b[] = new int[n];
	for(int i = 0; i<n;i++){
	    a[i] = Integer.parseInt(pa[i]);
	    b[i] = Integer.parseInt(pb[i]);
	}
	Arrays.sort(b);
	int xs[] = new int[n];
	for(int i = 0; i<n;i++){
	    xs[i] = (b[n-1]-a[i]+m)%m;
	}
	Arrays.sort(xs);
	int res = 0;
	for(int i = 0; i<n;i++){
	    if(xs[i]<0)continue;
	    int temp[] = new int[n];
	    for(int j = 0; j<n;j++){
		temp[j] = (a[j]+xs[i])%m;
	    }
	    Arrays.sort(temp);
	    boolean ans = true;
	    for(int j = 0; j<n;j++){
		if(temp[j]!=b[j]){
		    ans = false;
		    break;
		}
	    }
	    if(ans){
		res = xs[i];
		break;
	    }
	}
	out.println(res);


	out.close();
    }
}
