#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const int maxn=2e5+50;
ll n,m,T,a[maxn],sum[maxn],maxx[maxn],ans[maxn];
int main(){
	cin>>T;
	while(T--){
		cin>>n>>m;
	
		for(int i=1;i<=n;i++)cin>>a[i],sum[i]=sum[i-1]+a[i],maxx[i]=max(maxx[i-1],sum[i]);
		for(int i=1;i<=m;i++){
			ll x;cin>>x;
			if(x<=maxx[n]){
				cout<<lower_bound(maxx+1,maxx+1+n,x)-maxx-1<<' ';
			}
			else{
				if(sum[n]<=0){
					cout<<-1<<' ';
				}
				else{
					ll d=x-maxx[n];
					ll tot=ceil(d*1.0/sum[n]);
					x-=tot*sum[n];
					ll t=lower_bound(maxx+1,maxx+1+n,x)-maxx;
					t=t+tot*n-1;
					cout<<t<<' ';
				}
			}
		}
		cout<<endl;
	}
	return 0;
}
