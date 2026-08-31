import java.util.*;
import java.math.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String s;
        int fac[] =new int[1005];
        s = cin.nextLine();
        int len = s.length();
        int now = 1;
        int cnt = 0;
        boolean flag = false;
        int r = 0;
        fac[cnt++] = 1;
        for(int i = 0; i < len; ++i){
        	if(s.charAt(i) == '+'){
        		now++;
        		fac[cnt++]=1;
        	}
        	else if(s.charAt(i) == '-'){
        		now--;
        		fac[cnt++]=-1;
        	}
        	else if(s.charAt(i) == '='){
        		flag = true;
        	}
        	if(flag){
        		if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
        			r = r * 10 + (s.charAt(i)-'0');
        		}
        	}
        }
        for(int i = 0; i < cnt; ++i){
        	while((now < r) &&(fac[i] < r) && (fac[i] > 0)){
        		fac[i]++;
        		now++;
        	}
        	while((now > r) &&(fac[i] > -r) && (fac[i] < 0)){
        		fac[i]--;
        		now--;
        	}
        }
        if(now != r){
        	System.out.println("Impossible");
        }else {
        	System.out.println("Possible");
        	System.out.print(fac[0] + " ");
        	int o = 1;
        	for(int i = 0; i < len; ++i){
        		if(s.charAt(i) == '-'){
        			System.out.print("- " + (-fac[o++]) + " ");
        		}else if(s.charAt(i) == '+') {
        			System.out.print("+ " + fac[o++] + " ");
        		}
        	}
        	System.out.println("= " + r);
        }
    }
}