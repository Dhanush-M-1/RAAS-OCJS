#include <bits/stdc++.h>
#pragma GCC optimize("Ofast, unroll-loops", "omit-frame-pointer", "inline")
#pragma GCC option("arch=native", "tune=native", "no-zero-upper")
#pragma GCC target( \
    "sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native,avx2")
using namespace std;
using ll = long long;
using ull = unsigned long long;
using ld = long double;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
int getrnd(int l, int r) { return uniform_int_distribution<int>(l, r)(rng); }
ll getrndll(ll l, ll r) { return uniform_int_distribution<ll>(l, r)(rng); }
template <typename T1, typename T2>
inline bool relax(T1& a, const T2& b) {
  if (a > b) {
    a = b;
    return 1;
  }
  return 0;
}
template <typename T1, typename T2>
inline bool strain(T1& a, const T2& b) {
  if (a < b) {
    a = b;
    return 1;
  }
  return 0;
}
void solve() {
  int n, k;
  cin >> n >> k;
  vector<pair<int, pair<int, int>>> a(n);
  for (int i = 0; i < n; ++i)
    cin >> a[i].second.first >> a[i].first, a[i].second.second = i;
  sort(a.begin(), a.end());
  vector<int> dp(k + 1, -1e9);
  vector<vector<int>> from(n, vector<int>(k + 1));
  dp[0] = 0;
  for (int i = 0; i < n; ++i) {
    vector<int> ndp(k + 1, -1e9);
    for (int j = 0; j <= min(i, k); ++j) {
      if (strain(ndp[j], dp[j] + (k - 1) * a[i].first)) from[i][j] = 0;
      if (j + 1 <= k &&
          strain(ndp[j + 1], dp[j] + a[i].second.first + a[i].first * j))
        from[i][j + 1] = 1;
    }
    dp.swap(ndp);
  }
  int cur = k;
  vector<int> have;
  for (int i = n - 1; i >= 0; --i) {
    if (from[i][cur]) {
      have.push_back(a[i].second.second);
      --cur;
    }
  }
  assert(cur == 0);
  reverse(have.begin(), have.end());
  vector<int> ans;
  for (int i = 0; i < k - 1; ++i) ans.push_back(have[i] + 1);
  for (int i = 0; i < n; ++i)
    if (count(have.begin(), have.end(), i) == 0)
      ans.push_back(i + 1), ans.push_back(-(i + 1));
  ans.push_back(have.back() + 1);
  cout << ans.size() << '\n';
  for (int x : ans) cout << x << ' ';
  cout << '\n';
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(nullptr);
  cout.tie(nullptr);
  srand(time(0));
  int t = 1;
  cin >> t;
  while (t--) solve();
  return 0;
}
