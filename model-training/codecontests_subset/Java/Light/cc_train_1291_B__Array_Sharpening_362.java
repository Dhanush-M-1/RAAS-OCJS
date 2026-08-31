
import java.util.Scanner;

public class codeforce {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	int t=scan.nextInt();
	
	while(t>0)
	{
		int n=scan.nextInt();
		int [] a=new int[n];
		int i;
		for(i=0;i<n;i++)
		a[i]=scan.nextInt();
	

	    int prefixEnd = -1;
	    		int suffixEnd = n;

	    for (i = 0; i < n; ++i) {
		    if (a[i] < i) break;
		    prefixEnd = i;
	    }
	    for (i = n-1; i >= 0; --i) {
		    if (a[i] < (n-1)-i) break;
		    suffixEnd = i;
	    }

	    if (suffixEnd <= prefixEnd) // Non-empty intersection
		    System.out.println("YES");
	    else
		    System.out.println("NO");;
		t--;
	}
	
}
}
