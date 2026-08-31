import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.io.*;


public class Xtend {

public static void main(String[] args)throws IOException{
BufferedReader x=new BufferedReader(new InputStreamReader(System.in));
int a=Integer.parseInt(x.readLine());
String[][]array=new String[a-1][a-1];
for(int i=1;i<=a-1;i++){
	for(int j=1;j<=a-1;j++){
		array[i-1][j-1]=Integer.toString(i*j,a);
	}
}
for(int r=0;r<a-1;r++){
	for(int s=0;s<a-1;s++){
		System.out.print(array[r][s]+" ");
	}
	System.out.println();
}
}

}