import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public class Node {
		int num;
		int prev ;
		int next ;
		public Node(int u ,int p , int n) {
			prev = p;
			next = n;
			num = u;
		}
	}

	static Main main;

	public static void main(String [] args ) {
		main = new Main();
		try{
			String str;			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedOutputStream bos = new BufferedOutputStream(System.out);
			String eol = System.getProperty("line.separator");
			byte [] eolb = eol.getBytes();
			byte[] spaceb= " ".getBytes();


			str  = br.readLine();
			int blank = str.indexOf( " ");
			int n = Integer.parseInt(str.substring(0,blank));
			int x = Integer.parseInt(str.substring(blank+1));
			Node [] ar = new Node[n];
			for(int i = 0 ; i < n ; i++) {
				ar[i] = main.new Node(i+1,-1,-1);
			}
			int j=0;
			int s=0;
			int k =0;
			str = br.readLine();
			int length = str.length();
			while(j<length) {
				while(j<length) {
					if(str.charAt(j) == ' ') {
						break;
					}else {
						j++;
					}
				}
				int u = Integer.parseInt(str.substring(s,j)) ;
				if(u>0) {
					ar[k].next = u-1;
					ar[u-1].prev = k;
				}
				k++;
				j++;
				s=j;			
			}
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i = 0 ; i < n ; i++) {
				if(ar[i].prev==-1) {
					int iter = 1;
					boolean done = true;
					if(ar[i].num==x) {
						done = false;
					}
					Node node = ar[i];
					while(node.next!=-1) {
						iter++;
						node = ar[node.next];
						if(node.num==x) {
							done = false;
						}
					}
					if(done) {
						list.add(iter);
					}
				}
			}
			Node node = ar[x-1];
			int time = 0;
			while(node.next!=-1) {
				node = ar[node.next];
				time++;
			}
			boolean [] pos = new boolean[n];
			for(int i = 0 ; i < n; i++) {
				pos[i] = false;
			}
			pos[0] = true;
			for(int i = 0 ; i < list.size() ; i++) {
				ArrayList<Integer> ll = new ArrayList<Integer>();
				for(int p = 0 ; p < n ; p++) {
					if(pos[p]) {
						int q = list.get(i) + p;
						if(q<n) {
							ll.add(q);
						}
					}
				}
				for(int p = 0 ; p < ll.size() ; p++) {
					pos[ll.get(p)] = true;
				}
			}
			ArrayList<Integer> myList = new ArrayList<Integer>();
			for(int p = 0 ; p < n ; p++) {
				if(pos[p]) {
					myList.add(p);
				}
			}
			for(int p = 0 ; p < myList.size();p++) {
				bos.write(new Integer(time+myList.get(p)+1).toString().getBytes());
				bos.write(eolb);
			}
			bos.flush();
		}  catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
