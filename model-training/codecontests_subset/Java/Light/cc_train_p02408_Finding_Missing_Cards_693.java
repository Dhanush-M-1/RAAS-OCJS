import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc =new Scanner(System.in);
		int[] A=new int [52];
	   	for(int i=0;i<52;i++){
	   		A[i]=0;
	   	}
	   	int n= sc.nextInt();
    	int[] B=new int[n];
    	for(int i=0;i<n;i++){
    		String a=sc.next();
	    	int b=sc.nextInt();
	   		if(a.equals("S")){
	   			B[i]=b;
	   		}else if(a.equals("H")){
	   			B[i]=13+b;
    		}else if(a.equals("C")){
    			B[i]=26+b;
	    	}else if(a.equals("D")){
	    		B[i]=39+b;
	   		}
	   		for(int j=1;j<53;j++){
	   			if(j==B[i]){
	   				A[j-1]=1;
	   			}
	   		}
	   	}
    	for(int i=0;i<52;i++){
    		if(A[i]==0){
    			if(i+1<14){
    				System.out.println("S "+(i+1));
    			}else if(i+1<27){
    				System.out.println("H "+(i-12));
    			}else if(i+1<40){
    				System.out.println("C "+(i-25));
    			}else if(i+1<53){
    				System.out.println("D "+(i-38));
    			}
    		}
    	}
	}
}