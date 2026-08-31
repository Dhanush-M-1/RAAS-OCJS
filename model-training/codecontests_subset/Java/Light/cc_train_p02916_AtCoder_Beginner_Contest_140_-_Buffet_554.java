import java.util.*;
public class Main {
 public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int n=sc.nextInt();
	int[] a=new int[n];
	int[] c=new int[n];
	int r=0;
    for(int i=0;i<n;i++)a[i]=sc.nextInt()-1;
    for(int i=0;i<n;i++)r+=sc.nextInt();
    for(int i=0;i<n-1;i++)c[i]=sc.nextInt();
    for(int i=1;i<n;i++)if(a[i-1]==a[i]-1)r+=c[a[i-1]];
	System.out.println(r);
 }
}