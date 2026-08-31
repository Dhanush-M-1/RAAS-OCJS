import java.math.*;    
import java.util.*;    
import java.io.*;   

public class Main {
	public void work(){
		long[] a = new long[3], b = new long[3], c = new long[3];
		while(cin.hasNext()){
			for(int i = 0; i < 3; i++){
				a[i] = cin.nextLong();
				b[i] = cin.nextLong();
				c[i] = cin.nextLong();
			}
			long inf = 1000000000L*1000000000L;
			long ans = inf;
			for(long i = 0; i <= 1000 && i*a[2]<ans; i++)
			{
				long z = 0;
				if(b[0]<=c[1])
					z = c[1] - b[0]+1;
				for(long j = z; j <= 1000 && (i*a[2]+j*b[2])<ans; j++)
					for(long k = 0; k <= 1000 ; k++)
					{
						long tmp = i*a[2]+j*b[2]+k*c[2];
						if(tmp >= ans)break;
						long x = inf, y = inf;
						x = a[1] / (j+b[0]-c[1]);
						if((a[1] % (j+b[0]-c[1]) )> 0)
							x++;
						
						if(b[1] > c[0]+k)
						{
							y = (a[0]+i) / (b[1]-c[0]-k);
							if(((a[0]+i) % (b[1]-c[0]-k))>0)
								y++;
						}
						if(x < y){
						//	System.out.println(i+" "+j+" "+" "+k+" "+tmp+" " + x+" " + y);
							ans = tmp;
						}
					}				
			}
			System.out.println(ans);
		}
	}
	Main() {  
        cin = new Scanner(System.in);  
    }  
    public static void main(String[] args) {
        Main e = new Main();  
        e.work();
    }
    public Scanner cin;
}
