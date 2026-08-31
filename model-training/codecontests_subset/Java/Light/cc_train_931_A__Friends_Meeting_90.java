import java.util.*;
public class pro931A{
  public static int compute(int x){
    int res =0;
    if(x%2 == 0){
	    for(int i=1;i<=x/2;i++){
	      res += 2*i;
	    }
    	return res;
    }
    else{return compute(x-1)+ (x/2) +1;}
  }
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    sc.close();
    int c = Math.abs(a-b); 
    if(c == 1 || c == 0){System.out.println(c);}
    else{System.out.println(compute(c));}
  }
}
