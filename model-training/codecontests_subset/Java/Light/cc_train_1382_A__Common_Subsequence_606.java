import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ComSub {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int an = Integer.parseInt(st.nextToken());
			int bn = Integer.parseInt(st.nextToken());
			
			String[]a = bf.readLine().split(" ");
			String []bs = bf.readLine().split(" ");
			ArrayList<String> b= new ArrayList<String>();
			for(int j=0;j<bn;j++) {
				b.add(bs[j]);
			}
			
			boolean found = false;
			
			for(int j=0;j<a.length;j++) {
				String c = (a[j]);
				
				if(b.contains(c)) {
					
					found=true;
					System.out.println("YES\n"+1+" "+c);
					break;
				}
			}
			if(!found) {
				System.out.println("NO");
			}
		}
	}

}
