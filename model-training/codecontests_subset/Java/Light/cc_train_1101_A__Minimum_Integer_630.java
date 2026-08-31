import java.lang.*;
import java.util.*;
public class numbers{
	public static void main(String args[]){
	Scanner sc= new Scanner(System.in);
	int queries= sc.nextInt();
	for(int i=0;i<queries;i++){
	int l=sc.nextInt();
	int r=sc.nextInt();
	int d=sc.nextInt();
     if(d<l){
     System.out.println(d);
     }
     else{
     double a=r/d;
     int c=(int)a+1;
     System.out.println(d*c);
     }
	}
	} 
}