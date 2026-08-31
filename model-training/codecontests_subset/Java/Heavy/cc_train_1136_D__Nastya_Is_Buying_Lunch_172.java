import java.io.IOException;
import java.util.HashSet;
import java.util.NoSuchElementException;
public class Main{

	public static void main(String[] args){
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		HashSet<Integer>[] graph = new HashSet[n];
		
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt()-1;
			graph[i] = new HashSet<Integer>();
		}
		
		
		UnionFindTree UF = new UnionFindTree(n);
		for(int i=0;i<m;i++){
			int u = sc.nextInt()-1;
			int v = sc.nextInt()-1;
			graph[u].add(v);
		}
		int ans = 0;
		HashSet<Integer> must = new HashSet<Integer>();
		must.add(a[n-1]);
		for(int i=1;i<n;i++){
			if(graph[a[n-1-i]].size()>=must.size()){
				boolean b = true;
				for(int e:must){
					if(!graph[a[n-1-i]].contains(e)){
						must.add(a[n-i-1]);
						b = false;
						break;
					}
				}
				if(b){
					ans++;
					//System.out.println(a[n-1-i]+1);
				}
			}else{
				must.add(a[n-i-1]);
			}
		}
		System.out.println(ans);
		
	}

	
}



class UnionFindTree {
	int[] root;
	int[] rank;
	
	UnionFindTree(int N){
		root = new int[N];
		rank = new int[N];
		for(int i=0;i<N;i++){
			root[i] = i;
		}
	}
	
	public int find(int x){
		if(root[x]==x){
			return x;
		}else{
			return find(root[x]);
		}
	}
	
	public boolean unite(int x,int y){
		x = find(x);
		y = find(y);
		if(x==y){
			return false;
		}else{
			if(rank[x]<rank[y]){
				root[x] = y;
			}else{
				root[y] = x;
				if(rank[x]==rank[y]){
					rank[x]++;
				}
			}
		}
		return true;
	}
	
	public boolean same(int x,int y){
		return find(x)==find(y);
	}
}



class FastScanner {
    private final java.io.InputStream in = System.in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;
    private boolean hasNextByte() {
        if (ptr < buflen) {
            return true;
        }else{
            ptr = 0;
            try {
                buflen = in.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (buflen <= 0) {
                return false;
            }
        }
        return true;
    }
    private int readByte() { if (hasNextByte()) return buffer[ptr++]; else return -1;}
    private static boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}
    private void skipUnprintable() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++;}
    public boolean hasNext() { skipUnprintable(); return hasNextByte();}
    public String next() {
        if (!hasNext()) throw new NoSuchElementException();
        StringBuilder sb = new StringBuilder();
        int b = readByte();
        while(isPrintableChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }
    public long nextLong() {
        if (!hasNext()) throw new NoSuchElementException();
        long n = 0;
        boolean minus = false;
        int b = readByte();
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        if (b < '0' || '9' < b) {
            throw new NumberFormatException();
        }
        while(true){
            if ('0' <= b && b <= '9') {
                n *= 10;
                n += b - '0';
            }else if(b == -1 || !isPrintableChar(b)){
                return (minus ? -n : n);
            }else{
                throw new NumberFormatException();
            }
            b = readByte();
        }
    }
    public int nextInt() {
        if (!hasNext()) throw new NoSuchElementException();
        long n = 0;
        boolean minus = false;
        int b = readByte();
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        if (b < '0' || '9' < b) {
            throw new NumberFormatException();
        }
        while(true){
            if ('0' <= b && b <= '9') {
                n *= 10;
                n += b - '0';
            }else if(b == -1 || !isPrintableChar(b)){
                return (int) (minus ? -n : n);
            }else{
                throw new NumberFormatException();
            }
            b = readByte();
        }
    }
}