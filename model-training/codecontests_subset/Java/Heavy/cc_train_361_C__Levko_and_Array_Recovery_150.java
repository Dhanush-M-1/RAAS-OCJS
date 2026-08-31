import java.util.ArrayList;
import java.util.Scanner;

public class Check {

	public static class Operator{
		public int operator;
		public int from;
		public int to;
		public int value;
		
		public Operator(){
			super();
		}
		
		public Operator(int op, int from, int to, int value){
			this.operator = op;
			this.from = from;
			this.to = to;
			this.value = value;
		}	
	}
	
	public static class Num{
		public int value;
		public boolean hasValue = false;
		
		public Num(){
			super();
			this.hasValue = false;
		}
		
		public Num(int value){
			this.value = value;
			this.hasValue = true;
		}	
		public Check.Num clone(){
			return new Num(this.value);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner scanner = new Scanner(System.in)){
			int n, k;
			n = scanner.nextInt();
			k = scanner.nextInt();
			ArrayList<Operator> opList = new ArrayList<Operator>();			
			ArrayList<Num> numList = new ArrayList<Num>(n);
			for(int i=0;i<n;i++){
				Num num = new Num();
				numList.add(num);
			}
			for(int i=0;i<k;i++){
				scanner.nextLine();
				Operator newOps = new Operator(scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
				opList.add(newOps);
			}
			for(int i=k-1;i>=0;i--){
				Operator ops = opList.get(i);
				if(ops.operator==2){
					//boolean canChange = false;
					for(int j=ops.from-1;j<=ops.to-1;j++){						
						Num num = numList.get(j);
						if(num.hasValue==false){
							//canChange = true;
							num.hasValue = true;
							num.value = ops.value;
							numList.set(j, num);
						}else if(num.value>ops.value){
						//	canChange = true;
							num.hasValue = true;
							num.value = ops.value;
							numList.set(j, num);
						} 						
					}
					//if(canChange==false){
				//		System.out.println("NO");
					//	return;
				//	}
				} else if(ops.operator==1){
					for(int j=ops.from-1;j<=ops.to-1;j++){						
						Num num = numList.get(j);
						if(num.hasValue){						
							num.value = num.value - ops.value;
							numList.set(j, num);
						}				
					}
				}
			}
			ArrayList<Num> resultList = new ArrayList<Num>(n);
			for(Num num : numList) {
				resultList.add(num.clone());
			}
			for(int i=0;i<=k-1;i++){
				Operator ops = opList.get(i);
				if(ops.operator==2){
					boolean canChange = false;
					for(int j=ops.from-1;j<=ops.to-1;j++){						
						Num num = numList.get(j);
						if(num.value==ops.value){
							canChange = true;
						}
						else if(num.value>ops.value){
							canChange = false;
							break;
						}
					}
					if(canChange==false){
						System.out.println("NO");
						return;
					}
				} else if(ops.operator==1){
					for(int j=ops.from-1;j<=ops.to-1;j++){						
						Num num = numList.get(j);
						if(num.hasValue){						
							num.value = num.value + ops.value;
							numList.set(j, num);
						}				
					}
				}
			}
			System.out.println("YES");
			for(int i=0;i<n;i++){
				Num num = resultList.get(i);
				if(num.hasValue){
					System.out.print(num.value);
				} else {
					System.out.print(0);
				}
				System.out.print(" ");
			}
		}				
	}

}