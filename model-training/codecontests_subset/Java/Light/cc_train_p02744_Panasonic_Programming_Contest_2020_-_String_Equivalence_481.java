import java.util.*;
import java.util.Map.Entry;
 
class Main {
	 static int mod =  (int) (Math.pow(10,9)+7);
//	 static int mod = 998244353;
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        long N = sc.nextLong();
	        
			StringBuffer str=new StringBuffer();
	        
			LinkedList<l> queue = new LinkedList<l>();
			l z=new l();
			z.length=1;
			z.list[0]=0;
			z.max=0;
			queue.add(z);
			while(!queue.isEmpty()) {
				l zz = queue.poll();
				int[] list=new int[10];
				System.arraycopy(zz.list,0,list,0,10);
				int max=zz.max;
				int length=zz.length;
				if(N==length) {
					for(int j=0;j<N;j++) {
						str.append((char)(list[j]+'a'));							
					}
					str.append("\n");
				} else {
					for(int i=0;i<=max+1;i++) {
						l g=new l();
						g.length=length+1;
						g.max=Math.max(max, i);
						System.arraycopy(list,0,g.list,0,10);
						g.list[length]=i;
						queue.add(g);						
					}
				}

			}
	        System.out.println(str);
	 }
	 

}

	class l{
		int[] list=new int[10];
		int max;
		int length;
	}

