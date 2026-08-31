import java.util.Scanner;

public class Main {
	static Scanner s = new Scanner(System.in);	
	static int N = -1;
	static int[][] treeInfo = null;
	static int[][] process = null;
	public static void main(String[] args) {
		init();
		solve();
	}
	public static void init(){
		N = s.nextInt();
		treeInfo = new int[2][N];
		process = new int[N][3];
		process[0][0] = 1;  //0 : 왼, 1 : 가운 2 : 오
		process[0][1] = 0;
		process[0][2] = 1;
		for(int i=0;i<N;i++){
			treeInfo[0][i] = s.nextInt();//point
			treeInfo[1][i] = s.nextInt(); //height;
		}	
	}
	
	public static void solve(){
		for(int i=1;i<N;i++){
			solveForLeft(i);
			solveForMiddle(i);
			solveForRight(i);
		}
		int Max = 0;
		for(int i=0;i<3;i++){
			if(Max<process[N-1][i])
				Max = process[N-1][i];
		}
		System.out.println(Max);
	}
	public static void solveForLeft(int curIndex){
		int maxTree = 0;
		int prv_tree_point = treeInfo[0][curIndex-1];
		int prv_tree_height = treeInfo[1][curIndex -1];
		int cur_tree_point = treeInfo[0][curIndex];
		int cur_tree_height = treeInfo[1][curIndex];
		//내전이 왼쪽이었다
		if(prv_tree_point < cur_tree_point - cur_tree_height){
			maxTree = process[curIndex-1][0] +1>process[curIndex-1][1] + 1?
					process[curIndex-1][0] +1:process[curIndex-1][1] + 1;
		}
		else{
			maxTree = process[curIndex-1][0]>process[curIndex-1][1]?
					process[curIndex-1][0]:process[curIndex-1][1] ;
		}
		//내 전이 오른쪽이래
		if(prv_tree_point+prv_tree_height<cur_tree_point-cur_tree_height){
			maxTree = maxTree>process[curIndex-1][2]+1?maxTree:process[curIndex-1][2]+1;
		}else{
			maxTree = maxTree>process[curIndex-1][2]?maxTree:process[curIndex-1][2];
		}
		process[curIndex][0] = maxTree;
		
	}
	public static void solveForMiddle(int curIndex){
		int maxTree = 0;
		for(int i=0;i<3;i++){
			if(maxTree<process[curIndex-1][i])
				maxTree = process[curIndex-1][i];
		}
		process[curIndex][1] = maxTree;
		
	}
	public static void solveForRight(int curIndex){
		int maxTree = 0;
		for(int i=0;i<3;i++){
			if(maxTree<process[curIndex-1][i])
				maxTree = process[curIndex-1][i];
		}
		if(curIndex==N-1){
			process[curIndex][2] = maxTree+1;
			return;
		}
		int nxt_tree_point = treeInfo[0][curIndex+1];
		int nxt_tree_height = treeInfo[1][curIndex +1];
		int cur_tree_point = treeInfo[0][curIndex];
		int cur_tree_height = treeInfo[1][curIndex];
	
		
		if(nxt_tree_point>cur_tree_point+cur_tree_height){
			process[curIndex][2] = maxTree+1;
		}else{
			process[curIndex][2] = maxTree;
		}
	}
	
	
}