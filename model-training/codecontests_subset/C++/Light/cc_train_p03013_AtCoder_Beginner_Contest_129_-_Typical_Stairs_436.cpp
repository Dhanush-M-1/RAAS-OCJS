#include<iostream>
using namespace std;
const int N=1e5+10,M=1e9+7;
int a[N],n,m;
long long b[N];
int main(){
	cin>>n>>m;
	for(int i=1;i<=m;i++){
		int x;
		cin>>x;
		a[x]=1;
	}
	b[0]=1;
	for(int i=1;i<=n;i++){
		if(!a[i-1])	b[i]=(b[i]+b[i-1])%M;
		if(i>=2&&!a[i-2]) b[i]=(b[i]+b[i-2])%M;
	}
	cout<<b[n];
	return 0;
}
