import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class hellow {
    
	static Scanner reader=new Scanner(System.in);
    public static void main(String[] args){
    	int n,sum1=0,sum2=0,sum3=0,m,p;
    	
    	n=reader.nextInt();
    	m=n-1;
    	p=n-2;
    	while(n--!=0)
    		sum1+=reader.nextInt();
    	while(m--!=0)
    		sum2+=reader.nextInt();
    	while(p--!=0)
    		sum3+=reader.nextInt();
    	System.out.println(sum1-sum2);
    	System.out.println(sum2-sum3);
    }
}

