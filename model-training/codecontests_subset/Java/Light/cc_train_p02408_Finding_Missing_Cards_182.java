import java.io.*;
class Main{
public static void main(String[] args)throws IOException{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
String str=br.readLine();
int n=Integer.parseInt(str);
int[][] tramp=new int[4][13];
if(n==52)  return;
for(int i=0; i<n; i++){
String str2=br.readLine();
String[] card=str2.split(" ");
int c=Integer.parseInt(card[1])-1;
switch(card[0]){
case "S": tramp[0][c]=1; break;
case "H": tramp[1][c]=1; break;
case "C": tramp[2][c]=1; break;
case "D": tramp[3][c]=1; break;
default:  break;
}
}
for(int j=0; j<4; j++){
for(int k=0; k<13; k++){
if(tramp[j][k]==0){
switch(j){
case 0: System.out.println("S "+(k+1)); break;
case 1: System.out.println("H "+(k+1)); break; 
case 2: System.out.println("C "+(k+1)); break;
case 3: System.out.println("D "+(k+1)); break;
default: break;
}
}
}
}
br.close();
}
}