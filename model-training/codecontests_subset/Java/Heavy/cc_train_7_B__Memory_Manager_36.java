import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int [] model = new int[m];
		int counter = 0;
		for (int t = 0 ; t< n ; t++){
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int x;
			if(command.equals("alloc")){
				x = Integer.parseInt(st.nextToken());
				boolean flag = true;
				if(x>m) flag = false;
				int idx = 0;
				int count = 0;
				for (int i = 0 ; (i< m && count!=x) && flag; i++){
					if(model[i]==0) count ++;
					else {
						count =0;
						idx = i+1;
					}
				}
				if(count == x){
					out.println(++counter);
					for (int i = 0 ; i<x ; i++)
						model[idx++] = counter;
				}
				else flag = false;
				if(!flag) out.println("NULL");
				continue;
			}
			if (command.equals("erase")){
				x = Integer.parseInt(st.nextToken());
				if(x==0) {
					out.println("ILLEGAL_ERASE_ARGUMENT");
					continue;
				}
				boolean flag = false;
				for (int j = 0 ; j< m ; j++){
					if (model[j] == x){
						flag = true;
						model[j] = 0;
					}
				}
				if(!flag) out.println("ILLEGAL_ERASE_ARGUMENT");
				continue;
			}
			int [] temp = new int [m];
			int i = 0;
			for (int j = 0 ; j< m ; j++){
				if(model[j]!=0) temp[i++] = model[j];	
			}
			model = temp;
			
			
		}

		out.flush();
		out.close();

	}
}