import java.util.*;
public class MemoryManager {
	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		int t = reader.nextInt();
		int cnt = 1;
		TreeSet<Block> memory = new TreeSet<Block>();
		memory.add(new Block(t,t,117));
		
		for(int i = 0; i < n; i++){
			String in = reader.next();
			if(in.equals("alloc")){
				int x = reader.nextInt();
				int s = 0;
				for(Block b:memory){
					if(b.s-s >= x)
						break;
					s = b.t;
				}
				if(s < t){
					memory.add(new Block(s,s+x,cnt));
					System.out.println(cnt);
					cnt++;
				}else{
					System.out.println("NULL");
				}
			}else if(in.equals("erase")){
				int x = reader.nextInt();
				TreeSet<Block> next = new TreeSet<Block>();
				boolean skipped = false;
				for(Block b:memory){
					if(b.n != x)
						next.add(b);
					else
						skipped = true;
				}
				memory = next;
				if(!skipped)
					System.out.println("ILLEGAL_ERASE_ARGUMENT");
			}else{
				TreeSet<Block> next = new TreeSet<Block>();
				int s = 0;
				for(Block b:memory){
					Block add = new Block(t,t,117);
					if(b.s < t)
						add = new Block(s,b.t-b.s+s,b.n);
					s = add.t;
					next.add(add);
				}
				memory = next;
			}
		}
	}
	
	public static class Block implements Comparable<Block>{
		int s,t,n;
		public Block(int _s, int _t, int _n){
			s = _s;
			t = _t;
			n = _n;
		}
		public int compareTo(Block b){
			return s-b.s;
		}
		public String toString(){
			return String.format("(%d: %d, %d)", n,s,t);
		}
	}
}
