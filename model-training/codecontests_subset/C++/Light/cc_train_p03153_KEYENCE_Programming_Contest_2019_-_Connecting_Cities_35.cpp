#include <bits/stdc++.h>
#define int long long
#define P(x) {if (debug) cout << x << endl;}
#define H(x) P(#x << ": " << (x))
#define FR(i,a,b) for (int i=(a); i<(b); i++)
#define F(i,n) FR(i,0,n)
#define DR(i,a,b) for (int i=(b); i-->(a);)
#define D(i,n) DR(i,0,n)
#define S(s) (int)(s).size()
#define ALL(v) v.begin(), v.end()
#define MI(a,v) a = min(a,v)
#define MA(a,v) a = max(a,v)
#define V vector
#define pb push_back
#define mt make_tuple
using namespace std;
template<class T> ostream &operator<<(ostream &os, V<T> v) {
    F(i,S(v)) os<<(i?" ":"")<<v[i];
    return os;
}
const bool debug = 0;
const int INF = 1e18;

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int n,d; cin>>n>>d;
    V<int> a(n);
    F(i,n) {
        cin>>a[i];
    }
    V<int> prefMin(n+1), sufMin(n+1);
    prefMin[0] = INF;
    F(i,n) {
        prefMin[i+1] = min(a[i], prefMin[i]+d);
    }
    sufMin[n] = INF;
    D(i,n) {
        sufMin[i] = min(a[i], sufMin[i+1]+d);
    }
    int cost = max(n-1, 0LL)*d;
    H(cost)
    F(i,n) {
        cost += a[i];
    }
    H(cost)
    FR(i,1,n-1) {
        int here = min(prefMin[i+1], sufMin[i]);
        if (here < a[i]) {
            P(i)
            H(here)
            H(prefMin[i+1])
            H(sufMin[i])
        }
        assert(here <= a[i]);
        cost += here;
    }
    cout<<cost<<"\n";
}