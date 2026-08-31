import java.util.*;
public class Main{
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		int i,j,x,c;
		double max=0.0;
		int tn=sc.nextInt();
		Integer [] tc= new Integer [tn];
		
		int  pv=sc.nextInt();
		int  tv=sc.nextInt();
		int  pc=sc.nextInt();
		
		for(i=0;i<tn;i++){
			tc[i]=sc.nextInt();
		}
		
		Arrays.sort(tc, Collections.reverseOrder());
		
		c=0;
		
		for(i=0;i<tn;i++){
			if(i==0) max=pc;
			if(max/(pv+c*tv) < ((max+tc[i])/(pv+(c+1)*tv))){
				max=max+tc[i];
				c++;
			}
		}
		
		System.out.printf("%d\n",(int)max/(pv+c*tv));
		sc.close();
		System.exit(0);
	}
}