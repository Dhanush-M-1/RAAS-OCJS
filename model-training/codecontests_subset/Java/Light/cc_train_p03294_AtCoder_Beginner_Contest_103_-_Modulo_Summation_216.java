import java.util.*; 

class Main{
public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

  		long[] a=new long[n];
  		long ans=0;
		for(int c=0;c<n;c++){
    		a[c]=sc.nextInt();
            ans+=a[c]-1;
    	}
  

    	System.out.println(ans);
    }

}