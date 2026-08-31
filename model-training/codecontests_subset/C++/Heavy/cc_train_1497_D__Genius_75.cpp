#pragma GCC optimize("Ofast")
#include <bits/stdc++.h>
 
using namespace std;
 
using ll = long long;
using ii = pair<int,int>;
using vi = vector<int>;
using vii = vector<long long>;
 
template <typename T, size_t N>
using ar = array<T, N>;
 
#define INF (numeric_limits<int>::max())
#define INFLL (numeric_limits<ll>::max())
 
#define all(x) begin(x), end(x)
#define rall(x) rbegin(x), rend(x)
 
#define ff first
#define ss second
 
template <typename T>
void input_vec(vector<T>& a) {
    for (auto& x : a) cin >> x;
}

template <typename T>
void print_vec(vector<T>& a) {
    if (a.empty())return;
 
    cout << a[0];
 
    for (size_t i = 1; i < a.size(); i++) {
        cout << " " << a[i];
    }
    cout << endl;
}

ll gcd(ll a, ll b) {
    if (b == 0)return a;
    return gcd(b, a % b);
}

ll lcm(ll a, ll b) {
    return (a / gcd(a,b)) * b;
}
 
ll mod(ll a, ll m) {
    return (a % m + m) % m;
}
 
ll modpow(ll x, ll y, ll m) {
    if (y == 0) return 1;
    ll res = modpow(x, y / 2, m);
    res = mod(res * res, m);
    if (y & 1) return mod(x * res, m);
    else return res;
}
 
// Inverse of x mod p
ll invp(ll x, ll p) {
    return modpow(x, p - 2, p);
}


 
void setIO(string name = "") {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
 
    if ((name).size()) {
        freopen((name +  ".in").c_str(), "r", stdin);
        freopen((name + ".out").c_str(), "w", stdout);
    }
}
 
//-----------------------------------------------------------
 
const ll MOD = 1e9 + 7;
const ll BIG = INFLL / 2 - 5;
const int mxN = 2e5+3;
const int mxM = 5e6+4;


void solve() {
    ll n;
    cin >> n;


    vii tag(n), score(n);
    input_vec(tag);
    input_vec(score);

    if (n == 1) {
        cout << "0\n";
        return;
    }


    ll ans = 0;
    vii dp(n, 0);

    for (ll i = 0; i < n; ++i) {
        for (ll j = i - 1; j >= 0; --j) {
            if (tag[i] == tag[j])continue;
            ll tmp = dp[j];
            dp[j] = max(dp[j], dp[i] + abs(score[i] - score[j]));
            dp[i] = max(dp[i], tmp + abs(score[i] - score[j]));
            ans = max(ans, dp[i]);
            ans = max(ans, dp[j]);
        }
    }

    cout << ans << endl;
}

int main() {
    setIO();
    int t = 1;
    
    cin >> t;
    

    for (int i = 1; i <= t; i++) {
        solve();
    }
    return 0;
}
