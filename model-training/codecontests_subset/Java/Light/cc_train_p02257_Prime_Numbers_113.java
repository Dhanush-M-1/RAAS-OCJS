import java.util.Scanner;
public class Main{
    public static void main(String[]args){
	int i,j,c,kazu,csosu=0;
	Scanner sc = new Scanner(System.in);
	    i=sc.nextInt();
	for(j=0;j<i;j++){
	    kazu=sc.nextInt();
	    for(c=(int)Math.sqrt(kazu);c>1;c--){
		if(kazu%c==0){
		    csosu+=1;
		    break;
		}
	    } 
	}
	csosu=i-csosu;
	System.out.println(csosu);
    }
}

