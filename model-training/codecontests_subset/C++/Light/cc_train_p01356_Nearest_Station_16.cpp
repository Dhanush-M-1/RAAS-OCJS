#include <iostream>
#include <cmath>
#include <vector>
#include <algorithm>

#define rep(i,n) for(int i = 0; i < n; ++i)
using namespace std;

using ll = long long;
using R = long double;

int main(void){
	ll n,m,a,b,p,q;
	cin >> n >> m >> a >> b >> p >> q;

	if(a == 1 and b == 1){
		ll ticket = p + q;
		const ll used = min(n,m/ticket);
		ll ans = abs(m - ticket * used);
		if(used+1<=n) ans = min(ans,abs(m - ticket * (used+1)));
		cout << ans << endl;
		return 0;
	}

	vector<ll> ticket;
	n = min(n,40LL);

	rep(i,n){
		ll cur = p * pow<ll>(a,i) + q * pow<ll>(b,i);
		if(1.0 * p * pow<R>(a,i) + 1.0 * q * pow<R>(b,i) > 1e18) break;
		ticket.push_back(cur);
		if(cur > m) break;
	}

	n = ticket.size();

	vector<ll> item[2];
	const ll half[2] = {n/2,n-n/2};
	const ll offset[2] = {0,n/2};

	rep(k,2)rep(mask,1 << half[k]){
		ll cur = 0LL;
		rep(i,half[k]) if(mask & (1 << i)) cur += ticket[i+offset[k]];
		item[k].push_back(cur);
	}

	
	ll ans = m;
	sort(begin(item[1]),end(item[1]));
	
	for(auto &it:item[0]){
		const ll arg = m - it;
		auto it2 = upper_bound(begin(item[1]),end(item[1]),arg);

		if(it2 != end(item[1])) ans = min(ans, abs(m - it - *it2));
		it2--;
		ans = min(ans, m - it - *it2);
	}

	cout << ans << endl;
	return 0;
}