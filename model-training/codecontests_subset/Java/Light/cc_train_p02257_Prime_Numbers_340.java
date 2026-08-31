import java.util.*;
public class Main {
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int n=sc.nextInt();
    	int m;
    	int reg=0;
        for(int i=0;i<n;i++){
        	m=sc.nextInt();
        	if(m==2||m==3){
        		reg++;
        	}
        	for(int j=2;j*j<m;j++){
        		if(m%j==0){
        			break;
        		}else if((j+1)*(j+1)>m){
        			reg++;
        		}
        	}
        }
        System.out.println(reg);

    }
}
