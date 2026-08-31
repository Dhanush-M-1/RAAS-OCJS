import java.util.*;



public class abc{

public static void main(String args[]){

Scanner sc;
sc=new Scanner(System.in);

int n=sc.nextInt();
int a[][];
a=new int[n][2];
int i,j,c=0;
for(i=0;i<=n-1;i++){
	a[i][0]=sc.nextInt();
	a[i][1]=sc.nextInt();

	}


for(i=0;i<=n-1;i++){

	for(j=0;j<=n-1 ;j++){
		if(i!=j){
			if(a[i][0]==a[j][1])
				c++;

		}

		

	}



}

System.out.println(c);

}
}



