import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ops = sc.nextInt();
		int maxMem = sc.nextInt();
		sc.nextLine();
		MemoryManager mm = new MemoryManager(maxMem);
		int i = 0;
		String params[];
		while(i < ops){
			String op = sc.nextLine();
			if (op.startsWith("alloc")){
				params = op.split(" ");
				int res = -1;
				int size = 0;
				if (params.length == 2){
					size = Integer.parseInt(params[1]);
					res = mm.new_op(size);
				}
				else{
					int from = Integer.parseInt(params[1]);
					size = Integer.parseInt(params[2]);
					res = mm.new_op(from, size);
				}
				if (res == -1)
					System.out.println("NULL");
				else
					System.out.println(res);
			}
			if (op.startsWith("erase")){
				params = op.split(" ");
				int id = Integer.parseInt(params[1]);
				int res = mm.delete(id);
				if (res == -1)
					System.out.println("ILLEGAL_ERASE_ARGUMENT");				
			}
			if (op.startsWith("defragment")){
				mm.defrag();
			}			
			++i;
		}
	}
}

class MMSeg{
	int id;
	int from;
	int to;
	boolean isAvail;
}
class MemoryManager{
	private List<MMSeg> mm = new ArrayList<MMSeg>();
	int maxSize = 0;
	int nextSeq = 1;
	
	public MemoryManager(int mmSize){
		MMSeg t = new MMSeg();
		t.id = -1;
		t.from = 0;
		t.to = mmSize;
		t.isAvail = true;
		mm.add(t);
		this.maxSize = mmSize;
	}
	
	public int new_op(int from, int size) {
		int i = 0;
		for(; i < mm.size(); ++i){
			MMSeg s = mm.get(i);
			if (s.isAvail == false)
				continue;
			else{
				if (from > s.to)
					continue;
				if (s.to-from < size)
					continue;
				if (from == s.from){
					if (s.to-s.from == size){
						s.isAvail = false;
						s.id = this.nextSeq++;
						return s.id;
					}
					else{
						MMSeg t = new MMSeg();
						t.from = s.from + size;
						t.to = s.to;
						s.to = t.from;
						s.isAvail = false;
						t.isAvail = true;
						s.id = this.nextSeq++;
						mm.add(i, t);
						return s.id;
					}
				}
				else{
					MMSeg t = new MMSeg();
					t.from = s.from;
					t.to = from;
					t.isAvail = true;
					mm.add(i, t);
					
					if (s.to == from + size){
						s.from = from;
						s.isAvail = false;
						s.id = this.nextSeq++;
						return s.id;
					}
					else{
						t = new MMSeg();
						t.to = s.to;
						t.from = from + size;
						t.isAvail = true;
						
						s.from = from;
						s.to = t.from;
						s.isAvail = false;
						s.id = this.nextSeq++;
						mm.add(i+2, t);
						return s.id;						
					}
				}				
			}
		}
		return -1;
	}
	
	public int new_op(int size){
		int i = 0;
		for(; i < mm.size(); ++i){
			MMSeg s = mm.get(i);
			if (s.isAvail == false)
				continue;
			else{
				if (size == s.to-s.from){
					s.isAvail = false;
					s.id = this.nextSeq++;
					return s.id;
				}
				else if (size > s.to - s.from)
					continue;
				
				MMSeg t = new MMSeg();
				t.from = s.from;
				t.to = t.from + size;
				s.from = t.to;
				t.isAvail = false;
				t.id = this.nextSeq++;
				mm.add(i, t);
				return t.id;
			}
		}
		return -1;
	}
	
	public int delete(int id){
		if (id <= 0)
			return -1;
		int i = 0;
		MMSeg t = null;
		for(; i < mm.size(); ++i){
			t = mm.get(i);
			if (t.id == id)
				break;
		}		
		if ( i >= mm.size() || t.isAvail == true){
			return -1;
		}
		t.isAvail = true;
		t.id = -1;
		if (i < mm.size()-1){
			MMSeg s = mm.get(i+1);
			if(s.isAvail == true){
				t.to = s.to;
				mm.remove(i+1);
				t.id = -1;
			}			
		}
		if (i > 0){
			MMSeg s = mm.get(i-1);
			if(s.isAvail == true){
				t.from = s.from;
				mm.remove(i-1);
				t.id = -1;
			}			
		}
		return 0;
	}
	
	public void defrag(){
		int i = 0;
		int preFrom = 0, preTo = 0;
		for(i = mm.size()-1; i > -1; --i){
			MMSeg s = mm.get(i);
			if(s.isAvail == true){
				mm.remove(i);
			}
		}
		for(i = 0; i < mm.size(); ++i){
			MMSeg s = mm.get(i);
			preFrom = preTo;
			preTo += s.to-s.from;
			s.from = preFrom;
			s.to = preTo;
		}
		if (preTo < this.maxSize){
			MMSeg t = new MMSeg();
			t.from = preTo;
			t.to = this.maxSize;
			t.isAvail = true;
			t.id = -1;
			mm.add(t);			
		}
	}
}
	 		 	 	 			 		  	 	 			  	