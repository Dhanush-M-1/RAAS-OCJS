
import java.math.BigInteger;
import java.math.*;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.*; 

public class Main
{
    public static void main(String[] args){
    	Scanner cin=new Scanner(System.in);
    	int numa = cin.nextInt();
    	int numb = cin.nextInt();
    	int len;
    	if(numa > numb) {
    		len = numa - numb;
    	}
    	else {
    		len = numb - numa;
    	}
    	int ans;
    	if(len%2 == 0) {
    		ans = (len/2)*(len/2+1);
    	}
    	else {
    		ans = (len/2)*(len/2+1)+(len/2+1);
    	}
    	System.out.println(ans);
    }
}