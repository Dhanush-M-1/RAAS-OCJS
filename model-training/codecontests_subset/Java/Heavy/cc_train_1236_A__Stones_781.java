import java.util.Scanner;

public class AStone {

	public static void main(String[] args) {

     Scanner sc=new Scanner(System.in);
     int t=sc.nextInt();
     while(t-->0) {
    	 int a=sc.nextInt();
    	 int b=sc.nextInt();
    	 int c=sc.nextInt();
    	 if(b==0) {
    		 System.out.println(0);
    	 }
    	 else {
    		 int sum=0;
             int m=c/2;
             if(m<=b) {
            	 sum=sum+(2*m)+m;
            	 b=b-m;
            	 int n=b/2;
            	 if(a>=n) {
            		 sum=sum+(2*n)+n;
            	 }
            	 else {
            		 sum=sum+(a*2)+a;
            	 }
             }
             else {
            	 sum=sum+(b*2)+b;
             }
             System.out.println(sum);
    		 
    		 
    		 
    		 
    		 
    		 }
    	 
     }
  sc.close();

	}

}
