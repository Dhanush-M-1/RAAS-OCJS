import java.util.Scanner;
public class Solution {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int t = sc.nextInt();
    	while(t>0) {
    		int n = sc.nextInt();
    		int count=0;
    		while(n != 1) {
    			if(n%6 == 0) {
    				n = n/6;
    				count++;
    			}
    			else if(n%3 == 0){
    				n=n*2;
    				count++;
    			}
    			else {
    				count = -1;
    				break;
    			}
    		}
    		System.out.println(count);
    		t--;
    	}
    	sc.close();
    }
}