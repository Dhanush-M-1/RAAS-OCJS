import java.io.*;
import java.util.Arrays;
public class B550 {
	public static void main(String args[])
	throws java.io.IOException{
		int n;
		long sum=0;
		long res=0;
		int sizee=0, sizen=0;
		int even=0, noteven=0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());
		int a[] = new int[n];
		String str[] = new String[n];
		str = reader.readLine().split(" ");
		for(int i=0; i<n; i++) {
			a[i]=Integer.parseInt(str[i]);
			sum+=a[i];
			if(a[i]%2==0) even++;
			else noteven++;
			}
		int e[] = new int[even];
		int not[] = new int[noteven];
		for(int i=0; i<n;i++) {
			if(a[i]%2==0) {
				e[sizee]=a[i];
				sizee++;
			}
			else {
				not[sizen]=a[i];
				sizen++;
			}
		}
		Arrays.sort(e);
		Arrays.sort(not);
		if(even==noteven) {
			System.out.println(0);
		}
		else if (even>noteven) {
			even=even-noteven-1;
			for(int i=0; i<even;i++) {
				res+=e[i];
			}
			System.out.println(res);
		}
		else {
			noteven=noteven-even-1;
			for(int i=0; i<noteven;i++) {
				res+=not[i];
			}
			System.out.println(res);
		}
}}
