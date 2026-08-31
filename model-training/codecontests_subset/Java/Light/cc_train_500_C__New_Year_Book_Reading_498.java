import java.util.*;
public class Main {
    public static void main(String[] args) {
    	Scanner in = new Scanner (System.in);
    	int b=in.nextInt(),r=in.nextInt();
    	int a[]=new int[b+1];
    	LinkedList<Integer> s=new LinkedList<>();
    	for(int i=1;i<=b;i++) {
    		a[i]=in.nextInt();
    	}
    	int t,ind,ans=0;
    	for(int i=0;i<r;i++) {
    		t=in.nextInt();
    		if(!s.contains(t)) {
    			s.add(t);
    		}
   			ind=s.indexOf(t);
    		for(int j=0;j<ind;j++) {
    			ans+=a[s.get(j)];
    		}
    		s.remove(ind);
    		s.addFirst(t);
    	}
    	System.out.print(ans);
        in.close();
    }
     
}