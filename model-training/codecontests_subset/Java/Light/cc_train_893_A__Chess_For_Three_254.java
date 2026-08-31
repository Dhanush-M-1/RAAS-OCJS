import java.util.*;       
public class Main{        
public static void main(String args[]){
Scanner in=new Scanner(System.in);
int n=in.nextInt();
boolean f=true;
int player1=1,player2=2,s=0,temp=3;
for(int i=0;i<n;i++) {
	int m=in.nextInt();
	if(m==player1||m==player2) {
		if(m==player1)
		{   s=player2;
			player2=temp;
			temp=s;
		}   
		else {
			s=player1;
		    player1=temp;
		    temp=s;
	}
		}
	else {
		f=false;
		break;
	}
}
if(f==true)
	System.out.print("YES");
else
	System.out.print("NO");
}
}
 	  				 		 			  	 	 		      		