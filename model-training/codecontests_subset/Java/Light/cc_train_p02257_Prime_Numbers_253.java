import java.util.Scanner;
class Main{
    public static void main(String[] args){
	int count=0,i,j,yaku=0,n,m;
	
	Scanner scan = new Scanner(System.in);
	n = scan.nextInt();
	if(1>n || n>10000){System.exit(0);}
	 
	for(i=0;i<n;i++){  
	    m = scan.nextInt();
	    if(2>m || m>100000000){System.exit(0);} 
	    for(j=2;j<=Math.sqrt(m);j++){
		if(m%j==0){
		    yaku++;
		}
	    }
	    if(yaku==0){count++;}
	    yaku=0;
	}
	System.out.println(count);
    }
}

