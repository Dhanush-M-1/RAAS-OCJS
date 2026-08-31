import java.io.*;
import java.util.*;

public class CaninePoetry{
	public static void main(String args[]){
		Scanner Sc=new Scanner(System.in);
		PrintWriter writer=new PrintWriter(System.out);
		int T=Sc.nextInt();
		for(int t=0;t<T;t++){
			String input=Sc.next();
			int N=input.length();
			boolean visited[]=new boolean[N];
			for(int i=1;i<N;i++){
				
				if(input.charAt(i)==input.charAt(i-1)){
					if(!visited[i-1]){
						visited[i]=true;
					}
				}
				if(i<N-1 && visited[i-1]!=true &&
					input.charAt(i-1)==input.charAt(i+1)
				){
					visited[i+1]=true;
				}
			}
			int count=0;
			for(int i=0;i<N;i++){
				if(visited[i]){
					count++;
				}
			}
			writer.println(count);
		}
		writer.close();
	}
}