#include <bits/stdc++.h>

using namespace std;

#define FASTIO() ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL)
#define int long long
#define all(x) (x).begin(), (x).end()
#define M_PI  3.14159265358979323846
#define M 1000000007
#define M1 998244353
typedef long long ll;


#ifndef ONLINE_JUDGE
#define debug(x) cerr << #x <<" --> "; print(x); cerr << endl;
#else
#define debug(x)
#endif


long long mod(long long x) {
	return ((x % M + M) % M);
}
long long add(long long a, long long b) {
	return mod(mod(a) + mod(b));
}
long long mul(long long a, long long b) {
	return mod(mod(a) * mod(b));
}

template <class T> void print(T a) {cerr << a;}
template <class T, class V> void print(pair <T, V> p);
template <class T> void print(vector <T> v);
template <class T> void print(set <T> v);
template <class T, class V> void print(map <T, V> v);
template <class T> void print(multiset <T> v);
template <class T, class V> void print(pair <T, V> p) {cerr << "{"; print(p.first); cerr << ","; print(p.second); cerr << "}";}
template <class T> void print(vector <T> v) {cerr << "[ "; for (T i : v) {print(i); cerr << ",";} cerr << "]";}
template <class T> void print(set <T> v) {cerr << "[ "; for (T i : v) {print(i); cerr << ",";} cerr << "]";}
template <class T> void print(multiset <T> v) {cerr << "[ "; for (T i : v) {print(i); cerr << ",";} cerr << "]";}
template <class T, class V> void print(map <T, V> v) {cerr << "[ "; for (auto i : v) {print(i); cerr << ",";} cerr << "]";}

ll modPow(ll a, ll b) {
	if (b == 0)
		return 1LL;
	if (b == 1)
		return a % M;
	ll res = 1;
	while (b) {
		if (b % 2 == 1)
			res = mul(res, a);
		a = mul(a, a);
		b = b / 2;
	}
	return res;
}

const int N = 2e5 + 2;
int fact[N];

void precalc() {
	fact[0] = 1;
	for (int i = 1; i < N; i++) {
		fact[i] = mul(fact[i - 1], i);
	}
}

ll inv(ll x) {
	return modPow(x, M - 2);
}

ll divide(ll a, ll b) {
	return mul(a, inv(b));
}

ll nCr(ll n, ll r) {
	return divide(fact[n], mul(fact[r], fact[n - r]));
}


void solve() {


	int k , n , m;
	cin >> k >> n >> m ;

	vector<int> a(n) , b(m);

	for (int i = 0 ; i < n ; i++) cin >> a[i];
	for (int i = 0 ; i < m ; i ++) cin >> b[i];

	// sort(all(a));
	// sort(all(b));

	debug(a);
	debug(b);

	int i = 0 , j = 0;
	vector<int> res;
	while (i < n and j < m) {
		if (a[i] < b[j]) {
			if (a[i] == 0) k++ , res.push_back(a[i]), i++;
			else {
				if (k >= a[i]) res.push_back(a[i]) , i++;
				else {
					cout << -1 << endl;
					return;
				}
			}
		} else {
			if (b[j] == 0)k++, res.push_back(b[j]), j++;
			else {
				if (k >= b[j]) res.push_back(b[j]) , j++;
				else {
					cout << -1 << endl;
					return;
				}
			}
		}
	}
	while (i < n) {
		if (a[i] == 0) k++ , res.push_back(a[i]), i++;
		else {
			if (k >= a[i]) res.push_back(a[i]) , i++;
			else {
				cout << -1 << endl;
				return;
			}
		}
	}
	while (j < m) {
		if (b[j] == 0)k++, res.push_back(b[j]), j++;
		else {
			if (k >= b[j]) res.push_back(b[j]) , j++;
			else {
				cout << -1 << endl;
				return;
			}
		}
	}

	for (int i = 0  ; i < res.size(); i++) cout << res[i] << " ";
	cout << endl;

}



int32_t main() {
	FASTIO();
#ifndef ONLINE_JUDGE
	freopen("E:/Competitive Programming/input.txt", "r", stdin);
	freopen("E:/Competitive Programming/output.txt", "w", stdout);
	freopen("E:/Competitive Programming/error.txt", "w", stderr);
#endif
	int t = 1;
	cin >> t;
	while (t--) {
		solve();
	}


	return 0;
}