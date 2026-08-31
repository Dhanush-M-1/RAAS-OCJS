import java.io.*;

public class Main{
	public static void main(String args[]){
		try{
			new Main();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public Main() throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while((line = in.readLine()) != null){
			int size = Integer.parseInt(line);
			if(size==0) break;
			int[] data = new int[size];
			for(int i=0; i<size; i++){
				line = in.readLine();
				data[i] = Integer.parseInt(line);
			}
			
			int count = 0;
			for(int i=1; i<size; i++){
				for(int j=size-1; j>=i; j--){
					if(data[j] < data[j-1]){
						int t = data[j];
						data[j] = data[j-1];
						data[j-1] = t;
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
	}
}