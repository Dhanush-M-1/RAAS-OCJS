import java.util.Scanner;


public class KingofThieves {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String s = input.next();
	   int z = n/5;
	
	   
	   for(int i=0;i<n;i++){
		   for(int j=1;j<n;j++){
			   boolean condition = true;
			   
			   for(int k=0; k<5;k++){
				   if(i+k*j < n && s.charAt(i+k*j)== '*');
				   else
					   condition = false;
			   }
			   if(condition){
				   System.out.println("Yes");
				   System.exit(0);
			   }
		   }
	   }
	   System.out.println("No");
	   /*
	   int i=0;
	   while(i<n && s.charAt(i)!='*')i++;
	   //System.out.println(i);
	  int j=i;
	   while( j< n && s.charAt(j)=='*'){
		   j+=z;
	   }
	   if(j>=n)System.out.println("Yes");
	   else
		   System.out.println("No");
		
/*
	int max = 0;
		int indexleft = -1;
		int indexright = -1;
				
		for(int i=0;i<n;i++){
	/		int j = i;
			int counter = 0;
			while(s.charAt(i) == '.'){i++;counter++;}
			if(counter>max){
				indexleft = j;
				max = counter;
				indexright = j;
			}
		}
		for(int i=0;i<)
		*/		
	}

}
