#include <bits/stdc++.h>
// #include <ext/pb_ds/assoc_container.hpp> //gp_hash_table

#define all(a) a.begin(), a.end()
#define pb push_back
#define eb emplace_back
#define sz(a) (int) a.size()
#define bitcount(a) (int) __builtin_popcount(a)
#define bitcountll(a) (int) __builtin_popcountll(a)
#define rep(i, from, to) for (int i = from; i < (to); ++i)

using namespace std;
// using namespace __gnu_pbds;
// template<class T> using Tree = tree<T, null_type, less<T>, rb_tree_tag, tree_order_statistics_node_update>;

typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
typedef pair<double, double> pdd;
typedef vector<int> vi;

mt19937 rng(696969420);
const int N = (int) 1e5 + 10;

void solve(int tc) {
    ll n;
    cin >> n;
    vector<ll> tag(n);
    vector<ll> score(n);
    for(ll& x : tag) cin >> x;
    for(ll& x : score) cin >> x;
    vector<ll> dp(n);
    for(int i = 0; i < n; ++i) {
        for(int j = i - 1; j >= 0; --j) {
            if(tag[i] == tag[j]) continue;
            ll s = abs(score[i] - score[j]);
            ll x = dp[i] + s, y = dp[j] + s;
            dp[i] = max(dp[i], y);
            dp[j] = max(dp[j], x);
        }
    }
    cout << *max_element(all(dp)) << endl;
}

int main() {
    // freopen("input.in", "r", stdin);
    // freopen("input.out", "w", stdout);
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.precision(20);
    cout << fixed;
    int t; cin >> t; for(int i = 1; i <= t; ++i) solve(i);
    cout.flush();
    return 0;
}