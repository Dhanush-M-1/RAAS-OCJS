import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
public class Main{
	public static void main(String[] args) throws IOException{
		Scanner stdIn=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String suit[]={"S","H","C","D"};
		boolean card[][];
		card=new boolean[4][14]; //S:0 H:1 C:2 D 3
		for(int i=0;i<n;i++){
			String[] s=br.readLine().split(" ");
			int rank=Integer.parseInt(s[1]);
			int tmp=0;
			switch(s[0]){
			case "S":tmp=0;break;
			case "H":tmp=1;break;
			case "C":tmp=2;break;
			case "D":tmp=3;break;
			}
			card[tmp][rank]=true;
		}
		for(int i=0;i<4;i++){
			for(int j=1;j<=13;j++){
				if(card[i][j]==false)
					System.out.println(suit[i]+" "+j);
			}
		}
	}
}