import java.io.*;

class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String[] str = buf.readLine().split(" ");
			int H = Integer.parseInt(str[0]);
			int W = Integer.parseInt(str[1]);

			if(W==0 && H==0)
				break;

			for(int i=1; i<=H; i++){
				for(int j=1; j<=W; j++){
					if(i%2==1 && j%2==1 || i%2==0 && j%2==0)
						System.out.print("#");
					else
						System.out.print(".");
				}
				System.out.println();
			} 
			System.out.println();
		}
	}
}