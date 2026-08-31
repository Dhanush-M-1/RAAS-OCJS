import java.util.*;
import java.io.*;
public class meramainmahan {
	
	
	public static int solve(int l,int r){
		int res2=r/2-l/2;
		if(l%2==0&&res2!=0)res2++;
		if(r%2==0&&res2!=0)res2++;
		if(res2==0)return l;
		else return 2;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner in=new Scanner(System.in);
		int l=in.nextInt();
		int r=in.nextInt();
		System.out.print(solve(l,r));
	}

}