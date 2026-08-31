import java.util.*;
public class Iot{
	public static int recur(int l,int r,int d){
		int k =1;
		boolean p = true;
		//System.out.println("d "+d);
		while(p==true){
			if(k>=l && k<=r){
				k=r+1;
				p=true;
			}
			else if(k<l || k>r){
				if(k>r){
					if(k%d==0){
						p=false;
					}
					else{
						k=k+d-(k%d);
					    p=false;

					}
					
				}
				else {
					if(k%d==0){
						p=false;
					}
					else{
						k=k+d-(k%d);
						if(k<l || k>r){

						    p=false;
					    }
					    else{
						    p=true;
						    ///k=k+1;
					    }

					}
					//k=k+d-(k%d);
					
					
				}
				//p=true;
			}
			//System.out.println(k);

		}
		return(k);
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int matr[][] = new int[n][3];
		for(int i=0;i<n;i++){
			//String temp = in.next();
			//ch arr[] = new char[3] ;
			//arr = temp.split(" ");
			//arr = new char[3];
			for(int j=0;j<3;j++){
				matr[i][j]=in.nextInt();

			}

		}
		for(int i=0;i<n;i++){
			int g = recur(matr[i][0],matr[i][1],matr[i][2]);
			System.out.println(g);

		}

	}
}