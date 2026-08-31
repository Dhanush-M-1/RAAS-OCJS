import java.io.*;
import java.util.*;
public class vk18
{
    public static void main(String[]stp) throws Exception
    {
    	Scanner scan=new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String[] s;
        int n=scan.nextInt(),i;
        long count=0,l=scan.nextLong();
        long a[]=new long[n];
        for(i=0;i<n;i++) a[i]=scan.nextLong();
        Arrays.sort(a);
    	//for(i=0;i<n;i++) System.out.print(a[i]+" ");
    	//System.out.println();
    	for(i=0;i<(int)Math.ceil(n/2);i++) {if(a[i] > l) count+=a[i]-l;}
    	//System.out.println(count);
    	count+=Math.abs(l-a[n/2]);
    	//System.out.println(count+" "+Math.floor(n/2)+" "+Math.ceil(n/2));
    	for(i=(int)Math.floor(n/2)+1;i<n;i++) { if(a[i] < l) count+=l-a[i]; }
    	System.out.println(count);
    }
}
