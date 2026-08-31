import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st=new StringTokenizer(bf.readLine().trim());
int a=Integer.parseInt(st.nextToken()),b=Integer.parseInt(st.nextToken());
int na2,na3,na5,nb2,nb3,nb5;
na2=na3=na5=nb2=nb3=nb5=0;
while(a%2==0)
{
	na2+=1;
	a=a/2;}
while(a%3==0)
{
	na3+=1;
	a=a/3;}
while(a%5==0)
{
	na5+=1;
	a=a/5;}
while(b%2==0)
{
	nb2+=1;
	b=b/2;}
while(b%3==0)
{
	nb3+=1;
	b=b/3;}
while(b%5==0)
{
	nb5+=1;
	b=b/5;}
if(a!=b)
	System.out.println(-1);
else {
	
	int min=0;
	min+=Math.abs(na2-nb2)+Math.abs(na3-nb3)+Math.abs(na5-nb5);
	System.out.println(min);
}
	}

}
