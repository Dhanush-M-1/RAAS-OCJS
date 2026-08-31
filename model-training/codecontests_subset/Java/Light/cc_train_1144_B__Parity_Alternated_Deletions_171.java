import java.util.*;
public class parity{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
			int n = sc.nextInt();
			ArrayList<Integer> odd =  new ArrayList<>();
			ArrayList<Integer> even =  new ArrayList<>();
			for(int i=0;i<n;i++){
				int  a= sc.nextInt();
				if(a%2==1){
					odd.add(a);
				}
				else{
					even.add(a);
				}
			}
			int sum=0;
			Collections.sort(odd);
			Collections.sort(even);
			if(odd.size()>even.size()){
				for(int i=0;i<odd.size()-(even.size()+1);i++){
					sum+=odd.get(i);
				}
              
			}
			else{
				for(int i=0;i<even.size()-(odd.size()+1);i++){
					sum+=even.get(i);
				}

			}
			System.out.println(sum);
		
	}
}