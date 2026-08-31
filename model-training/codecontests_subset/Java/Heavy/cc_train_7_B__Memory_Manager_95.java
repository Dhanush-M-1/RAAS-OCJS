import java.util.*;

public class cf7b {
	public static void main(String[] args) {
		new cf7b();
	}
	int[] mem;
	cf7b() {
		Scanner in = new Scanner(System.in);
		HashSet<Integer> ident = new HashSet<Integer>();
		int k = 1;
		int t = in.nextInt();
		int m = in.nextInt();
		mem = new int[m];
		for(int i=0; i<t; i++) {
			String command = in.next().trim();
			if(command.equals("defragment")) defrag();
			else if(command.equals("alloc")) {
				int size = in.nextInt();
				boolean success = alloc(size,k);
				if(success) {
					ident.add(k);
					System.out.println(k++);
				}
				else
					System.out.println("NULL");
			}
			else {
				int id = in.nextInt();
				if(ident.contains(id)) {
					erase(id);
					ident.remove(id);
				}
				else
					System.out.println("ILLEGAL_ERASE_ARGUMENT");
			}
		}
	}
	boolean alloc(int n, int k) {
		int cnt = 0;
		for(int i=0; i<mem.length; i++) {
			if(mem[i]==0) cnt++;
			else cnt = 0;
			if(cnt == n) {
				for(int j=0; j<n; j++) 
					mem[i-j] = k;
				return true;
			}
		}
		return false;
	}
	void erase(int n) {
		for(int i=0; i<mem.length; i++)
			if(mem[i] == n) mem[i] = 0;
	}
	void defrag() {
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0; i<mem.length; i++)
			if(mem[i] != 0)
				q.add(mem[i]);
		int crnt = 0;
		while(!q.isEmpty()) 
			mem[crnt++] = q.poll();
		while(crnt != mem.length)
			mem[crnt++] = 0;
	}
}
