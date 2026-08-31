
import java.util.*;


		
public class dummycodes{

public static  class Pair{
	int x;
	int y; 
	int z;
	public Pair(int x,int y ,int z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
}
	
public static boolean partition(int arr[],int sum,int i) {
	if(i>=arr.length || sum<0) return false;
	if(sum==0) return true;

	if(partition(arr, sum-arr[i], i+1)) return true;
	
	return partition(arr, sum, i+1);
	
	
}
	
	
	
	

	
	  public static void main(String args[])
  { Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  
int arr[]=new int[n];
int ones=0;
int twos=0;
for(int i=0;i<n;i++) {
	arr[i]=sc.nextInt();
if(arr[i]/100==1) ones++;
else twos++;
}

	if(twos==0 ) {
		if( (ones&1)==0) System.out.println("YES");
		else System.out.println("NO");}
	else  if((ones==0)  ) {
		if((twos&1)==0)System.out.println("YES");
		else System.out.println("NO");
	 }
	 
	else if(((ones-(2*twos))&1)==0) System.out.println("YES");
	
else System.out.println("NO");



  }
}

        
  
   
   
   
