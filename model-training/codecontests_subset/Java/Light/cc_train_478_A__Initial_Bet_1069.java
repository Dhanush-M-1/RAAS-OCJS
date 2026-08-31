import java.io.*;
import java.util.*;
public class ab{
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int s=0,i;
		for(i=0;i<5;i++){
			int v=in.nextInt();
			s=s+v;
		}
		if(s%5==0&&s!=0){
			s=s/5;
			System.out.println(s);
		}
		else{
			s=-1;
			System.out.println(s);
		}
			
	}
}