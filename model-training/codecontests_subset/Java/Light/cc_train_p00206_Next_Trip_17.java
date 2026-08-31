import java.util.*;
 
class Main {
    public static void main(String args[]) {
        int i,j,k=0;
		Scanner sc =new Scanner(System.in);
		int [][][]a=new int[1000][2][12];
		int [] S=new int [1000];
		
		S[0]=sc.nextInt();
		boolean judgment;
		
		do{
			
			
			for (i=0;i<12;i++)
				{a[k][0][i]=sc.nextInt();a[k][1][i]=sc.nextInt();}
			k++;
			S[k]=sc.nextInt();
		}while(S[k]!=0);

		for (j=0;j<k;j++){
		judgment = false;	
		for (i=0;i<12;i++){
			S[j]-=(a[j][0][i]-a[j][1][i]);
			//System.out.println(S[j]);
			if (S[j]<=0)
				{judgment=true;break;}}
		
		if (judgment) System.out.println(i+1);
		else System.out.println("NA");}

    }
}