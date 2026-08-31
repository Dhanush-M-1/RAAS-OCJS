import java.util.Scanner;






public class A273 {

	
	public static void main(String[]args){
	
    Scanner sc = new Scanner(System.in);
    
    int a=sc.nextInt();
    int b=sc.nextInt();
    int c=sc.nextInt();
    int d=sc.nextInt();
    int e=sc.nextInt();
    
    
    int sum =a+b+c+d+e;
    
    
    if(a==0&&b==0&&c==0&&d==0&&e==0)
    {
    	System.out.println(-1);
    	return;
    }
    
    
    
	if(sum%5==0)
		System.out.println(sum/5);
	else 
		System.out.println(-1);
	
}
}