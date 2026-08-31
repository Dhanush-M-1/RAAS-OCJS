#include <iostream>
#include <cstdio>
#include <vector>
#include <queue>
#include <cmath>
#include <algorithm>
#include <functional>
using namespace std;
#define rep(i,n) for(int i=0;i<(n);++i)
#define rep1(i,n) for(int i=1;i<=(n);++i)
#define all(c) (c).begin(),(c).end()
#define pb push_back
#define fs first
#define sc second
#define show(x) cout << #x << " = " << x << endl
typedef long long ll;
ll inf=1e14;
int main(){
	ll n,m,a,b,p,q;
	cin>>n>>m>>a>>b>>p>>q;
	if(a>b) swap(a,b),swap(p,q);
	ll ans=m;
	if(b==1){
		ll k=p+q;
		ll d=min(n,m/k);
		ans=m-k*d;
		if(d!=n) ans=min(ans,(d+1)*k-m);
	}else if(a==1){
		ll bq[45]={},sum[46]={};
		bq[0]=q;
		sum[1]=q;
		ll id=0;
		for(;id<n-1;id++){
			if(bq[id]>inf/b) break;
			bq[id+1]=bq[id]*b;
			sum[id+2]=sum[id+1]+bq[id+1];
		}
/*		show(id);
		rep(i,id+1){
			show(bq[i]);
			show(sum[i]);
		}*/
		//can use 0~id
		ll id_c=id;
		for(ll k=1;k<=min(n,id_c+1);k++){
			if(bq[k-1]==0) break;
//			show(k);
			ll left=m-p*k;
			ll now=0;
			id=id_c;
			int use=0;
			for(;id>=0;id--){
				if(now+bq[id]>left){
					if(k-use-1>=0&&k-use-1<=id) ans=min(ans,now+bq[id]+sum[k-use-1]-left);
				}else{
					now+=bq[id];
					use++;
					if(use==k){
						ans=min(ans,left-now);
						break;
					}
				}
			}
		}
	}else{
		ll id=0;
		ll l=p,r=q;
		ll num[45]={};
		for(;id<n;id++){
			num[id]=l+r;
			if(l>inf/a) break;
			if(r>inf/b) break;
			l*=a;
			r*=b;
		}
		if(id==n) id--;
		//can use 0~id
//		show(id);
//		rep(i,id+1){
//			show(num[i]);
//		}
		ll now=0;
		for(;id>=0;id--){
			if(now+num[id]>m){
				ans=min(ans,now+num[id]-m);
			}else{
				ans=min(ans,m-(now+num[id]));
				now+=num[id];
			}
		}
	}
	cout<<ans<<endl;
}