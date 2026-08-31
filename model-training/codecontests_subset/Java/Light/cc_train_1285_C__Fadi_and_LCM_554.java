//package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner s = new Scanner(System.in);
//   B
long x=s.nextLong();
long a=(long)Math.sqrt(x);int flag=0;long min=Long.MAX_VALUE;long A=0;long B=0;
for(long i=1;i<=(long)Math.sqrt(x);i++){
    if(x%i==0){flag=1;
    if(Math.max(i,x/i)<min&&lcm(i,x/i)==x){
        min=Math.max(i,x/i);A=i;B=x/i;
    }
 //       System.out.println(i+" "+(x/i));break;
    }
}if(flag==0) {
            System.out.println(x+" "+1);
        }else{
            System.out.println(A+" "+B);
        }
    }
    static long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static long lcm(long a, long b)
    {
        return (a*b)/gcd(a, b);
    }
}
