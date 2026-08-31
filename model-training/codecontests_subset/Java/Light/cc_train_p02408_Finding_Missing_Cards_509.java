import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int su;
		int num=0;
		String mark;
		Boolean s[]=new Boolean[52];
		Arrays.fill(s, false);//s[]の配列に初期値falseを設定
		
		for(int i=0;i<n;i++){
			mark=sc.next();
			su=sc.nextInt();
			
			if(mark.equals("S")) num=0;
			else if(mark.equals("H"))	num=13;
			else if(mark.equals("C"))	num=26;
			else if(mark.equals("D"))	num=39;
			
			s[num+su-1]=true;
		}//for
		
		
		for(int i=0;i<52;i++){
			if(i<13 && s[i]==false){
				System.out.println("S "+(i+1)); 
			}else if(i<26 && s[i]==false){
				System.out.println("H "+(i-12)); 
			}else if(i<39 && s[i]==false){
				System.out.println("C "+(i-25)); 
			}else if(i<52 && s[i]==false){
				System.out.println("D "+(i-38)); 
			}else continue;
		}//for
	}
}