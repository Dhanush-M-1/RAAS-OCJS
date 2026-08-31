#include <stdio.h>

typedef long long ll;

ll gcd(ll a,ll b) {
	return b?gcd(b,a%b):a;
}

inline bool solve(ll k,ll x,ll m,ll n) {
	if(x<k||k>n) return false;
	if(m>=k) return true;
	ll a=m-k,b=gcd(n,k),c=x%b;
	ll d=(a/b-1)*b+c;
	while(d<a) d+=b;
	return d>=0;
}

int main() {
	int T; scanf("%d",&T);
	while(T--) {
		ll a,b,c,d;
		scanf("%lld%lld%lld%lld",&a,&b,&c,&d);
		puts(solve(b,a,c+1,d)?"Yes":"No");
	}
	return 0;
}