import java.util.*;
import java.io.*;
public class Template {
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int d){
			this.data = d;
			this.left = this.right = null;
		}
	}
	
	static int search(int[] arr, int l , int r) {
		int max = l;
		for(int i =l;i<=r;i++) {
			if(arr[max]<arr[i]) {
				max = i;
			}
		}
		return max;
	}
	
	static Node generate(int[] arr , int l , int r) {
		if(l>r)return null;
		if(l==r) {
			return new Node(arr[l]);
		}
		int mid = search(arr,l,r);
		Node root = new Node(arr[mid]);
		root.left = generate(arr,l,mid-1);
		root.right = generate(arr,mid+1,r);
		return root;
		
	}
	
	static void height(int[] dp , Node root, int h) {
		if(root==null)return;
		dp[root.data] = h;
		height(dp,root.left,h+1);
		height(dp,root.right,h+1);
	}

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t>0) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			String[] str = br.readLine().split(" ");
			for(int i =0;i<n;i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			
			int[] dp = new int[n+1];
			
			Node root = generate(arr,0,n-1);
			
			height(dp,root,0);
			for(int i:arr) {
				System.out.print(dp[i]+" ");
			}
			System.out.println();
			
			t--;
			
		}

	}

}