#include<bits/stdc++.h>
using namespace std;
bool b[100005];
int f[100005];
int main(){
	int m,n;
	cin>>m>>n;
	for(int i=1,k;i<=n;i++)
	 {cin>>k;
	  b[k]=1;
	 }
	if(!b[1])f[1]=1;
	if(!b[2])f[2]=f[1]+1;
	for(int i=3;i<=m;i++)
	 {if(b[i])continue;
	  f[i]=(f[i-1]+f[i-2])%1000000007;
	 }
	cout<<f[m]<<endl;
}