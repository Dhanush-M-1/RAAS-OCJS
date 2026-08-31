import java.util.Scanner;
class Main{
    public static void main(String[] av){
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	char[] ch=new char[]{'S','H','C','D'};

	boolean[][] b=new boolean[4][13];

	for(int i=0;i<n;i++){
	    char k=sc.next().charAt(0);
	    int a=sc.nextInt();
	    if(k=='S')	b[0][a-1]=true;
	    if(k=='H')	b[1][a-1]=true;
	    if(k=='C')	b[2][a-1]=true;
	    if(k=='D')	b[3][a-1]=true;
	}
	for(int i=0;i<4;i++){
	    for(int j=0;j<13;j++){
		if(!(b[i][j])){
		    System.out.println(ch[i]+" "+(j+1));
		}
	    }
	}
	}
}
