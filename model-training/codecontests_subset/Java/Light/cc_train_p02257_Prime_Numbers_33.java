import java.util.*;

public class Main {
	boolean PrimeJudge (int n){
		if(n==2){return true;}
		if(n%2==0){return false;}
		for(int i=3;i<(int)(Math.sqrt(n))+1;i++){
			if(n%i==0){return false;}
		}
		return true;
	}
	public static void main(String[] args){
	    Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int count=0;
        for(int i=0;i<n;i++){
            if(new Main().PrimeJudge(sc.nextInt())){count++;}
        }
        System.out.println(count);
	}
}
