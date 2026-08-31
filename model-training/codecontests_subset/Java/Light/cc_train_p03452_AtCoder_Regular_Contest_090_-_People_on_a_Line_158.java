import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
 
 
public class Main {
	
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		//*
		m.input();
		m.solve();
		m.output();
		/*/
		m.debug();
		//*/
	}
	
	public void debug() {
	}
	
	/*
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String S = null;
	/*/
	InputUtil in = new InputUtil();
	//*/
	PrintWriter out = new PrintWriter(System.out);
	int N = 0;
	int M = 0;
	int[] L = null;
	int[] R = null;
	int[] D = null;
	long[] X = null;
	Map<Integer, Set<Node>> nodeMap = new HashMap<>();
	boolean[] Xfin = null;
	boolean ans = true;
	boolean searchEnd = false;
	static final int UNDEF = Integer.MIN_VALUE;
	
	public void input() throws IOException {
		N = in.nextInt();
		M = in.nextInt();
		X = new long[N+1];
		Arrays.fill(X, 0);
		for (int i=0; i<M; i++) {
			int l = in.nextInt();
			int r = in.nextInt();
			int d = in.nextInt();
			addNode(l, new Node(r, d));
			X[r] = UNDEF;
		}
	}
	
	private void addNode(int node, Node newNode) {
		Set<Node> nodeSet = nodeMap.get(node);
		if (nodeSet == null) {
			nodeSet = new HashSet<>();
			nodeMap.put(node, nodeSet);
		}
		nodeSet.add(newNode);
	}
	
	public void solve() throws IOException {
		if (M == 0) {
			return;
		}
		LinkedList<Integer> search = new LinkedList<>();
		for (int i=0; i<N; i++) {
			if (X[i] == 0 && nodeMap.containsKey(i)) {
				search.add(i);
			}
		}
		if (search.isEmpty()) {
			ans = false;
			return;
		}
		while(!search.isEmpty()) {
			int i = search.pollFirst();
			if (nodeMap.containsKey(i)) {
				for (Node node : nodeMap.get(i)) {
					if (X[node.targetNodeId] == UNDEF) {
						X[node.targetNodeId] = X[i] + node.targetDist;
						if (X[node.targetNodeId] > 1000000000L) {
							ans = false;
							return;
						}
						search.addLast(node.targetNodeId);
					} else if (X[node.targetNodeId] != X[i] + node.targetDist ) {
						ans = false;
						return;
					}
				}
			}
		}
	}
	
	public void output() {
		out.println(ans ? "Yes" : "No");
		out.flush();
	}
}

class Node {
	int targetNodeId = -1;
	int targetDist = Integer.MIN_VALUE;
	public Node(int targetNodeId, int targetDist) {
		this.targetNodeId = targetNodeId;
		this.targetDist = targetDist;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + targetDist;
		result = prime * result + targetNodeId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (targetDist != other.targetDist)
			return false;
		if (targetNodeId != other.targetNodeId)
			return false;
		return true;
	}
	
	public String toString() {
		return "id="+targetNodeId+",dist="+targetDist;
	}
	
}

//*
class InputUtil {
	//Static Fields
	private static final int BUFSIZ = 100000;
	
	//Fields
	protected InputStream in;
	private byte[] buf = null;
	private int ptr = 0;
	private int max = -1;
	private DataInputStream dis = null;
	//Constructors
	public InputUtil() {this(System.in,BUFSIZ);}
	public InputUtil(InputStream in, int bufsiz) {
		initBuf(bufsiz);
		initIn(in);
	}
	
	//Methods
	//Initializer
	protected void initIn(InputStream in) {dis = new DataInputStream(this.in = in);}
	protected void initBuf(int bufsiz) {buf = new byte[bufsiz];}
	
	//buffer operation
	private void next() throws IOException {ptr++; readBuf();}
	private void readBuf() throws IOException {
		if(ptr >= max && dis.available()>0) {
			if(max>0) Arrays.fill(buf,0,max,(byte)0);
			max = dis.read(buf);
			ptr = 0;
		}
	}
	
	//Number Input Reader/Parser
	private boolean isNum(byte b) {return '0' <= b && b <= '9'; }
	private boolean isMinus(byte b) {return b=='-'; }
 
	private int _nextInt() throws IOException {
		int sign = 1;
		int res = 0;
		byte c;
		while (!isNum(c=buf[ptr]) && !isMinus(c)) 
			next();
		if (isMinus(buf[ptr])) {
			sign = -1;
			next();
		}
		while (isNum(c=buf[ptr])) {
			res *= 10;
			res += c - '0' ;
			next();
		}
		next();
		return sign * res;
	}
	
	public int nextInt() throws IOException {
		readBuf();
		return _nextInt();
	}
 
	public int[] nextInt(int[] result) throws IOException {
		readBuf();
		for(int i=0; i<result.length; i++) {
			result[i] = _nextInt();
		}
		return result;
	}
	
	//Close 
	public void close() throws IOException {
		if(!this.in.equals(System.in)) 
			this.in.close();
	}
}
//*/
