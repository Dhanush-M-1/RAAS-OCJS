#include <bits/stdc++.h>
using namespace std;
int n,m,a[123456],d[123456];
int main(){
	cin>>n>>m;
	for(int i=0;i<n+1;i++)d[i]=100000;
	for(int i=0;i<m;i++){
		cin>>a[i];
		d[a[i]]=0;
	}
	d[0]=1;
	if(a[0]!=1)d[1]=1;
	for(int i=2;i<=n;i++){
		if(d[i]==0);
		else{
			d[i]=d[(i-1)]+d[(i-2)];
			d[i]%=1000000007;
		}
	}
	cout<<d[n]<<endl;
}