import java.util.*;
import java.io.*;

public class code44B {
	static int[] times;
	public static void main(String[] args) throws Exception{
		BufferedReader bff=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wff=new PrintWriter(System.out);
		String[] st=bff.readLine().split(" ");
		int n=Integer.parseInt(st[0]);
		times=new int[3];
		times[0]=Integer.parseInt(st[1]);
		times[1]=Integer.parseInt(st[2]);
		times[2]=Integer.parseInt(st[3]);
		
		long ways=0;
		
		for(int i=0;i<=times[0];i++){
			double aux=0.5*i;
			//System.out.println("ini "+aux);
			for(int j=0;j<times[1];j++){
				aux+=1;
				double pans=n-aux;
				//System.out.println(aux+" "+pans);
				if(pans%2==0 && pans/2<=times[2] && pans>0){
					ways++;
				}
				if(aux==n){
					ways++;
				}
			}
		}
		for(int i=0;i<=times[0];i++){
			double aux=0.5*i;
			double pans=n-aux;
			//System.out.println(aux+" "+pans);
			if(pans%2==0 && pans/2<=times[2] && pans>0){
				ways++;
			}
			if(aux==n){
				ways++;
			}
		}
		
		
		wff.println(ways+"");
		wff.flush();
	}	
}









