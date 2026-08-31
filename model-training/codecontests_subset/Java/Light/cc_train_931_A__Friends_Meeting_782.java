import java.util.*;
public class Solution {
	public static int sigma(int a){
		int s=0;
		for (int i=1;i<=a;i++){
			s=s+i;
		}
		return s;
	}
	public static void main(String args[]){
			Scanner in =new Scanner(System.in);
			String r=in.nextLine();
			int p=Integer.parseInt(r);
			String s=in.nextLine();
			int q=Integer.parseInt(s);
			int k=Math.abs(p-q);
			int l=2*sigma(k/2);
			if(k%2==1){
				l=l+((k+1)/2);
			}
			System.out.println(l);
					
			
			//in.close();
		}
}