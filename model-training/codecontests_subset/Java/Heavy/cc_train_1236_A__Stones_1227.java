import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
import java.lang.Math;
 
public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
    
	public static void main(String[] args) throws IOException {
 	    // Read inputs
 	    st = new StringTokenizer(br.readLine());
 		int q = Integer.parseInt(st.nextToken());
 		for(int i = 0; i<q; i++){
		    solve();
 		}
	}
	
	public static void solve() throws IOException {
	    // Read inputs
	    st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int out = 0;
		if(c/2>b){
		    System.out.println(3*b);
		    return;
		} else {
		    b-=c/2;
		    out += 3*(c/2);
		    if(b/2>a){
		        out+=a*3;
		    } else {
		        out += 3*(b/2);
		    }
		}
		System.out.println(out);
	}
}