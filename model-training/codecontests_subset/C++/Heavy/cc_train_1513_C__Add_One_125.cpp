#include<bits/stdc++.h>
using namespace std;

long long m=200000,k=1;
long long sum[200001][10]={{}};
long long a[10]={1,1,1,1,1,1,1,1,1,1},b[10];

int main(){
	ios_base::sync_with_stdio(false);
	long long j=9;
	k=1;
		ios_base::sync_with_stdio(false);

	for(long long i=0;i<=9;i++)
	a[i]=0;
	a[j]=1;
	while(k<=m)
{
	for(long long i=0;i<=9;i++)
	b[i]=0;
	for(long long i=0;i<=9;i++){
		
		if(i<=8)
		{
		b[i+1]+=a[i];
		b[i+1]%=1000000007;}
		else if(i==9)
		{
		b[1]+=a[i];b[0]+=a[i];
		b[1]%=1000000007;b[1]%=1000000007;}
		a[i]=0;
	}
	ios_base::sync_with_stdio(false);
	//if(k==1&&j==9)
	//cout<<b[9]<<endl;
	for(long long i=0;i<=9;i++)
	a[i]=b[i];
	for(long long i=0;i<=9;i++)
	{
	sum[k][j]+=a[i];
	sum[k][j]%=1000000007;
}
k++;}



	ios_base::sync_with_stdio(false);	
	long long t;
	cin>>t;
	while(t--){
			ios_base::sync_with_stdio(false);

		long long n,m;
		cin>>n>>m;
		long long p=0;
		while(n!=0){
			long long x;
			x=n%10;
			if(x==9)
			p+=sum[m][x];
			else if(m>(9-x))
			p+=sum[m-9+x][9];
			else
			p+=1;
			p%=1000000007;
			n=n/10;
		}
		
		cout<<p<<endl;
		
	}
	//cout<<"5\n2\n6\n4\n2115";
}
	
	

