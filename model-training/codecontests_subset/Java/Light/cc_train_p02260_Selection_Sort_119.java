import java.util.*;

public class Main {
	int selectionSort(int[] lst){
		int n=lst.length;
		int count=0;
		for(int i=0;i<n-1;i++){
			int min=Integer.MAX_VALUE;
			for(int j=i;j<n;j++){min=Math.min(min, lst[j]);}
			if(min==lst[i]){continue;}
			for(int j=i+1;j<n;j++){
				if(min==lst[j]){
					int x=lst[i];
					lst[i]=lst[j];lst[j]=x;
					count++;break;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args){
	    Scanner sc = new Scanner(System.in);
	    int n=sc.nextInt();
	    int[]x=new int[n];
	    for(int i=0;i<n;i++){x[i]=sc.nextInt();}
	    int c=new Main().selectionSort(x);
	    for(int i=0;i<n;i++){
	        if(i==0){System.out.printf("%d",x[i]);continue;}
	        System.out.printf(" %d",x[i]);
	    }
	    System.out.printf("\n%d\n",c);
	}
}
