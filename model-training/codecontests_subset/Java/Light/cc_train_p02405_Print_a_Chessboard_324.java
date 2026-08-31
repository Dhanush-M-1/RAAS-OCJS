import java.io.*;
class Main{
public static void main(String[] args)throws IOException{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
boolean i=true;
while(i){
String str=br.readLine();
String[] arr=str.split(" ");
int h=Integer.parseInt(arr[0]);
int w=Integer.parseInt(arr[1]);
if(h==0 && w==0)  i=false;
else{
for(int k=0; k<h; k++){
for(int j=0; j<w; j++){
if(k%2==0){
if(j%2==0) System.out.print("#");
else  System.out.print(".");
}
else{
if(j%2==0) System.out.print(".");
else  System.out.print("#");
}
}
System.out.println();
}
System.out.println();
}
}
br.close();
}
}