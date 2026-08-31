import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class MultiplicationTable {

	/**
	 * @param args
	 */
	public static String convert(BigInteger n,int radix){
		int num=Integer.parseInt(n.toString());
		String s="";
		while(num/radix!=0){
			s+=num%radix;
			num/=radix;
		}
		s+=num%radix;
		return new StringBuffer(s).reverse().toString();
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String s=r.readLine();
		int radix=Integer.parseInt(s);
		int[] num=new int[radix-1];
		for(int i=1;i<=num.length;i++)num[i-1]=i;
		String[][] m=new String[radix-1][radix-1];
		for(int i=0;i<num.length;i++){
			for(int j=0;j<num.length;j++){
				m[i][j]=convert(new BigInteger(num[i]+"",radix).multiply(new BigInteger(num[j]+"",radix)),radix);
				
			}
		}
		for(int i=0;i<num.length;i++){	
			if(i!=0)
			System.out.println();
			for(int j=0;j<num.length;j++){
				if(j!=num.length-1)
				System.out.print(m[i][j]+" ");
				else
					System.out.print(m[i][j]+" ");
			}
		}
	}

}
