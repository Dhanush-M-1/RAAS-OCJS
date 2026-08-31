#include<bits/stdc++.h>
#define ll long long 
using namespace std;
const int N=200010;
int n,a[N],d;
ll ans=0;
int main(){
	scanf("%d%d",&n,&d);
	ans=1ll*(n-1)*d;
	for(int i=1;i<=n;++i)scanf("%d",&a[i]),ans+=a[i];
	for(int i=2;i<=n;++i)a[i]=min(a[i-1]+d,a[i]);
	for(int i=n-1;i;--i)a[i]=min(a[i+1]+d,a[i]);
	for(int i=2;i<n;++i)ans+=a[i];
	cout<<ans<<endl;
	return 0;
}
