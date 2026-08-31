import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s=new Scanner(System.in);
		
		int N=s.nextInt();//学生
		int M=s.nextInt();//チェックポイント
		long a[]=new long[N];//学生の位置
		long b[]=new long[N];
		long c[]=new long[M];//チェックポイントの位置
		long d[]=new long[M];
		long min=0;
		int l=0;
		
		int i=0,j=0;
		
		for(i=0;i<N;i++){
			a[i]=s.nextInt();
			b[i]=s.nextInt();
		}
		for(i=0;i<M;i++){
			c[i]=s.nextInt();
			d[i]=s.nextInt();
		}
		
	    for(i=0;i<N;i++){
	    	min=Math.abs(a[i]-c[0])+Math.abs(b[i]-d[0]);
	    	l=0;
	    	for(j=0;j<M;j++){
	    		if(min>Math.abs(a[i]-c[j])+Math.abs(b[i]-d[j])){
	    			min=Math.abs(a[i]-c[j])+Math.abs(b[i]-d[j]);
	    			l=j;
	    		}
	    	}
	    	System.out.println(l+1);
	    	
	    }

	}

}
