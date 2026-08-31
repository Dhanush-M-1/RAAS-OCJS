import java.util.*;
public class caninepoetry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0) {
          char[] curr=sc.next().toCharArray();
          int n=curr.length;
          int[] used=new int[curr.length];
          int ans=0;
          for(int i=1;i<curr.length;i++) {
        	  int use=0;
        	  if(curr[i]==curr[i-1] && used[i-1]==0) {
        		  use=1;
        	  }
        	  if(i>1 && curr[i]==curr[i-2] && used[i-2]==0 ) {
        		  use=1;
        	  }
        	  used[i]=use;
        	  ans+=used[i];
          }
          
          System.out.println(ans);
        }
	}

}
