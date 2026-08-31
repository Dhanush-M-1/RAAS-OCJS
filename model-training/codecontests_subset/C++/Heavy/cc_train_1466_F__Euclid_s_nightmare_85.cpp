#include <bits/stdc++.h>
using namespace std;

typedef long long int ll;
#define int ll
#define fast(); ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0);
#define tests() int t; cin>>t; while(t--)
#define endl '\n'
#define F first
#define S second
#define mp make_pair
#define vi vector <ll>
#define pii pair<ll, ll>
#define pdi pair<double, ll>
#define pb(x) push_back(x)
#define pf(x) push_front(x)
#define all(x) x.begin(),x.end()
#define f(i,n) for(ll i=0;i<n;i++)

#define shout()  {cout << "I'm Here...!!!" << endl;}
#define dbg(x) { cout<< #x << ": " << (x) << endl; }
#define dbg2(x,y) { cout<< #x << ": " << (x) << " , " << #y << ": " << (y) << endl; }
#define dbgv(x) { cout<< #x << ": "; for(auto i : x) cout << i << ' '; cout << '\n'; }

int gcd(int a, int b) { if (a == 0) return b; return gcd(b % a, a); }
int fpow(int a, int b) { if (b == 0)return 1; int t = (fpow(a, b / 2)); if (b % 2 == 0)return (t * t); else return ((a) * (t * t)); }

int inf = 1e15 + 100;
int mod = 1e9 + 7;
double pi = 3.1415926;

vi parent;

void make_set(int n) {
	f(i, n) parent[i] = i;
}

int find_set(int v) {
	if (v == parent[v])
		return v;
	return parent[v] = find_set(parent[v]);
}

void union_sets(int a, int b) {
	a = find_set(a);
	b = find_set(b);
	if (a != b)
		parent[b] = a;
}

signed main()
{
	int n, m;
	cin >> n >> m;
	parent.resize(m + 2);
	int res = 1;
	vi ans;
	make_set(m + 1);
	f(i, n) {
		int c;
		cin >> c;
		if (c == 1) {
			int x;
			cin >> x;
			if (find_set(x) != find_set(m + 1)) {
				union_sets(m + 1, x);
				res = (res * 2) % mod;
				ans.push_back(i + 1);
			}
		}
		else {
			int x, y;
			cin >> x >> y;
			if (find_set(x) != find_set(y)) {
				union_sets(y, x);
				res = (res * 2) % mod;
				ans.push_back(i + 1);
			}
		}
	}
	cout << res << ' ' << ans.size() << endl;
	for (int i : ans) cout << i << ' ';
	cout << endl;
}