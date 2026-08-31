#include <bits/stdc++.h>
 
using namespace std;
 
typedef long long ll;
typedef long double ld;
 
typedef vector<int> vi;
typedef vector<ll> vll;
 
typedef vector<vi> vvi;
typedef vector<vll> vvll;
 
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
 
typedef vector<pii> vpii;
typedef vector<pll> vpll;
 
typedef vector<vpii> vvpii;
typedef vector<vpll> vvpll;
 
#define pb push_back
#define mp make_pair
#define all(x) (x).begin(), (x).end()
#define rall(x) (x).rbegin(), (x).rend()
#define sz(x) (int)(x).size()
#define fi first
#define se second
 
template<class T> bool ckmin(T &a, const T &b) {return a > b ? a = b, 1 : 0;}
template<class T> bool ckmax(T &a, const T &b) {return a < b ? a = b, 1 : 0;}
 
void __print(int x) {cerr << x;}
void __print(long long x) {cerr << x;}
void __print(double x) {cerr << x;}
void __print(long double x) {cerr << x;}
void __print(char x) {cerr << '\'' << x << '\'';}
void __print(const string &x) {cerr << '\"' << x << '\"';}
void __print(bool x) {cerr << (x ? "true" : "false");}
 
template<typename T, typename V>
void __print(const pair<T, V> &x) {cerr << '{'; __print(x.first); cerr << ','; __print(x.second); cerr << '}';}
template<typename T>
void __print(const T &x) {int f = 0; cerr << '{'; for(auto z : x) cerr << (f++ ? "," : ""), __print(z); cerr << "}";}
void _print() {cerr << "]\n";}
template <typename T, typename... V>
void _print(T t, V... v) {__print(t); if(sizeof...(v)) cerr << ", "; _print(v...);}
 
#ifdef ljuba
#define dbg(x...) cerr << "LINE(" << __LINE__ << ") -> " << "[" << #x << "] = ["; _print(x)
#else
#define dbg(x...)
#endif
 
const char nl = '\n';

void solve() {
    int n, m;
    cin >> n >> m;
    vll v(n);
    for(auto &z : v)
        cin >> z;
    vi x(m);
    for(auto &z : x)
        cin >> z;

    ll pref = 0;
    ll maksi = 0;
    vll prefMax(n);
    for(int i = 0; i < n; ++i) {
        pref += v[i];
        ckmax(maksi, pref);
        prefMax[i] = maksi;
    }
    ll sve = pref;

    //dbg(prefMax);

    for(int i = 0; i < m; ++i) {
        if(sve <= 0) {
            if(x[i] > prefMax.back())
                cout << -1 << " ";
            else {
                cout << upper_bound(all(prefMax), x[i]-1) - prefMax.begin() << " ";
            }
        } else {
            ll krug = max(0LL, (x[i] - prefMax.back() + sve - 1) / sve);
            ll ans = krug * n;
            //dbg(krug);
            ans += upper_bound(all(prefMax), x[i] - krug*sve - 1) - prefMax.begin();
            cout << ans << " ";
        }
    }
    cout << nl;
}
 
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int testCases = 1;
    cin >> testCases;
    while(testCases--)
        solve();
 
}
