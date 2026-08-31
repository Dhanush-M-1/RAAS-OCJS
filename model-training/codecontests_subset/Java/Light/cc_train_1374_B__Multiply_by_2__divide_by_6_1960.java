import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0){
		    int n = sc.nextInt();
		    int chk = n%3;
		    if(n == 1 ){
		        System.out.println(0);
		    }
		    
		    else if(chk!=0){
		        System.out.println(-1);
		    }
		    else{
		        int temp = n;
		        int cnt3 = 0; 
		        int cnt2 = 0; 
		        while(temp%3==0){
		            cnt3++;
		            temp /= 3; 
		        }
		        while(temp%2==0){
		            cnt2++;
		            temp /= 2; 
		        }
		        if(temp!=1 || cnt2>cnt3){
		            System.out.println(-1);
		        }
		        else{
		            System.out.println((cnt3+(cnt3-cnt2)));    
		        }
		        
		    }
		    
		    
		    
		    t--;
		    
		}
	}
}


