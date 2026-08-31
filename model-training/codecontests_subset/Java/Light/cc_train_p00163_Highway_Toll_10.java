/* Highway Toll */
import java.io.*;

public class Main{
	public static void main(String args[]){
		try{
			new Main();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static int[][] table = new int[][]{
		{  0, 300, 500, 600, 700, 1350, 1650},
		{  6,   0, 350, 450, 600, 1150, 1500},
		{ 13,   7,   0, 250, 400, 1000, 1350},
		{ 18,  12,   5,   0, 250,  850, 1300},
		{ 23,  17,  10,   5,   0,  600, 1150},
		{ 43,  37,  30,  25,  20,    0,  500},
		{ 58,  52,  45,  40,  35,   15,    0}
	};
	
	public final int start = 17*60 + 30;
	public final int end   = 19*60 + 30;
	
	public Main() throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		String[] tmp;
		
		while( true ){
			line = in.readLine();
			int entra = Integer.parseInt(line);
			if(entra==0) break;
			line = in.readLine();
			tmp = line.split(" ");
			int h = Integer.parseInt(tmp[0]);
			int m = Integer.parseInt(tmp[1]);
			int en_time = h*60 + m;
			
			line = in.readLine();
			int extra = Integer.parseInt(line);
			line = in.readLine();
			tmp = line.split(" ");
			h = Integer.parseInt(tmp[0]);
			m = Integer.parseInt(tmp[1]);
			int ex_time = h*60 + m;
			
			int a, b;
			if(entra > extra){
				a = entra-1;
				b = extra-1;
			}
			else{
				a = extra-1;
				b = entra-1;
			}
			
			int dist = table[a][b];
			int fee  = table[b][a];
			
			if(((en_time>=start && en_time <=end) || (ex_time>=start && ex_time<=end)) && dist <= 40){
				fee /= 2;
			}
			
			if(fee%50 != 0){
				fee = 50 * (fee/50 + 1);
			}
			
			System.out.println(fee);
		}
	}
}