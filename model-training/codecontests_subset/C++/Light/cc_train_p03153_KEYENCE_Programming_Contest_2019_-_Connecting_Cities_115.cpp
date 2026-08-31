#include<bits/stdc++.h>
using namespace std;
const int N = 200003;
long long d,f[N],g[N],a[N],ans=0;
int n;
int main(){
	scanf("%d%lld",&n,&d);
	for(int i=1;i<=n;i++) {
		scanf("%lld",&a[i]);
		ans+=a[i];
	}
	f[1]=a[1];g[n]=a[n];
	for(int i=2;i<=n;i++) f[i]=min(f[i-1]+d,a[i]);
	for(int i=n-1;i>=1;i--) g[i]=min(g[i+1]+d,a[i]);
	for(int i=2;i<n;i++) ans+=min(f[i],g[i]);
	printf("%lld",ans+(n-1)*d);
}