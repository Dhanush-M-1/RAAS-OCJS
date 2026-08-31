import java.util.Arrays;
import java.util.Scanner;

public class Tren1 {

	public static void main(String[] args){
		Scanner scn=new Scanner(System.in);
		int N=scn.nextInt();
		String str=scn.next();
		String ans="";
		int max=0;
		String mas[]=new String[N-1];
		for(int i=0;i<N-1;i++)
			mas[i]=str.substring(i, i+2);
		Arrays.sort(mas);
		int cur=1;
		for(int i=0;i<N-2;i++){
			if(mas[i].equals(mas[i+1])) cur++;
			else{
				if(cur>max){
					ans=mas[i];
					max=cur;
				}
				cur=1;
			}
		}
		if(cur>max) ans=mas[N-2];
		System.out.println(ans);
	}
}