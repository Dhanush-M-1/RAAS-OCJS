#include<iostream>
#include<string>
using namespace std;

int main(){
long long unsigned int n,m,i,j;
cin>>n>>m;
long long unsigned int broken[n+1],dp[n+1],modu=1000000007;
for(i=0;i<n+1;i++)broken[i]=false;
for(i=0;i<m;i++){cin>>j;broken[j]=true;}
dp[0]=1;
for(i=1;i<=n;i++)
{
	if(broken[i])dp[i]=0;
	else
	{
	if(i==1)
	dp[i]=(dp[i-1])%modu;
	else
	dp[i]=(dp[i-1]+dp[i-2])%modu;
	}
}
cout<<dp[n];
}