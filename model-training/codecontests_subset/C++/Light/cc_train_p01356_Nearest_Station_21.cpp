#include <cstdio>
#include <cstring>
#include <vector>
#include <queue>
#include <string>
#include <algorithm>
#include <iostream>
#include <string>
#include <map>
#include <set>
#include <functional>
#include <iostream>
#define MOD 1000000007LL
using namespace std;
typedef long long ll;
typedef pair<int,int> P;

ll labs(ll x){
	if(x<0LL)return -x;
	return x;
}

int zcnt(ll x){
	int cnt=0;
	while(x>0){
		x/=10LL;
		cnt++;
	}
	return cnt;
}

ll n,m,a,b,p,q;
ll num[51];
vector<ll> vec;

int main(void){
	scanf("%lld%lld%lld%lld%lld%lld",&n,&m,&a,&b,&p,&q);
	if(a==1LL && b==1LL){
		ll dist=p+q;
		ll cnt=m/dist;
		printf("%lld\n",min(labs(m-min(cnt,n)*dist),labs(m-(min(cnt+1LL,n))*dist)));
	}else{
		ll v=0;
		ll np=p,nq=q;
		while(np+nq<=m){
			num[v]=np+nq;
			if(zcnt(np)+zcnt(a)>=zcnt(m)+4 || zcnt(nq)+zcnt(b)>=zcnt(m)+4)break;
			np*=a;
			nq*=b;
			v++;
		}
		num[v]=np+nq;
		v++;
		ll res=m;
		v=min(v,n);
		if(v==0){
			res=min(res,labs(m-p-q));
			printf("%lld\n",res);
			return 0;
		}
		int v2=(int)v/2;
		for(int bit=0;bit<(1<<v2);bit++){
			ll now=0;
			for(int i=0;i<v2;i++){
				if((bit>>i) & 1){
					now+=num[i];
				}
			}
			vec.push_back(now);
		}
		sort(vec.begin(),vec.end());
		vec.erase(unique(vec.begin(),vec.end()),vec.end());
		int v3=v-v2;
		for(int bit=0;bit<(1<<v3);bit++){
			ll now=0;
			for(int i=0;i<v3;i++){
				if((bit>>i) & 1){
					now+=num[i+v2];
				}
			}
			int l=lower_bound(vec.begin(),vec.end(),m-now)-vec.begin();
			if(l<vec.size())res=min(res,labs(m-now-vec[l]));
			if(l>0 || l==vec.size()){
				res=min(res,labs(m-now-vec[l-1]));
			}
		}
		printf("%lld\n",res);
	}
	return 0;
}