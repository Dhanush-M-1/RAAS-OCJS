
import java.awt.geom.Point2D;
import java.util.*;
 
public class Main {
    Scanner sc = new Scanner(System.in);
 
    public static void main(String[] args) {
        new Main(); 
    }
 
    public Main() {
    	new aoj0167().doIt();
    }
    class aoj0167{
    	void doIt(){
    		while(true){
    			int n = sc.nextInt();
        		if(n == 0)break;
        		int a[] = new int [n];
        		for(int i = 0;i < n;i++){
        			a[i] = sc.nextInt();
        		}
        		System.out.println(Bubble(a,n));
    		}
    	}
    	int Bubble(int a[],int n){
    		int result = 0;
    		for(int i = 0;i < n;i++){
    			for(int j = 0;j < n-1;j++){
    				if(a[j] > a[j+1]){
    					int temp = a[j];
    					a[j] = a[j+1];
    					a[j+1] = temp;
    					result++;
    				}
    			}
    		}
    		return result;
    	}
    }
}