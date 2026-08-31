import java.util.Arrays;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author FussyWheat
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n=in.nextInt();
        int m=in.nextInt();
        int w[]=new int[n];
        int d[]=new int[m];
        in.getArray(w);
        in.getArray(d);
        boolean bookDone[]=new boolean[n];
        Arrays.fill(bookDone,false);
        ArrayList<Integer> stack=new ArrayList<Integer>();
        for(int i=0;i<m;i++){
            if(!bookDone[d[i]-1]){
                stack.add(d[i]);
                bookDone[d[i]-1]=true;
            }
        }
        stack=reverse(stack);
        long ans=0;
        for(int i=0;i<m;i++){
            int bn=d[i];
            int ind=getIndex(stack,bn);
            for(int j=ind+1;j<stack.size();j++){
                ans=ans+(long)(w[stack.get(j)-1]);
            }
            stack.remove(ind);
            stack.add(bn);
        }
        out.print(ans);
    }
    public int getIndex(ArrayList<Integer> stack,int bn){
        for(int i=0;i<stack.size();i++){
            if(stack.get(i)==bn){
                return i;
            }
        }
        return -1;
    }
    public ArrayList<Integer> reverse(ArrayList<Integer> stack){
        ArrayList<Integer> ret=new ArrayList<Integer>();
        for(int i=stack.size()-1;i>=0;i--){
            ret.add(stack.get(i));
        }
        return ret;
    }
}

class InputReader{
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream){
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }
    public String next(){
        while (tokenizer == null||!tokenizer.hasMoreTokens()){
            try{
                tokenizer = new StringTokenizer(reader.readLine());
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }

            catch (NullPointerException e){
                throw new UnknownError();
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt(){
        return Integer.parseInt(next());
    }

    public void getArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            arr[i]=nextInt();
        }
    }

}

