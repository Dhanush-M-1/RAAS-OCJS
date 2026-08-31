import java.util.*;

public class Main{
    public static void main(String[] args){
	int count = 0;
	boolean p = true;
	Scanner a = new Scanner(System.in);
	int n = a.nextInt();
	int m[] = new int[n];
	for(int i = 0; i < n; i++){
	    m[i] = a.nextInt();
	}
	for(int i=0; i<n; i++){
	    p = true;
	    if(m[i]==2){
	        count++;
	    }
	    else if(m[i]>2 && m[i]%2==0){
	        continue;
	    }
	    else{
		for(int j=3; j <= Math.sqrt(m[i]); j+=2){
		    if(m[i]%j == 0){
			p = false;
			break;
		    }
		}
		if(p){
		count++;
		}
	    }
	}
	System.out.println(count);
    }
}

