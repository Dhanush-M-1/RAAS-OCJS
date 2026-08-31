import java.util.Scanner;


public class A {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int k=in.nextInt();
		String s =in.next();
		int count=0;
		String result_string="", result1="";
		boolean flag=true;
		int count_result=0;
		int result[][]=new int [30][2];
		char mas[]=s.toCharArray();
		//System.out.println(mas.length);
		//for(char o:mas) System.out.println(o);
		for (int i=0; i<mas.length; i++){
			if(mas[i]=='+')
				continue;
			for (int j=i; j<mas.length; j++)
				if(mas[i]==mas[j]){
					if(i==j)
						count++;
					else{
						count+=1;
					//	System.out.println(count);
						mas[j]='+';
					}
				}
		result[count_result][0]=(int) mas[i];
		result[count_result][1]=count;
		count_result++;
		//System.out.println(count);
		if (count%k!=0) {
			flag=false;
			break;
			}
		count=0;
		}
		if(flag){
			for(int i =0; i<count_result;i++){
				for(int j=0; j<result[i][1]/k; j++){
					result_string+=(char)result[i][0];
				}	
			}
			for(int i =0; i<k;i++)
				result1+=result_string;
			System.out.println(result1);
		}
		else{ System.out.println(-1);}
		}
	}
