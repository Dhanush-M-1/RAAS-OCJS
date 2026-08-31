#pragma GCC optimize("Ofast")
#pragma loop_opt(on)

#include<bits/stdc++.h>

#define Rushia_mywife ios::sync_with_stdio(0);cin.tie(0);
#define F first
#define S second
#define pb push_back
#define pob pop_back
#define pf push_front
#define pof pop_front
#define mp make_pair
#define mt make_tuple
#define FL cout.flush()
#define all(x) (x).begin(),(x).end()
#define mem(x,i) memset((x),(i),sizeof((x)))

using namespace std;
using ll = long long;
using pii = pair<int,int>;
using pll = pair<long long,long long>;
using ld = long double;

mt19937 mtrd(chrono::steady_clock::now().time_since_epoch().count());

const int mod = 1000000007;
const int mod2 = 998244353;
const ld PI = acos(-1);

#define Bint __int128
#define int long long
int qpow(int x,int powcnt,int tomod){
	int res = 1;
	for(;powcnt;powcnt>>=1,x=(x*x)%tomod)
		if(1&powcnt)res = (res*x)%tomod;
	return (res%tomod);
}
int inv(int x){ return qpow(x,mod-2,mod); }
// --------------------------------------**

int n,m;

void solve(){
	cin >> n >> m;
	int sum = 0;
	vector<int>a(n);
	for(int i=0;i<n;i++)
		cin >> a[i];
	vector<int>mx(n);
	sum = mx[0] = a[0];
	for(int i=1;i<n;i++)
		sum += a[i],mx[i] = max(sum,mx[i-1]);
	while(m--){
		int x;
		cin >> x;
		if(mx[n-1]<x&&sum<=0){
			cout << -1 << ' ';
			continue;
		}
		int cir;
		if(x<=mx[n-1])
			cir = 0;
		else
			cir = (x-mx[n-1]+sum-1)/sum;
		x -= cir*sum;
		int ans = cir*n;
		assert(x<=mx[n-1]);
		int l = 0,r = n-1;
		while(l<r){
			int mid = (l+r)>>1;
			if(mx[mid]>=x)
				r = mid;
			else
				l = mid+1;
		}
		cout << ans+l << ' ';
	}
	cout << '\n';
}

signed main(){
    Rushia_mywife
    int t = 1; 
    cin >> t;
    while(t--)
        solve();
}

