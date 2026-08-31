import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class E {

	private static int N, M;
	// private static int[] u, v, a, b, c;
	// private static long[][] dp;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int w[]=new int[N];
		int b[]=new int[M];
		for(int i=0;i<N;i++){//本の重さ
			w[i]=sc.nextInt();
		}
		for(int i=0;i<M;i++){//本の番号
			b[i]=sc.nextInt()-1;
		}
		int checker[]=new int[N];
		Arrays.fill(checker, 0);
		List<Integer> order=new ArrayList<>();
		for(int i=0;i<M;i++){
			if(checker[b[i]]==0){//まだ1回も読んでないなら
				order.add(b[i]);//その本を順番に追加
			}
			checker[b[i]]++;
		}
		Collections.reverse(order);//逆順にstackに追加したい
		Stack<Integer> stack=new Stack<>();
		Stack<Integer> tmpStack=new Stack<>();
		for(int i=0;i<order.size();i++){
			stack.push(order.get(i));
		}
		//simulate
		int total=0;
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				int tmpData=stack.pop();
				if(tmpData!=b[i]){//持ち上げ
					tmpStack.push(tmpData);
					total+=w[tmpData];
				}else{//戻す
					while(!tmpStack.isEmpty())
						stack.push(tmpStack.pop());

					stack.push(tmpData);
					break;
				}
			}
		}
		System.out.println(total);
		sc.close();
	}


}