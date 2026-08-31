import java.util.Scanner;

class Main{
    static public void main(String[] av){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int cnt = 0;
	for(int i=0; i<n; i++){
	    int x = sc.nextInt();
	    int flag = 0;
	    int y = (int)Math.sqrt(x);
	    for(int j=2; j<=y; j++){
		if(x%j == 0){
		    flag = 1;
		}
	    }
	    if(flag == 0){
		cnt++;
	    }
	}
	System.out.println(cnt);
    }
}
