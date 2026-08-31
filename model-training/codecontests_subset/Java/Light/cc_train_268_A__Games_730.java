import java.util.Scanner;

public class A_Games {

	public static void main(String[] args) {
	Scanner scan =new Scanner(System.in);
	int n=scan.nextInt();
	int []home=new int[n];
	int []guest=new int[n];
	for(int i=0;i<n;i++){
		home[i]=scan.nextInt();
		guest[i]=scan.nextInt();
		
	}
int matches=0;
for(int i=0;i<n;i++){
//	System.err.println(home[i]+"  "+guest[i]);
		for(int j=0;j<n;j++){
		if(i!=j)
			 if(home[i]==guest[j])
			matches++;
	}
}
System.out.println(matches);
	}

}
