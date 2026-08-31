
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main 
{
	public static void main(String[] args) 
	{
		 int [] both = new int [200010];
		 int [] Alic = new int [200010];
		 int [] Bob = new int [200010];
		 int x = 0, y = 0, z = 0;
	     Scanner s = new Scanner(System.in);
	     int n, k;
	     n = s.nextInt();
	     k = s.nextInt();
	     for(int i = 0; i < n; ++ i)
	     {
	    	 int t, a, b;
	    	 t = s.nextInt();
	    	 a = s.nextInt();
	    	 b = s.nextInt();
	    	 if(a == 1 && b == 1) both[x++] = t;
	    	 else if(a == 1 && b == 0) Alic[y ++] = t;
	    	 else if(a == 0 && b == 1) Bob[z ++] = t;
	     }
	     Arrays.sort(both,0,x);
	     Arrays.sort(Alic,0,y);
	     Arrays.sort(Bob,0,z);
//	     for(int i = 0; i < x; ++ i)
//	    	  System.out.println(both[i]);
//	     System.out.println("----------------");
//	     for(int i = 0; i < y; ++ i)
//	    	  System.out.println(Alic[i]);
//	     System.out.println("----------------");
//	     for(int i = 0; i < z; ++ i)
//	    	  System.out.println(Bob[i]);
//	     System.out.println("----------------");
	     
	     if(Math.min(y, z) + x < k) System.out.print(-1);
	     else 
	     {
	    	 int sum = 0, t = 0;
	    	 int ans1 = 0, ans2 = 0, ans3 = 0; 
	    	 while(t < k)
	    	 {
	    		 if(ans1 >= x)
	    		 {
	    			 sum += Alic[ans2 ++] + Bob[ans3 ++];
	    		 }
	    		 else if(ans2 >= y || ans3 >= z)
	    		 {
	    			 sum += both[ans1 ++];
	    		 }
	    		 else 
	    		 {
	    			 if(Alic[ans2] + Bob[ans3] > both[ans1])
	    				 sum += both[ans1 ++];
	    			 else sum += Alic[ans2 ++] + Bob[ans3 ++];
	    		 }
	    		 t ++;
	    	 }
	    	 System.out.print(sum);
	     }
	}
}
