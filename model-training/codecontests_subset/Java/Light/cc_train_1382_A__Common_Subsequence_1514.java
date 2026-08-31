import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner sc =new Scanner(System.in);
	    int t=sc.nextInt();
	    for(int i=0;i<t;i++) {
	        int n=sc.nextInt();
	        int m=sc.nextInt();
	        int flag=0;
	        ArrayList<Integer> list1=new ArrayList<Integer>();
	        ArrayList<Integer> list2=new ArrayList<Integer>();
	        
	        for(int j=0;j<n;j++) {
	            list1.add(sc.nextInt());
	        }
	        for(int k=0;k<m;k++) {
	            list2.add(sc.nextInt());
	        }
	        
	        for(Integer num : list1){
	            if(list2.contains(num)) {
	                System.out.println("YES");
	                System.out.println(1 + " " + num);
	                flag++;
	                break;
	            }
	        }
	        if(flag==0) {
	            System.out.println("NO");
	        }
	    }
		
	}
}
