import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class C7B {
	private StringTokenizer st;
	private BufferedReader bf;

	class Node {
		public Node(int s, boolean d) {
			dirty = d;
			size = s;
		}
		
		boolean dirty;
		int size;
	}
	
	public C7B() {
		try {
			bf = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(bf.readLine());
			
			List<Node> mem = new LinkedList<Node>();
			
			
			int t = nextInt();
			int maxCapacity = nextInt();
			int currentCapacity = 0;
			
			Node n0 = new Node(maxCapacity, false);
			mem.add(n0);
			

			Node[] na = new Node[101];

			int id = 1;
			
			for (int i=0; i < t; i++ ) {
				String s = next();
				if (s.equals("alloc")) {
					int size = nextInt();
					if (currentCapacity + size > maxCapacity) {
						System.out.println("NULL");
						continue;
					}
					
					int count = 0;
					Node temp = null;
					for (Node nn: mem) {
						if (!nn.dirty && size <= nn.size) {
							temp = nn;
							break;
						}
						count++;
					}
					
					if (temp != null) {
						
						if (temp.size - size > 0) {
							Node n2 = new Node(size, true);
							mem.add(count, n2);
							na[id] = n2;
							temp.size = temp.size - size;
						} else	if (temp.size - size == 0) {
							na[id] = temp;
							temp.dirty = true;
						}
						
						
						currentCapacity += size;
						System.out.println(id);
						
						id++;
						
						
					} else {
						System.out.println("NULL");
					}
					

				} else if (s.equals("erase")) {
					int n = nextInt();
					
					if (n >= id || n < 0 || na[n] == null) {
						System.out.println("ILLEGAL_ERASE_ARGUMENT");
						continue;
					}

					Node tg = na[n];
					currentCapacity -= tg.size;
					
					int k = mem.indexOf(tg);
					
					Node n4 = null;
					if (k > 0) {
						n4 = mem.get(k-1);
						if (!n4.dirty) {
							tg.size += n4.size;
						}
					}
									
					if (mem.size() >= k+2) {
						Node n3 = mem.get(k+1);
						if (!n3.dirty) {
							tg.size += n3.size;
							mem.remove(n3);
							n3 = null;
						}
					}
					 
					if (n4 != null) {
						if (!n4.dirty) {
							mem.remove(n4);
							n4 = null;
						}
					}

					tg.dirty = false;
					na[n] = null;
					
					
				} else if (s.equals("defragment")) {
					Stack<Integer> st = new Stack<Integer>();
					int resultCapacity = 0;
					int index = 0;
					for (Node nn: mem) {
						if (!nn.dirty) {
							resultCapacity += nn.size;
							st.push(index);
						}
						index++;
					}
					
					while (!st.isEmpty()) {
						int r = st.pop();
						mem.remove(r);
					}
					
					
					Node nnew = new Node(resultCapacity, false);
					mem.add(nnew);
					
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	private int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
	
	private String next() throws IOException {
		if (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(bf.readLine());
		return st.nextToken();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C7B c = new C7B();
	}
}
