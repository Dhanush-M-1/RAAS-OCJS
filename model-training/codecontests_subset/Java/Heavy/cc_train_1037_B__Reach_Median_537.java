import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class median {

public static void main(String[] args) {
        input in = new input();
        int n = in.nextInt();
        long s = in.nextLong();
        long arr[] = new long[n];
        for(int i=0; i<n; i++) arr[i] = in.nextLong();
        Arrays.sort(arr);
        
        long mid = arr[n/2];
        long ans=0;
        if(s==mid) System.out.println(ans);
        else if(s<mid) {
        	for(int i=n/2; i>=0; i--) {
        		if(arr[i]<s) break;
        		ans+=arr[i]-s;
        	}
        	System.out.println(ans);
        }
        else {
        	for(int i=n/2; i<n; i++) {
        		if(arr[i]>s) break;
        		ans+=s-arr[i];
        	}
        	System.out.println(ans);
        }
        
    }

 	static class input{BufferedReader br;StringTokenizer st;public input(){
 		br=new BufferedReader(new InputStreamReader(System.in));}String next(){while(st==null
 		||!st.hasMoreElements()){try{st=new StringTokenizer(br.readLine());}catch(IOException e)
 		{e.printStackTrace();}}return st.nextToken();}int nextInt(){return Integer.parseInt
 		(next());}long nextLong(){return Long.parseLong(next());}double nextDouble(){return 
 		Double.parseDouble(next());}String nextLine(){String str = "";try{str=br.readLine();}
 		catch (IOException e){e.printStackTrace();}return str;}}
 
}
