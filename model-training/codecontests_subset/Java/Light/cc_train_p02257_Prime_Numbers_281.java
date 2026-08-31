
import java.util.*;
public class Main {

	public static void main(String[] args) {
		  Scanner cin=new Scanner(System.in);
		  List<Integer> list=new ArrayList<>();
		  int n=cin.nextInt(),res=0;
		  for(int i=0;i<n;i++)list.add(cin.nextInt());
		  
		  for(int i=0;i<n;i++) {
			  int x=list.get(i),limit=(int)(Math.sqrt(x)),j;
			  
			  for(j=limit;j>1;j--) {
				  if(x%j==0)break;
			  }
			  
			  if(j==1)res++;
			  
		  }
		  
		  System.out.println(res);
		  
	}

}

