#include<iostream>
#include<string>
#include<cstdio>
#include<vector>
#include<cmath>
#include<algorithm>
#include<functional>
#include<iomanip>
#include<queue>
#include<ciso646>
#include<random>
#include<map>
#include<set>
#include<complex>
#include<bitset>
#include<stack>
#include<unordered_map>
#include<utility>
using namespace std;
typedef long long ll;
typedef unsigned long long ul;
typedef unsigned int ui;
const ll mod = 1000000007;
typedef long double ld;
const ll INF = mod*mod;
typedef pair<int, int> P;
#define stop char nyaa;cin>>nyaa;
#define rep(i,n) for(int i=0;i<n;i++)
#define per(i,n) for(int i=n-1;i>=0;i--)
#define Rep(i,sta,n) for(int i=sta;i<n;i++)
#define rep1(i,n) for(int i=1;i<=n;i++)
#define per1(i,n) for(int i=n;i>=1;i--)
#define Rep1(i,sta,n) for(int i=sta;i<=n;i++)
const ld eps = 1e-8;
const ld pi = acos(-1.0);
typedef pair<ld, ld> LDP;
typedef pair<ll, ll> LP;
#define fr first
#define sc second

//t個が1,x以下とx以上を求める
LP calc(ll x, int t,int sup=40) {
	vector<int> v;
	rep(i, sup) {
		ll k = (ll)1 << i;
		if (x&k)v.push_back(i);
	}
	int len = v.size();
	ll le = 0;
	if (t <= len) {
		for (int i = len - 1; i >= len - t; i--) {
			le += (ll)1 << v[i];
		}
	}
	else {
		bool f = false;
		rep(i, len) {
			int cnt = v[i];
			cnt += len - 1 - i;
			if (cnt >= t) {
				for (int j = len - 1; j > i; j--) {
					le += (ll)1<<v[j];
				}
				int r = t - (len - 1 - i);
				rep(j, r) {
					le += (ll)1 << j;
				}
				f = true;
				break;
			}
		}
		if (!f)le = -INF;
	}
	ll ri = 0;
	if (t <= len) {
		int tmp = len;
		rep(i, sup) {
			ll k = (ll)1 << i;
			if (k&x) {
				tmp--; continue;
			}
			int cnt = i;
			cnt += tmp;
			cnt++;
			if (tmp + 1 <= t && cnt >= t) {
				ri += k;
				Rep(j, len-tmp, len) {
					ri += (ll)1 << v[j];
				}
				int r = t - (tmp + 1);
				rep(j, r) {
					ri += (ll)1 << j;
				}
				break;
			}
		}
	}
	else {
		rep(i, len) {
			ri += (ll)1 << v[i];
		}
		int r = t - len;
		rep(j, sup) {
			if (r == 0)break;
			ll k = (ll)1 << j;
			if ((x&k) == 0) {
				ri += k; r--;
			}
		}
	}
	return { le,ri };
}
string add(string a, string b) {
	reverse(a.begin(), a.end());
	reverse(b.begin(), b.end());
	int len = max(a.length(), b.length());
	int rest = 0; string res;
	rep(i, len + 1) {
		if (i < (int)a.length()) {
			rest += a[i] - '0';
		}
		if (i < (int)b.length()) {
			rest += b[i] - '0';
		}
		res.push_back('0' + (rest % 10));
		rest /= 10;
	}
	while (res.length() && res[res.length() - 1] == '0')res.erase(res.end() - 1);
	reverse(res.begin(), res.end());
	return res;
}
string multi0(int m, string a) {
	string res;
	reverse(a.begin(), a.end());
	int len = a.length();
	int rest = 0;
	rep(i, len) {
		rest += m * (a[i] - '0');
		res.push_back('0' + (rest % 10));
		rest /= 10;
	}
	if (rest)res.push_back('0' + rest);
	reverse(res.begin(), res.end());
	return res;
}
string multi(string a, string b) {
	int len = a.length(); string res = "0";
	per(i, len) {
		int t = a[i] - '0'; int rest = len - i - 1;
		string nex = multi0(t, b);
		rep(j, rest) {
			nex.push_back('0');
		}
		res = add(res, nex);
	}
	return res;
}
bool invalid(ll a,ll p) {
	string s = to_string(a); string t = to_string(p);
	string st = multi(s, t);
	if (st.size() >= 15)return true;
	else return false;
}
void solve() {
	ll n, m, a, b, p, q; cin >> n >> m >> a >> b >> p >> q;
	if (a > b) {
		swap(a, b); swap(p, q);
	}
	ll ans = INF;
	if (invalid(a, p) || invalid(b, q)) {
		ans = m;
		ans = min(ans, abs(m - p - q));
	}
	else if (invalid(a,a)||invalid(b,b)) {
		//cout << "hello" << endl;
		ans = min(ans, m);
		ans = min(ans, abs(m - p - q));
		if (n > 1) {
			ans = min(ans, abs(m - p * a - q * b));
			ans = min(ans, abs(m - p * a - q * b - p - q));
		}
	}
	else if (a == 1 && b == 1) {
		ll le = m / (p + q);
		if (n < le) {
			ll sum = (p + q)*n;
			ans = min(ans, m - sum);
		}
		else {
			ans = min(ans, m - (p + q)*le);
		}
		if (n >= le + 1) {
			ans = min(ans, (p + q)*(le + 1) - m);
		}
	}
	else if (a == 1 && b == 2) {
		ll x = a, y = b;
		rep(i, n) {
			ll sum = p * x + q * y;
			if (sum >= m) {
				ans = min(ans, sum - m); break;
			}
			x = x * a; y = y * b;
		}
		ll s = min(n, (ll)40);
		//i個使う
		rep1(i, s) {
			ll mm = m - i * p;
			ll d = mm / q;
			LP z = calc(d, i, s);
			if (z.first != -INF) {
				ans = min(ans, abs(mm - q * z.first));
			}
			ans = min(ans, abs(mm - q * z.second));
			//ll lesum = q * z.first, risum = q * z.second;
			//cout << lesum + i * p << " i " << risum + i * p << endl;
			//ans = min(ans, abs(mm - lesum));
			//ans = min(ans, abs(risum - mm));
		}
	}
	else if (a == 2 && b == 2) {
		ll d = m / (p + q);
		ll s = min(n, (ll)40);
		ll z = 0;
		rep(i, s) {
			z += (ll)1 << i;
		}
		if (z < m)ans = min(ans, m - z * (p + q));
		else {
			ll le = d;
			ans = min(ans, m - le * (p + q));
			le++;
			ll las = 0;
			rep(i, 40) {
				ll k = (ll)1 << i;
				if (k&le) {
					las = i;
				}
			}
			if (las < n) {
				ans = min(ans, m - le * (p + q));
			}
		}
	}
	else {
		ll x = 1, y = 1;
		vector<ll> v;
		rep(i, n) {
			ll sum = p * x + q * y;
			if (sum >= m) {
				ans = min(ans, sum - m);
				break;
			}
			v.push_back(sum);
			x = x * a; y = y * b;
		}
		int len = v.size();
		ll sum = 0;
		per(i, v.size()) {
			if (sum + v[i] <= m) {
				sum += v[i];
			}
			else {
				ans = min(ans, abs(m - sum-v[i]));
			}
		}
		ans = min(ans, abs(m - sum));
		/*cout << len << endl;
		rep(i, (1 << len)) {
			ll u = 0;
			rep(j, len) {
				if (i&(1 << j))u += v[j];
			}
			ans = min(ans, abs(m - u));
		}*/
	}
	cout << ans << endl;
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	solve();
	//stop
	return 0;
}
