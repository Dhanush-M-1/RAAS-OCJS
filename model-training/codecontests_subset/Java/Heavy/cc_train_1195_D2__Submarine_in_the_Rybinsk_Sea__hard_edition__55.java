import java.util.*;
import java.io.*;
public class EdE {

	public static void main(String[] args) throws Exception{
		long num = 998244353;

		// TODO Auto-generated method stub
 		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 		PrintWriter out = new PrintWriter(System.out);
 		int n = Integer.parseInt(bf.readLine());
 		StringTokenizer st = new StringTokenizer(bf.readLine());
 		ArrayList<Integer> array = new ArrayList<Integer>();
 		long[] numbers = new long[n];
 		for(int i = 0;i<n;i++){
//	 		String input1 = bf.readLine().trim();
//	 		String input2 = bf.readLine().trim();
	 		numbers[i] = Long.parseLong(st.nextToken());
	 		long temp = numbers[i];
	 		int count = 0;
	 		while(temp > 0){
	 			temp /=10;
	 			count+=1;
	 		}
	 		array.add(count);
	 		
 		}
 		long[] powers10 = new long[22];
 		powers10[0] = 1;
 		for(int j = 1;j<22;j++){
 			powers10[j] = (powers10[j-1]*10L)%num;
 		}
 		long[] freqcount = new long[11];
 		for(int j = 0;j<array.size();j++){
 			freqcount[array.get(j)]++;
 		}
 		Collections.sort(array);
 		long sum =0 ;
 		for(int j =0;j<n;j++){
 			long k = numbers[j];
 			int dcount =0;
 			while(k > 0){
 				for(int z=dcount;z>0;z--){
 					sum+=(((powers10[dcount+z]*(long)(k%10))%num)*freqcount[z])%num;
 					sum%=num;
 				}
 				for(int z =10;z>dcount;z--){
 					sum+=(((powers10[dcount*2+1]*(long)(k%10))%num)*freqcount[z])%num;
 				}
 				
 				
 				for(int z=dcount-1;z>0;z--){
 					sum+=(((powers10[dcount+z]*(long)(k%10))%num)*freqcount[z])%num;
 					sum%=num;
 				}
 				for(int z =10;z>=dcount;z--){
 					sum+=(((powers10[dcount*2]*(long)(k%10))%num)*freqcount[z])%num;
 					sum%=num;
 				}
 				
 				k/=10;
 				dcount++;
 			}
 		}
 		
 		
 		out.println(sum);
	 		
 		out.close();
 		
 		
 		
 	}
	public static int power(long x, long y, long mod){
		long ans = 1;
		while(y>0){
			if (y%2==1)
				ans = (ans*x)%mod;
			x = (x*x)%mod;
			y/=2;
		}
		return (int)(ans);
	}
}
 	
 
//StringJoiner sj = new StringJoiner(" "); 
//sj.add(strings)
//sj.toString() gives string of those stuff w spaces or whatever that sequence is

 		
 		
 		
 		
	


