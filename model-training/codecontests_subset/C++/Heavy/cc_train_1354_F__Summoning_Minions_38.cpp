#include <bits/stdc++.h>
using namespace std;
using ll = long long;
#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
template <typename T>
ostream& operator<<(ostream& os, const vector<T>& v) {
  for (ll i = 0; i < v.size(); ++i) os << v[i] << " ";
  return os;
}
template <typename T>
ostream& operator<<(ostream& os, const set<T>& v) {
  for (auto it : v) os << it << " ";
  return os;
}
template <typename T, typename S>
ostream& operator<<(ostream& os, const pair<T, S>& v) {
  os << v.first << " " << v.second;
  return os;
}
const ll mod = 1e9 + 7;
const ll inf = 2e18;
const ll ninf = -2e18;
ll takemod(ll a) { return ((a % mod) + mod) % mod; }
ll pow(ll a, ll b, ll m) {
  ll ans = 1;
  a %= m;
  while (b) {
    if (b & 1) ans = (ans * a) % m;
    b /= 2;
    a = (a * a) % m;
  }
  return ans;
}
ll modinv(ll a) { return takemod(pow(takemod(a), mod - 2, mod)); }
const ll N = 100;
ll dp[N][N];
ll n, k;
struct minion {
  ll a, b, ind;
  minion(ll ad, ll bd, ll cd) {
    a = ad;
    b = bd;
    ind = cd;
  }
};
bool compa(minion m1, minion m2) { return m1.b < m2.b; }
void do_case() {
  cin >> n >> k;
  vector<minion> arr;
  arr.push_back(minion(0, 0, 0));
  for (ll i = 1; i <= n; i++) {
    ll a, b;
    cin >> a >> b;
    arr.push_back(minion(a, b, i));
  }
  sort(arr.begin() + 1, arr.end(), compa);
  memset(dp, -1, sizeof(dp));
  dp[0][0] = 0;
  for (ll i = 1; i <= n; i++) {
    for (ll j = 0; j <= k; j++) {
      if (j && dp[i - 1][j - 1] >= 0) {
        dp[i][j] =
            max(dp[i][j], dp[i - 1][j - 1] + arr[i].b * (j - 1) + arr[i].a);
      }
      if (dp[i - 1][j] >= 0)
        dp[i][j] = max(dp[i][j], dp[i - 1][j] + (k - 1) * arr[i].b);
    }
  }
  ll ans = dp[n][k];
  ll it = k;
  vector<ll> arr1;
  vector<ll> arr2;
  for (ll i = n; i >= 1; i--) {
    if (it && dp[i - 1][it - 1] >= 0) {
      if (dp[i][it] == dp[i - 1][it - 1] + arr[i].b * (it - 1) + arr[i].a) {
        it--;
        arr1.push_back(arr[i].ind);
        continue;
      }
    }
    if (dp[i - 1][it] >= 0 && dp[i][it] == dp[i - 1][it] + (k - 1) * arr[i].b)
      arr2.push_back(arr[i].ind);
  }
  reverse(arr1.begin(), arr1.end());
  cout << arr1.size() + 2 * arr2.size() << '\n';
  for (ll i = 0; i < (ll)(arr1.size() - 1); i++) cout << arr1[i] << " ";
  for (ll i = 0; i < (ll)arr2.size(); i++) {
    cout << arr2[i] << " " << -arr2[i] << " ";
  }
  cout << arr1.back() << '\n';
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  time_t t1, t2;
  t1 = clock();
  ll t;
  cin >> t;
  while (t--) do_case();
  t2 = clock();
  cerr << '\n' << t2 - t1 << '\n';
  return 0;
}
