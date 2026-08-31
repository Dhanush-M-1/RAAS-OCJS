import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t-->0){
	        int n=sc.nextInt();
	        int c=0,p=0,tc=0,tp=0,f=0;
	        for(int i=0;i<n;i++){
	            p=sc.nextInt();
	            c=sc.nextInt();
	            if(i==0){
	                tp=p;
	                tc=c;
	                if(p<c){
	                    f=1;
	                }
	            }
	            else{
	                
	                if(tp>p){
	                    f=1;
	                }
	                
	                if(tc>c){
	                    f=1;
	                }
	                if(p-tp<c-tc) f=1;
	                tp=p;
	                tc=c;
	                if(p<c){
	                    f=1;
	                }
	            }
	        }
	        if(f==0)
	        System.out.println("YES");
	        else
	        System.out.println("NO");
	    }
	}
}
