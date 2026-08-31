import java.io.*;
import java.util.*;
import java.lang.*;
public class nastyalunch{
	static class Node{
		Node next;
		int data ;
		Node(){
			next=null;
			data=0;
		}
	}
	static class Graph{
		Node start;
		Node last;
		int size;
		Graph(){
			start=null;
			last=null;
			size=0;
		}
	}
	public static void main(String args[]){ 
			try{
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String[] inp = br.readLine().trim().split("\\s+");

				int n = Integer.parseInt(inp[0]);
				int k = Integer.parseInt(inp[1]);
				int[] arr=new int[n+1];
				Graph[] gr = new Graph[n+1];

				inp = br.readLine().trim().split("\\s+");
				for(int i = 1 ; i<n+1 ; i++){
					arr[i] = Integer.parseInt(inp[i-1]);
					gr[i]=new Graph();
				}

				int[] ar = new int[n+1] ;

				for(int i = 0 ; i<k ; i++){
					inp = br.readLine().trim().split("\\s+");
	                int y = Integer.parseInt(inp[0]);
	                int x = Integer.parseInt(inp[1]);
	                if(gr[x].size==0){
	                    Node trr = new Node();
	                    trr.data = y;
	                    gr[x].start = trr ; 
	                    gr[x].last = gr[x].start;
	                    gr[x].size+=1;
	                }
	                else{
	                    gr[x].size+=1;
	                    Node trr = new Node();
	                    trr.data = y;
	                    gr[x].last.next=trr;
	                    gr[x].last= gr[x].last.next;
	                }
				}
				Node tu = gr[arr[n]].start;
				for(int i=0 ; i<gr[arr[n]].size ; i++){
					ar[tu.data]=1;
					tu=tu.next;
				}
				int ans=0;
				int p = 1;
				for(int i = n-1 ; i>0 ; i--){
					if(ar[arr[i]]==p){
						ans+=1;
					}
					else{
						tu = gr[arr[i]].start;
						for(int df=0; df<gr[arr[i]].size ; df++){
							ar[tu.data]+=1;
							tu=tu.next;
						}
						p+=1;
					}
				}
				System.out.println(ans);

				/*int flag = 0;
				int pointer = n-2;
				int size = 1;
				int[] gh = new int[n];
				for(int kj =0 ; kj<n ;kj++){
					gh[kj] = nodes[arr[n-1]-1][kj];
				}
				while(pointer>=0 && flag==0){
					//System.out.println(size);
					if(gh[arr[pointer]-1] == 1 ){
						pointer-=1;
					}
					else{
						for(int kj = 0 ; kj < n ; kj++ ){
							if(ar[arr[pointer]-1]==0){
								flag=1;
								break;
							}else{
								gh[kj] = gh[kj]*nodes[arr[pointer]-1][kj];
							}
							
						}
						if(flag==0){
							size+=1;
							pointer-=1;
						}
					}
				}
				System.out.println(n-size-pointer-1);*/
			}
			catch(Exception E){}
	}
}
