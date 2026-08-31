import java.util.*;
import java.util.Map.Entry;
 
class Main {
	 static int mod =  (int) (Math.pow(10,9)+7);
	 static List<ArrayList<Integer>> list= new ArrayList<ArrayList<Integer>>();
//	 static int mod = 998244353;
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        String S = sc.next();
	        char[] c = S.toCharArray();
	        int N=c.length;
	        int scnt=0;
	        int tcnt=0;
	        for(int i=0;i<c.length;i++) {
	        	if(c[i]=='S') {
	        		scnt++;
	        	} else if(scnt!=0) {
	        		scnt--;
	        	} else {
	        		tcnt++;
	        	}
	        }
	        
	        System.out.println(scnt+tcnt);
	        
	 }

}