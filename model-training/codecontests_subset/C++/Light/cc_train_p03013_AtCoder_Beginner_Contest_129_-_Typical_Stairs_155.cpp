#include <bits/stdc++.h>
using namespace std;
long long mod=1000000007;
int main(){
	int n,m;
	cin>>n>>m;
	int a[m+1];
	int d[n+1];
	memset(d,-1,sizeof(d));
	d[0]=d[1]=1;
	for(int i=1;i<=m;i++){
		cin>>a[i];
		d[a[i]]=0;
	}
	for(int i=2;i<=n;i++){
		if(d[i]!=0){
			d[i]=(d[i-1]+d[i-2])%mod;
		}
	}
	cout<<d[n]<<endl;
	return 0;
} 