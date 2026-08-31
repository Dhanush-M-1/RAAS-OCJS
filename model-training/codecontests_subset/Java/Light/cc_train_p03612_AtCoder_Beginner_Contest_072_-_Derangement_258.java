import java.util.Scanner;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt(),count=0;
    int[] a=new int[n];
    for(int i=0;i<n;i++) {
    	a[i]=sc.nextInt();
    	if(a[i]==i+1)a[i]=1;
    	else a[i]=0;
    }
    for(int i=0;i<n;i++) {
    	if(a[i]==1) {
    		if(i!=n-1&&a[i+1]==1) {
    			a[i]=0;
    			a[i+1]=0;
    			count++;
    		}else {
    			a[i]=0;
    			count++;
    		}
    	}
    }
    System.out.println(count);
  }
}
