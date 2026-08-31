import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class AandBCompErrors {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		HashMap<Integer,Integer>err=new HashMap<Integer,Integer>();		
		HashMap<Integer,Integer>err2=new HashMap<Integer,Integer>();
		String s1=br.readLine();
		String s2=br.readLine();
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n-2;++i) {
			int d=Integer.parseInt(st.nextToken());
			if(!err.containsKey(d)) {
				err.put(d,1);
				err2.put(d, 1);
			}
			else {
				int c=err.get(d);
				err.put(d, c+1);
				err2.put(d, c+1);
			}
			}
		st=new StringTokenizer(s1);
		int a=0;
		int b=0;
		for(int i=0;i<n;++i) {
			int z=Integer.parseInt(st.nextToken());
			if(err.get(z)==null ||err.get(z)<1) {
				if(a==0)
					a=z;
				else {
					b=z;
					break;
				}
			}
			else
				err.put(z,err.get(z)-1);
		}
		st=new StringTokenizer(s2);
		int er1=a;
		for(int i=0;i<n-1;++i) { 
			int z=Integer.parseInt(st.nextToken());
			if(err2.get(z)==null ||err2.get(z)<1) {
				er1=z;
			}
			else
				err2.put(z,err2.get(z)-1);
			}
		
		System.out.println((er1==a?b:a)+"\n"+er1);	}
}

