#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int MN = 101000;
ll r[MN];
ll v[MN],w[MN],u[MN];
ll vt[MN],vb[MN],sn[MN];
int main() {
	ll x,k,q;
	scanf("%lld %lld ",&x,&k);
	r[0] = 0;
	for(int i=0;i<k;i++) {
		scanf("%lld ",&r[i+1]);
	}
	k++;
	sn[0] = -1;
	vt[0] = 0;vb[0] = 0;
	v[0] = x;w[0] = 0;u[0] = 0;
	for(int i=1;i<k;i++) {
		u[i] = u[i-1]+sn[i-1]*(r[i]-r[i-1]);
		v[i] = v[i-1]+sn[i-1]*(r[i]-r[i-1]);
		w[i] = w[i-1]+sn[i-1]*(r[i]-r[i-1]);
		vt[i] = vt[i-1];vb[i] = vb[i-1];
		if(v[i] > x) {
			vt[i] += v[i]-x;
			v[i] = x;
		}
		if(w[i] > x) {w[i] = x;}
		if(w[i] < 0) {
			vb[i] -= w[i];
			w[i] = 0;
		}
		if(v[i] < 0) {v[i] = 0;}
		sn[i] = sn[i-1]*-1;
	}
	scanf("%lld ",&q);
	while(q--) {
		ll t,a;
		scanf("%lld %lld ",&t,&a);
		int id = upper_bound(r,r+k,t)-r-1;
		//printf("%lld -> %lld, id %ld\n",w[id],v[id],id);
		if(a <= vb[id]) {
			a = w[id];
		} else if(a >= x-vt[id]) {
			a = v[id];
		} else {
			a += u[id];
		}
		a += sn[id]*(t-r[id]);
		a = max(a,0LL);
		a = min(a,x);
		printf("%lld\n",a);
	}
}
