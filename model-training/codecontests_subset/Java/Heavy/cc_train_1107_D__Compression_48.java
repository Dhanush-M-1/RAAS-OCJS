import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;

/**
 * Built using CHelper plug-in Actual solution is at the top
 */
public class Main {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;

		Reader in = new Reader();
		// Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		DCompression solver = new DCompression();
		solver.solve(1, in, out);
		out.close();
	}

	static class DCompression {

		public static Boolean[][] pd = new Boolean[256][10];

		public void solve(int testNumber, Reader in, PrintWriter out) throws IOException {

			int n = in.nextInt();
			int[][] matrix = new int[n][n];
			int[][] prefixSum = new int[n][n];
			List<Integer> divisores = new Vector<>();

			in.readLine();
			for (int i = 0; i < n; i++) {
				fill(i, in.readLine().toCharArray(), matrix);
			}
			
			for(int i = 0; i < n; i++) {
			
				prefixSum[i][0] = matrix[i][0];
				for(int j = 1; j < n; j++) {
					prefixSum[i][j] = prefixSum[i][j - 1] + matrix[i][j];
				}
			}

	        for(int i = n; i >= 2; i--){
	            if(n % i == 0) divisores.add(i);
	        }
	        
	        for(Integer div: divisores) {
	        	if(isOk(matrix, prefixSum, div, n, out)) {
	        		out.println(div);
	        		return;
	        	}
	        }
	        
	        out.println("1");
		}

		private boolean isOk(int[][] matrix, int[][] prefixSum, int x, int n, PrintWriter out) {

			   int m = n / x;

		        for(int i = 0; i < m; i++){

		            for(int j = 0; j < m; j++){

		                int offsetRow = i * x;
		                int offsetCol = j * x;
		                int sum = 0;

		                for(int ki = offsetRow; ki < offsetRow + x; ki++){
		                		
		                	sum += prefixSum[ki][offsetCol + x - 1] - (prefixSum[ki][offsetCol] - matrix[ki][offsetCol]);

		                }
		                
		                if(sum != 0 && sum != x * x) return false;

		            }
		        }
			
			
			return true;
		}
		
		private void fill(int row, char[] line, int[][] matrix) {
		
			for (int j = 0; j < line.length; j++) {

				int number = "0123456789ABCDEF".indexOf(line[j]);
				int index = (j + 1) * 4 - 1;
				while(number > 0) {
					matrix[row][index--] = number % 2;
					number /= 2;
				}
			}
			
		}
	}
}

//---------------------------------------------//
	
class Reader 
{ 
    final private int BUFFER_SIZE = 1 << 16; 
    private DataInputStream din; 
    private byte[] buffer; 
    private int bufferPointer, bytesRead; 

    public Reader() 
    { 
        din = new DataInputStream(System.in); 
        buffer = new byte[BUFFER_SIZE]; 
        bufferPointer = bytesRead = 0; 
    } 

    public Reader(String file_name) throws IOException 
    { 
        din = new DataInputStream(new FileInputStream(file_name)); 
        buffer = new byte[BUFFER_SIZE]; 
        bufferPointer = bytesRead = 0; 
    } 

    public String readLine() throws IOException 
    { 
        byte[] buf = new byte[5500]; // line length 
        int cnt = 0, c; 
        while ((c = read()) != -1) 
        { 
            if (c == '\n') 
                break; 
            buf[cnt++] = (byte) c; 
        } 
        return new String(buf, 0, cnt); 
    } 

    public int nextInt() throws IOException 
    { 
        int ret = 0; 
        byte c = read(); 
        while (c <= ' ') 
            c = read(); 
        boolean neg = (c == '-'); 
        if (neg) 
            c = read(); 
        do
        { 
            ret = ret * 10 + c - '0'; 
        }  while ((c = read()) >= '0' && c <= '9'); 

        if (neg) 
            return -ret; 
        return ret; 
    } 

    public long nextLong() throws IOException 
    { 
        long ret = 0; 
        byte c = read(); 
        while (c <= ' ') 
            c = read(); 
        boolean neg = (c == '-'); 
        if (neg) 
            c = read(); 
        do { 
            ret = ret * 10 + c - '0'; 
        } 
        while ((c = read()) >= '0' && c <= '9'); 
        if (neg) 
            return -ret; 
        return ret; 
    } 

    public double nextDouble() throws IOException 
    { 
        double ret = 0, div = 1; 
        byte c = read(); 
        while (c <= ' ') 
            c = read(); 
        boolean neg = (c == '-'); 
        if (neg) 
            c = read(); 

        do { 
            ret = ret * 10 + c - '0'; 
        } 
        while ((c = read()) >= '0' && c <= '9'); 

        if (c == '.') 
        { 
            while ((c = read()) >= '0' && c <= '9') 
            { 
                ret += (c - '0') / (div *= 10); 
            } 
        } 

        if (neg) 
            return -ret; 
        return ret; 
    } 

    private void fillBuffer() throws IOException 
    { 
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
        if (bytesRead == -1) 
            buffer[0] = -1; 
    } 

    private byte read() throws IOException 
    { 
        if (bufferPointer == bytesRead) 
            fillBuffer(); 
        return buffer[bufferPointer++]; 
    } 

    public void close() throws IOException 
    { 
        if (din == null) 
            return; 
        din.close(); 
    } 
}