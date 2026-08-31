/// vonat1us 

#pragma GCC optimize("O3")
//#pragma comment(linker, "/STACK:36777216")

#include<bits/stdc++.h>

#define x first
#define y second
#define pb push_back
#define sz(x) (int) x.size()
#define all(z) (z).begin(), (z).end()
 
using namespace std;

using ll = long long;
using pii = pair<int, int>;                                   

const int MOD = 1e9 + 7; 
const int INF = 1e9 + 1e2;
  
//mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());

void fin() {
#ifdef AM
    freopen(".in", "r", stdin);
#endif        
}                   

const bool flag = 1;       

const int N = 2e5+10;

ll n, p[N], t[N<<2];

void build(int u = 0, int l = 0, int r = n+1) {
    if (r-l == 1) {
        t[u] = p[l];
        return;
    }
    int m = l+r >> 1;
    build(u+u+1, l, m);
    build(u+u+2, m, r);
    t[u] = max(t[u+u+1], t[u+u+2]);
}   

int get(ll x, int u = 0, int l = 0, int r = n+1) {
    if (t[u] < x) {
        return -1;
    }
    if (r-l == 1) {
        return l;
    }
    int m = l+r >> 1;
    if (t[u+u+1] >= x) {
        return get(x, u+u+1, l, m);
    } else {
        return get(x, u+u+2, m, r);
    }
}

void ma1n() {
    int q;
    cin >> n >> q;
    for (int i = 0; i < n; ++i) {
        cin >> p[i+1], p[i+1] += p[i];
    }
    build();
    ll s = p[n];
    ll mx = *max_element(p, p+n+1);
    for (ll x; q--;) {
        cin >> x;
        ll ans = -1;
        if (s <= 0) {
            ans = get(x);
        } else {
            ll l = 0;
            ll r = 1e9;
            while (l <= r) {
                ll m = l+r >> 1ll;
                if (m > x/s) {
                    ans = m*n, r = m-1;
                    continue;    
                }
                int pos = get(x-m*s);
                if (~pos) {
                    ans = m*n + pos, r = m-1;
                } else {
                    l = m+1;
                }  
            }
        }
        cout << (~ans ? ans-1 : -1) << " ";
    }
    cout << "\n";
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(nullptr), fin();
    int ts = 1;

    if (flag) {
        cin >> ts;
    }
    while (ts--) {
        ma1n(); 
    }
    return 0;
}

