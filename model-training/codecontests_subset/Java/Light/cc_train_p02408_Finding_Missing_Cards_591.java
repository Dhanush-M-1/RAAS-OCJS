import java.util.Scanner;

public class Main{
    public static void main(String args[]){
	final int type = 4;
	final int figure = 13;
	Scanner in =new Scanner(System.in);
	
	boolean[][] card = new boolean[type][figure];

	for(int i=0;i<type;i++){
	    for(int j=0; j<figure; j++){
		card[i][j]=false;
	    }
	}

	int n = in.nextInt();
	for(int i=0;i<n;i++){
	    String str = in.next();
	    int num = in.nextInt();
	    if(str.equals("S"))card[0][num-1]=true;
	    else if(str.equals("H"))card[1][num-1]=true;
	    else if(str.equals("C"))card[2][num-1]=true;
	    else if(str.equals("D"))card[3][num-1]=true;
	}

	for(int i=0;i<type;i++){
	    for(int j=0; j<figure; j++){
		if(card[i][j]==false){
		    if(i==0)System.out.println("S "+ (j+1));
		    else if (i==1)System.out.println("H "+ (j+1));
		    else if (i==2)System.out.println("C "+ (j+1));
		    else if (i==3)System.out.println("D "+ (j+1));
		}
	    }
	}
    }
}

