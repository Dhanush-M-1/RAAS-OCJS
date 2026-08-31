import java.util.Scanner;
public class Game{
	public static void main(String arg[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] home=new int[n];
		int[] guest=new int[n];
		int count=0;
		for(int i=0;i<n;i++){
			home[i]=sc.nextInt();
			guest[i]=sc.nextInt();
					}
	for(int i=0;i<n;i++){
	for(int j=0;j<n;j++){
	if(home[i]==guest[j])count++;
			}
		}			
     System.out.println(count);	

	} 
}