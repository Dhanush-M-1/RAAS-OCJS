#include<bits/stdc++.h>
using namespace std;
using ll=long long;
using ld=long double;
using P=pair<ll,ll>;
#define MOD 1000000007ll
#define INF 1000000000ll
#define EPS 1e-10
#define FOR(i,n,m) for(ll i=n;i<(ll)m;i++)
#define REP(i,n) FOR(i,0,n)
#define DUMP(a) REP(d,a.size()){cout<<a[d];if(d!=a.size()-1)cout<<" ";else cout<<endl;}
#define ALL(v) v.begin(),v.end()
#define UNIQUE(v) sort(ALL(v));v.erase(unique(ALL(v)),v.end());
#define pb push_back

ll _pow(ll a, ll n) {
	if(n == 0) return 1;
	else {
		ll res = 1;
		ll buf = a;
		while(n > 0) {
			if(n % 2 == 1) {
				res *= buf;
			}
			buf *= buf;
			n /= 2;
		}
		return res;
	}
}

void solve() {
	ll tmp1, tmp2, tmp3, tmp4, tmp5, tmp6;
	cin >> tmp1 >> tmp2 >> tmp3 >> tmp4 >> tmp5 >> tmp6;
	__int128 n, m, a, b, p, q;
	n = tmp1;
	m = tmp2;
	a = tmp3;
	b = tmp4;
	p = tmp5;
	q = tmp6;
	__int128 ans = m;
	if(n == 1) {
		ans = min(m, (__int128)abs((ll)((p + q) - m)));
		cout << (ll)ans << endl;
		return;
	}
	__int128 c = max(a, b);
	if(c == 1) {
		if((p + q) * n > m) {
			ans = min(m - m / (p + q) * (p + q), (m / (p + q) + 1) * (p + q) - m);
		} else ans = m - (p + q) * n;
	} else if(c == 2 || c == 3) {
		__int128 _n = 0;
		if(c == 2) _n = min((__int128)41, n);
		if(c == 3) _n = min((__int128)29, n);
		ll div1 = _n / 2;
		ll div2 = _n - div1;
		vector<__int128> d1;
		vector<__int128> d2;
		REP(bit, (1ll << div1)) {
			bitset<31> bi(bit);
			__int128 sum = 0;
			REP(i, div1) if(bi[i]) sum += p * _pow(a, i) + q * _pow(b, i);
			d1.pb(sum);
		}
		REP(bit, (1ll << div2)) {
			bitset<31> bi(bit);
			__int128 sum = 0;
			REP(i, div2) if(bi[i]) sum += p * _pow(a, div1 + i) + q * _pow(b, div1 + i);
			d2.pb(sum);
		}
		sort(ALL(d1));
		sort(ALL(d2));
		REP(i, d1.size()) {
			auto ite = upper_bound(ALL(d2), m - d1[i]);
			if(ite != d2.end()) ans = min(ans, (d1[i] + *ite) - m);
			if(ite == d2.begin()) continue;
			ite--;
			ans = min(ans, m - (d1[i] + *ite));
		}
	} else /* c >= 4 */ {
		vector<__int128> num;
		num.pb(0);
		num.pb(p + q);
		REP(i, min((__int128)23, n - 1)) {
			if((__int128)1000000000007 / (ld)_pow(c, i) < c) break;
			ll val = p * _pow(a, i + 1) + q * _pow(b, i + 1); 
			vector<__int128> nnum = num;
			REP(j, num.size()) nnum.pb(num[j] + val);
			num = nnum;
		}
		UNIQUE(num);
		REP(i, num.size()) ans = min(ans, (__int128)abs((ll)(m - num[i])));
	}
	cout << (ll)ans << endl;
}

int main() {
	cin.tie(0);
	ios::sync_with_stdio(false);
	solve();
	return 0;
}

