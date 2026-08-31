#include <bits/stdc++.h>
using namespace std;
 
#define send {ios_base::sync_with_stdio(false);}
#define help {cin.tie(NULL);}
#define f first
#define s second
#define pb push_back
#define vi vector<long long>
#define vii vector<pair<long long,long long>>
#define dict unordered_map<long long, long long>
#define contains(d,x) (d.find(x)!=d.end())

typedef long long ll;
typedef long double lld;
typedef unsigned long long ull;

const lld pi = 3.14159265358979323846;
const ll mod = 1000000007;
// const ll mod = 998244353;
 
ll n, m, k, l, p, q, r, x, y, z, sz;
const ll template_array_size = 1e6 + 5;
ll a[template_array_size];
ll b[template_array_size];
ll c[template_array_size];
string s, t;
ll ans = 0;
ll ts[5000000];

ll power(int x, int y){
	if(!y) return 1;
	ll temp = power(x, y/2);
	temp = (temp*temp)%mod;
	if(y&1){
		return (temp*x)%mod;
	}
	return temp;
}

int find(int i, ll rep[]) {
	int t = i;
	while(rep[i]!=i){
		i = rep[i];
	}
	while(rep[t]!=t){
		t = rep[t];
		rep[t] = i;
	}
	return i;
}

int onion(int i, int j, ll rep[]){
	i = find(i,rep);
	j = find(j,rep);
	rep[j] = i;
	return i!=j;
}

void solve(int tc = 0) {
	cin >> n >> m;
	vector<vii> adj(m+1);
	vi chosen;
	for(int i=0; i<m+1; i++) a[i] = i;
	for(int i=0; i<n; i++) {
		cin >> x;
		if (x==1) {
			cin >> y;
			x = 0;
		} else {
			cin >> x >> y;
		}
		if(onion(x,y,a)){
			chosen.pb(i+1);
		}
	}
	p = chosen.size();
	ans = power(2,p);
	cout << ans << " " << p << endl;
	for(int i : chosen) cout << i <<" ";
	cout << endl;
}
 
int main() {
	
    send help

	// int tc = 1;
	// cin >> tc;
	// for (int t = 0; t < tc; t++) solve(t);
	solve();
} 