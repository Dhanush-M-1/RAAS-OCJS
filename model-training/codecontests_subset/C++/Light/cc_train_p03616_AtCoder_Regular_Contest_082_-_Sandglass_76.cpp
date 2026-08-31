#include <bits/stdc++.h>
using namespace std;

template<typename T>
void out(T x) { cout << x << endl; exit(0); }
#define watch(x) cout << (#x) << " is " << (x) << endl





using ll = long long;

const ll mod = 1e9+7;
const int maxn = 1e6 + 5;



ll x, k, q;
ll r[maxn];
ll t[maxn], a[maxn];

int main() {
    ios_base::sync_with_stdio(false); cin.tie(0);  cout.tie(0);

    cin>>x;
    cin>>k;
    for (int i=0; i<k; i++) {
	cin>>r[i];
    }

    cin>>q;
    for (int i=0; i<q; i++) {
	cin>>t[i]>>a[i];
    }

    auto bound = [&](ll val, ll l, ll r) {
	val = min(val, r);
	val = max(l, val);
	return val;
    };


    int ri=0;
    ll sgn = -1;
    ll lo = 0;
    ll hi = x;
    ll dx = 0;
    ll last = 0;

    // The answer is bounded between [lo,hi]. Once they converge to lo=hi, the answer is pre-determined.
    // dx is added to the initial condition a[qi], but we still bound the answer by [lo,hi].
    
    for (int qi=0; qi<q; ) {
	if (ri==k || t[qi] < r[ri]) {
	    ll res = bound(dx+a[qi], lo, hi);
	    res += sgn*(t[qi]-last);
	    res = bound(res, 0, x);
	    cout<<res<<"\n";
	    qi++;
	    
	} else {
	    ll dr = sgn*(r[ri]-last);

	    lo = bound(lo+dr, 0, x);
	    hi = bound(hi+dr, 0, x);
	    dx += dr;

	    last = r[ri];
	    ri++;
	    sgn = -sgn;	    
	}
    }
    
    
    return 0;
}
