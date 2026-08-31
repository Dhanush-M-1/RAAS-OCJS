#include <bits/stdc++.h>

using namespace std;

#define ar array
#define ll long long

const int MAX_N = 1e5 + 1;
const ll MOD = 1e9 + 7;
const ll INF = 1e9;

template<typename A, typename B> ostream& operator<<(ostream &os, const pair<A, B> &p) { return os << '(' << p.first << ", " << p.second << ')'; }
template<typename T_container, typename T = typename enable_if<!is_same<T_container, string>::value, typename T_container::value_type>::type> ostream& operator<<(ostream &os, const T_container &v) { os << '{'; string sep; for (const T &x : v) os << sep << x, sep = ", "; return os << '}'; }
void dbg_out() { cerr << endl; }
template<typename Head, typename... Tail> void dbg_out(Head H, Tail... T) { cerr << ' ' << H; dbg_out(T...); }
#ifdef LOCAL
#define dbg(...) cerr << "(" << #__VA_ARGS__ << "):", dbg_out(__VA_ARGS__)
#else
#define dbg(...)
#endif

void solve() {
    int n; cin >> n;
    vector<int> tag(n), s(n);
    for (int &x : tag) cin >> x;
    for (int &x : s) cin >> x;
    vector<ll> dp(n);
    // for (int i = 0; i < n; i++) dp[i] = s[i];
    for (int i = 1; i < n; i++) {
        for (int j = i - 1; j >= 0; j--) {
            if (tag[i] == tag[j]) continue;
            ll ndpi = dp[j] + abs(s[i] - s[j]);
            ll ndpj = dp[i] + abs(s[i] - s[j]);
            dp[i] = max(dp[i], ndpi);
            dp[j] = max(dp[j], ndpj);
            dbg(i, j, dp);
        }
    }
    cout << *max_element(dp.begin(), dp.end()) << "\n";    
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    int tc = 1;
    cin >> tc;
    for (int t = 1; t <= tc; t++) {
        // cout << "Case #" << t << ": ";
        solve();
    }
}