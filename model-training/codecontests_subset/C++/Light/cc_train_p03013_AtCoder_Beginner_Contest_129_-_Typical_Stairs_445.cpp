#include<bits/stdc++.h>
#define MOD 1000000007
#define int long long
using namespace std;
int n,m;
int a[100010];
int f[100010];
bool h[100010];
signed main(){
	cin>>n>>m;
	for(int i=1;i<=m;i++)cin>>a[i],h[a[i]]=1;
	f[0]=1;
	f[1]=(a[1]!=1);
	for(int i=1;i<=n;i++)if(!h[i]){
		f[i]=f[i-1]+f[i-2];
		f[i]%=MOD;
	}
	cout<<f[n]<<endl;
	return 0;
}
