import java.io.*;
import java.util.*;
import java.io.IOException;
import java.io.InputStream;


public class Main {
    public static void main(String[] args) {

        File file = new File("in.txt");
        File fileOut = new File("out.txt");
        InputStream inputStream = null;
        OutputStream outputStream = null;
//         try {inputStream= new FileInputStream(file);} catch (FileNotFoundException ex){return;};
//        try {outputStream= new FileOutputStream(fileOut);} catch (FileNotFoundException ex){return;};
        inputStream = System.in;
        outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }


}

class Task {

    public void solve(int testNumber, InputReader in, PrintWriter out) {
		long n = in.nextLong();
		long cut_trees = 0;
		long biggest_occ_space = Long.MIN_VALUE;
		long old_tree_pos = 0;
		long old_tree_len = 0;
		for(long i = 0 ; i <= n ;i++){
			long tree_pos;
			long tree_len;
			if(i != n){
				tree_pos = in.nextLong();
				tree_len = in.nextLong();
			}else{
				tree_pos = Long.MAX_VALUE;
				tree_len = 0;
			}
			
			if(i == 0){
				old_tree_pos = tree_pos;
				old_tree_len = tree_len;
				continue;
			}
			
			//Always fell the first tree left
			//if(i == 0){
				//System.out.println("Tree fel to left ["+(tree_pos - tree_len)+";"+tree_pos+"]");
				//biggest_occ_space = tree_pos;
				//cut_trees++;
				//continue;
			//}
			
			//First check if it can fell to the left
			if(old_tree_pos - old_tree_len > biggest_occ_space){
				//System.out.println("Tree fel to left ["+(old_tree_pos - old_tree_len)+";"+old_tree_pos+"]");
				biggest_occ_space = old_tree_pos;
				cut_trees++;
			}else if(old_tree_pos+old_tree_len < tree_pos){
				//Drop it to the right
				//System.out.println("Tree fel to right ["+old_tree_pos+";"+(old_tree_pos+old_tree_len)+"]");
				biggest_occ_space = old_tree_pos+old_tree_len;
				cut_trees++;
			}else{
				//System.out.println("No space to drop tree");
				biggest_occ_space = old_tree_pos;
			}
			
			old_tree_pos = tree_pos;
			old_tree_len = tree_len;
		}
		
		out.println(cut_trees);
	}
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public String nextLine(){
        try {
            return reader.readLine();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
    public long nextLong() { return Long.parseLong(next()); }

}