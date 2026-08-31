import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;



public class solution1 {

	/**
	 * @param args
	 */
	static int parent[];
	static int size[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader in=new InputReader (System.in);
OutputWriter out=new OutputWriter(System.out);

int n=in.readInt();
int m=in.readInt();
parent=new int[n+1];
size=new int[n+1];

int inverse[]=new int[n+1];
int a[]=new int[n+1];
for(int i=1;i<=n;i++)
{
	a[i]=in.readInt();
	inverse[a[i]]=i;
	parent[i]=i;
	}


for(int i=1;i<=m;i++){
int u=in.readInt();
int v=in.readInt();
union(u,v);
}

int g[][]=new int[n+1][];

int sz[]=new int[n+1];

for(int i=1;i<=n;i++){
//System.out.print(	parent[i]+" ");
int p=find(i);
	sz[p]++;
}
//System.out.println();
for(int i=1;i<=n;i++){
	g[i]=new int[sz[i]];
}

sz=new int[n+1];

for(int i=1;i<=n;i++){
	g[find(i)][sz[find(i)]++]=i;;
}


for(int i=1;i<=n;i++){
	
	if(sz[i]!=0){
		int array[]=new int[sz[i]];
		for(int k=0;k<sz[i];k++){
			array[k]=a[g[i][k]];
		}
		Arrays.sort(array);
	for(int j=0;j<(sz[i]);j++){
	//	System.out.println(sz[i]-1-j+" "+i+" "+j);
		a[g[i][j]]=array[sz[i]-1-j];
		//a[inverse[array[sz[i]-1-j]]]=array[j];
	}
	
	
	}
}

for(int i=1;i<=n;i++){
	out.print(a[i]+" ");
}
out.close();
}
	
	
	
	
static 	int find(int x){
		int k=0;
		if(parent[x]!=x){
	k=		find(parent[x]);
		}
		else{
			return x;
		}
		parent[x]=k;
		return k;
	}
static 	void union(int x,int y){
		int xx=find(x);
		int yy=find(y);
		if(xx==yy){
			return;
		}
		if(size[xx]>size[yy]){
			parent[yy]=xx;
		}
		else if(size[yy]>size[xx]){
			parent[xx]=yy;
		}
		else{
			
			parent[yy]=xx;
			size[xx]++;
		}
		
	}

	}




class InputReader {
	 
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;

	public InputReader(InputStream stream) {
		this.stream = stream;
	}

	public int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

	public int readInt() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	public String readString() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}

	public boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	public String next() {
		return readString();
	}

	public interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
}

class OutputWriter {
	private final PrintWriter writer;

	public OutputWriter(OutputStream outputStream) {
		writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
	}

	public OutputWriter(Writer writer) {
		this.writer = new PrintWriter(writer);
	}

	public void print(Object...objects) {
		for (int i = 0; i < objects.length; i++) {
			if (i != 0)
				writer.print(' ');
			writer.print(objects[i]);
		}
	}

	public void printLine(Object...objects) {
		print(objects);
		writer.println();
	}

	public void close() {
		writer.close();
	}

	public void flush() {
		writer.flush();
	}

	}

class IOUtils {

	public static int[] readIntArray(InputReader in, int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++)
			array[i] = in.readInt();
		return array;
	}

	}

