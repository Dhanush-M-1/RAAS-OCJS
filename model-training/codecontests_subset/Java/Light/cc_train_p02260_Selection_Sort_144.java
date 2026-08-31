

import java.util.Scanner;

class Main {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int sortLong=input.nextInt();
		
		int[] sortNumber=new int[sortLong];
		
		for(int i=0;i<sortLong;i++)
			sortNumber[i]=input.nextInt();
		
		int number=sort(sortNumber);
		for(int i=0;i<sortNumber.length-1;i++)
			System.out.print(sortNumber[i]+" ");
		System.out.println(sortNumber[sortNumber.length-1]);
		
		System.out.println(number);
		
	}
	
	public static int sort(int[] sortArray){
		int t,sw=0,minj;
		
		for(int i=0;i<sortArray.length-1;i++){
			minj=i;
			for(int j=i;j<sortArray.length;j++){
				if(sortArray[j]<sortArray[minj])
					minj=j;
			}
			
			t=sortArray[i];
			sortArray[i]=sortArray[minj];
			sortArray[minj]=t;
			
			if(i!=minj)
				sw++;
		}
		
		return sw;
	}

}