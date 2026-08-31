import java.util.*;

public class Main {
 
    public static void main(String[] args) {
    	Scanner cin=new Scanner(System.in);
    	
    	String s=cin.nextLine();
    	char[] a=s.toCharArray();
    	int[] num=new int[a.length];
    	for (int i=0;i<num.length;i++) num[i]=0;
    	int n,last;
    	
    	int now=0;
    	n=0; last=1;
    	for (int i=0;i<a.length;i++){
    		if (a[i]=='('){
    			now++;
    			num[i]=1;
    		}else{
    			if (a[i]=='#') n++;
    			now--;
    			num[i]=-1;
    		}
    		
    		if (now<0){
    			System.out.println(-1);
    			cin.close();
    			return ;
    		}
    	}
    	
    	for (int i=a.length-1;i>=0;i--){
    		if (a[i]=='#'){
    			num[i]-=now;
    			last+=now;
    			break;
    		}
    	}
    	
    	now=0;
    	for (int i=0;i<a.length;i++){
    		now+=num[i];
    		if (now<0){
    			System.out.println(-1);
    			cin.close();
    			return ;
    		}
    	}
    	
    	for (int i=0;i<n-1;i++) System.out.println(1);
    	System.out.println(last);
    	
    	cin.close();
    }
}