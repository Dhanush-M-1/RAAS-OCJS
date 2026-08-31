
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		Scanner input=new Scanner (System.in);
		PrintWriter out=new PrintWriter(System.out);
		
		int n=input.nextInt();
		int[]a=new int[n];
		int odd=0;int even=0;
		for(int i=0;i<n;i++) {
			int k=input.nextInt();
			a[i]=k;
			if(k%2==0) {
				even++;
			}else {
				odd++;
			}
		}
		int[]o=new int[odd];int i=0;
		int []e=new int[even];int j=0;
		
		for(int q=0;q<n;q++) {
			int k=a[q];
			if(k%2==0) {
				e[j++]=k;
			}else {
				o[i++]=k;
			}
		}	
		
		if(odd==even||Math.abs(odd-even)==1) {
			out.println(0);
		}else {
			if(odd>even) {
				Arrays.parallelSort(o);
				int sum=0;
				for(int q=0;q<odd-even-1;q++) {
					sum+=o[q];
				}
				out.println(sum);
			}else {
				Arrays.parallelSort(e);
				int sum=0;
				for(int q=0;q<even-odd-1;q++) {
					sum+=e[q];
				}
				out.println(sum);

			}
		}
		
		
		
		
		
		
		
		out.close();

	}
}
