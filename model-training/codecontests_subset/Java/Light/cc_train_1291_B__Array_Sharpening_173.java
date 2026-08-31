import java.util.*;
public class Boss
{
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int t=sc.nextInt();
	while(t-->0)
	{int n; n=sc.nextInt();
	    int tab[]=new int[n];
 
	    for (int i = 0; i < n; ++i)
		    tab[i]=sc.nextInt();
 
	    int p = -1, s = n;
 
	    for (int i = 0; i < n; ++i) {
		    if (tab[i] < i) break;
		    p = i;
	    }
	    for (int i = n-1; i >= 0; --i) {
		    if (tab[i] < (n-1)-i) break;
		    s = i;
	    }
 
	    if (s <= p) 
		    System.out.println("Yes");
	    else
		    System.out.println("No");
	}
	}
}