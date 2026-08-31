import java.util.Scanner;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String s=sc.next(),k="keyence";
    int countl=0,countr=0,j=k.length();
    boolean flag=true;
    for(int i=0;i<s.length();i++) {
    	if(s.substring(i, i+1).equals(k.substring(countl, countl+1))) {
    		countl++;
    		if(countl==7) {
    			System.out.println("YES");
    			System.exit(0);
    		}
    	}else {
    		break;
    	}
    }
    for(int i=s.length();i>0;i--) {
    	if(s.substring(i-1, i).equals(k.substring(j-1, j))) {
    		countr++;
    		j--;
    		if(countr==7) {
    			System.out.println("YES");
    			System.exit(0);
    		}
    	}else {
    		break;
    	}
    }
    //System.out.println("count:"+countl+" countr:"+countr);
    if(countl+countr>=7) {
    	System.out.println("YES");
    }else {
    	System.out.println("NO");
    }
  }
}
