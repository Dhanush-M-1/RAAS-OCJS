import java.util.*;
public class Partidos {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int i,n,s=0,j;
		n=sc.nextInt();
		int []a=new int[n];
		int []b=new int[n];
		for(i=0;i<n;i++){
			a[i]=sc.nextInt(); b[i]=sc.nextInt();
		}
		for(i=0;i<n;i++){
			for(j=0;j<n;j++){
				if(a[i]==b[j]){
					s++;
				}
			
			}
		}
		System.out.println(""+s);
	}

}