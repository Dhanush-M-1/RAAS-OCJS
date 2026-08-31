#include <bits/stdc++.h>
using namespace std;
using ll = long long;
const ll LINF = 1001002003004005006ll;
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};
ll gcd(ll a, ll b) { return b ? gcd(b, a % b) : a; }
template <class T>
bool chmax(T &a, const T &b) {
  if (a < b) {
    a = b;
    return 1;
  }
  return 0;
}
template <class T>
bool chmin(T &a, const T &b) {
  if (b < a) {
    a = b;
    return 1;
  }
  return 0;
}
signed main() {
  cin.tie(0);
  ios::sync_with_stdio(0);
  int n;
  cin >> n;
  vector<ll> DP(10, -1);
  DP[0] = 0;
  for (int _ = 0; _ < n; _++) {
    int k;
    cin >> k;
    vector<ll> ones;
    ll d2 = -1, d3 = -1;
    for (int i = 0; i < k; i++) {
      ll c, d;
      cin >> c >> d;
      if (c == 1)
        ones.push_back(d);
      else if (c == 2)
        chmax(d2, d);
      else
        chmax(d3, d);
    }
    sort(ones.begin(), ones.end());
    reverse(ones.begin(), ones.end());
    vector<ll> v2, v3;
    ll dp[4] = {};
    for (int i = 0; i < 3; i++) dp[i + 1] = -1;
    if (!ones.empty()) chmax(dp[1], ones[0]);
    if (ones.size() >= 2)
      if (chmax(dp[2], ones[0] + ones[1])) {
        v2.clear();
        v2.push_back(ones[0]);
        v2.push_back(ones[1]);
      }
    if (ones.size() >= 3)
      if (chmax(dp[3], ones[0] + ones[1] + ones[2])) {
        v3.clear();
        for (int i = 0; i < 3; i++) v3.push_back(ones[i]);
      }
    if (d2 >= 0) chmax(dp[1], d2);
    if (d2 >= 0 and (!ones.empty()))
      if (chmax(dp[2], d2 + ones[0])) {
        v2.clear();
        v2.push_back(ones[0]);
        v2.push_back(d2);
      }
    if (d3 >= 0) chmax(dp[1], d3);
    vector<ll> new_DP(10);
    for (int i = 0; i < 10; i++) {
      new_DP[i] = DP[i];
    }
    if (dp[1] >= 0) {
      for (int i = 0; i < 10; i++)
        if (DP[i] >= 0) {
          ll point = dp[1];
          if (i == 9) point *= 2;
          chmax(new_DP[(i + 1) % 10], DP[i] + point);
        }
    }
    if (dp[2] >= 0) {
      sort(v2.begin(), v2.end());
      reverse(v2.begin(), v2.end());
      for (int i = 0; i < 10; i++)
        if (DP[i] >= 0) {
          ll point = dp[2];
          if (i == 9 or i == 8) point += v2[0];
          chmax(new_DP[(i + 2) % 10], DP[i] + point);
        }
    }
    if (dp[3] >= 0) {
      sort(v3.begin(), v3.end());
      reverse(v3.begin(), v3.end());
      for (int i = 0; i < 10; i++)
        if (DP[i] >= 0) {
          ll point = dp[3];
          if (i == 9 or i == 8 or i == 7) point += v3[0];
          chmax(new_DP[(i + 3) % 10], DP[i] + point);
        }
    }
    swap(DP, new_DP);
  }
  ll ans = 0;
  for (int i = 0; i < 10; i++) chmax(ans, DP[i]);
  cout << ans << endl;
  return 0;
}
