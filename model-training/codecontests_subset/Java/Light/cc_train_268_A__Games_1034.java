import java.util.Scanner;
public class javajava {
	
public static void main(String[] args)
{ Scanner in = new Scanner(System.in);
int [][] x= new int[in.nextInt()][2];
int count=0;
 for (int i =0; i<x.length;i++) {
	for (int j =0;j<2;j++) {
		x[i][j]=in.nextInt();
		
	}
  }
 for (int i=0;i<x.length;i++) {
	 int k = x[i][0];
			 for (int j =0; j<x.length;j++) {
				 if (k==x[j][1])
					 count+=1;
			 }
 }
System.out.println(count);
	
	
			}


		}
		

