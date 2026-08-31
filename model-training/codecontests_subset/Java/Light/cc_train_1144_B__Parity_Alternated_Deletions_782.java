import java.util.*;
import java.io.*;

public class B {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int e=0;
		int o=0;
		ArrayList<Integer> ea=new ArrayList<>();
		ArrayList<Integer> oa=new ArrayList<>();
		for(int j=0;j<n;j++) {
			int x=Integer.parseInt(st.nextToken());
			if(x%2==0)
				ea.add(x);
			else
				oa.add(x);
		}
		Collections.sort(ea);
		Collections.sort(oa);
		e=ea.size();
		o=oa.size();
		long sum=0;
		if(e>o) {
			for(int i=0;i<e-o-1;i++) {
				sum+=ea.get(i);
			}
		}
		else if(o>e) {
			for(int i=0;i<o-e-1;i++) {
				sum+=oa.get(i);
			}
		}
		pw.println(sum);
		
		pw.flush();

	}

}
