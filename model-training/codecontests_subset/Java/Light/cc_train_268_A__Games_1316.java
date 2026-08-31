import java.util.Scanner;

public class Games {
    public static void main(String args[]){
	Scanner s = new Scanner(System.in);
	int c=0;
	int n = s.nextInt();
	int h[] = new int[n];
	int g[] = new int[n];
	for(int i=0; i<n; i++){
	    h[i]=s.nextInt();
	    g[i]=s.nextInt();
	}
	for(int i=0;i<n;i++){
	    for(int j=0;j<n;j++){
		if(h[j]==g[i]){
		    c++;
		}
	    }
	}
	System.out.print(c);
    }
}