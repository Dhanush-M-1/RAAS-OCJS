#include <cstdio>
#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <algorithm>

using ll = long long int;
const int INF = (1<<30);
const ll INFLL = (1ll<<60);
const ll MOD = (ll)(1e9+7);

#define l_ength size

void mul_mod(ll& a, ll b){
	a *= b;
	a %= MOD;
}

void add_mod(ll& a, ll b){
	a = (a<MOD)?a:(a-MOD);
	b = (b<MOD)?b:(b-MOD);
	a += b;
	a = (a<MOD)?a:(a-MOD);
}

ll v[100100];

int main(void){
	int n,q,i,j=1;
	ll ans,l,r,s=0ll,a,x,t,tmpl,tmpr,d;
	std::cin >> x; l = 0ll; r = x;
	std::cin >> n; ++n;
	for(i=1; i<n; ++i){
		std::cin >> v[i];
	}
	v[n] = INFLL;
	std::cin >> q;
	for(i=0; i<q; ++i){
		std::cin >> t >> a;
		while(!(t<v[j])){
			if(j%2){
				d = (v[j-1]-v[j]);
			}else{
				d = (v[j]-v[j-1]);
			}
			if(d>=x){
				l = x; r = x; s += d; l -= s; r -= s;
			}else if(d<=-x){
				l = 0ll; r = 0ll; s += d; l -= s; r -= s;
			}else{
				s += d;
				tmpl = std::max(d,0ll); tmpr = std::min(x+d,x),0ll;
				l = std::max(l,tmpl-s);  r = std::min(r,tmpr-s);
			}
			if(l>r){
				if(j%2){
					r = l;
				}else{
					l = r;
				}
			}
			// std::cout << l << " " << r << std::endl;
			++j;
		}
		a = std::min(std::max(a,l),r);
		if(j%2){
			ans = std::max(a+s-(t-v[j-1]),0ll);
		}else{
			ans = std::min(a+s+(t-v[j-1]),x);
		}
		std::cout << ans << std::endl;
	}
	return 0;
}
