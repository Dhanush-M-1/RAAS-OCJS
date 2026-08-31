import java.io.*;
import java.util.*;
public class min{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int arr[][]=new int[n][3];
for(int i=0;i<n;i++){
for(int j=0;j<3;j++){
arr[i][j]=sc.nextInt();
}
}
for(int i=0;i<n;i++){
if(arr[i][0]<=arr[i][2])
System.out.println(((arr[i][1]/arr[i][2])+1)*arr[i][2]);
else 
System.out.println(arr[i][2]);
}

}}
