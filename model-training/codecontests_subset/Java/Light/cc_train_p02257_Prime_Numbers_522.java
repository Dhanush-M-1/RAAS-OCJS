import java.io.*;

class Main{

static final PrintWriter out=new PrintWriter(System.out);

public static void main(String[] args) throws IOException{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int n=Integer.parseInt(br.readLine());
int ans=0;
for(int i=0;i<n;i++){
int a=Integer.parseInt(br.readLine());
if(isPrime(a)) ans++;
}
out.println(ans);
out.flush();
}

private static boolean isPrime(int a){
if(a==2||a==3||a==5||a==7) return true;
if(a%2==0) return false;
for(int i=3;i<=Math.sqrt(a);i++){
if(a%i==0) return false;
}
return true;
}
}