#include <bits/stdc++.h>
using namespace std;
using ll = long long;
const ll mod = 1000000007;
const ll INF = 1001001001001001001;
const int MAX = 1e5 + 5;
template <class T>
inline bool chmax(T& a, T b) {
  if (a < b) {
    a = b;
    return true;
  }
  return false;
}
ll dp[10][200005];
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < 10; i++) {
    for (int j = 0; j < 200005; j++) {
      dp[i][j] = -INF;
    }
  }
  for (int i = 1; i <= n; i++) {
    int k;
    cin >> k;
    vector<ll> c1(3, 0);
    ll c2 = 0, c3 = 0;
    for (int j = 0; j < k; j++) {
      ll a, b;
      cin >> a >> b;
      if (a == 1) c1.push_back(b);
      if (a == 2) c2 = max(c2, b);
      if (a == 3) c3 = max(c3, b);
    }
    sort(c1.begin(), c1.end(), greater<ll>());
    vector<vector<ll>> m(4, vector<ll>(2, 0));
    m[1][0] = max(c2, max(c3, c1[0]));
    m[1][1] = 2 * m[1][0];
    m[2][0] = max(c2 + c1[0], c1[0] + c1[1]);
    if (m[2][0] == c2 || m[2][0] == c1[0]) m[2][0] = 0;
    m[2][1] = max(c2 + 2 * c1[0], max(2 * c2 + c1[0], 2 * c1[0] + c1[1]));
    m[3][0] = c1[0] + c1[1] + c1[2];
    if (c1[0] == 0 || c1[1] == 0 || c1[2] == 0) m[3][0] = 0;
    m[3][1] = 2 * c1[0] + c1[2] + c1[1];
    dp[0][0] = 0;
    for (int j = 0; j < 10; j++) {
      for (int k = 0; k <= 3; k++) {
        if (j + k < 10) {
          if (k == 0 || m[k][0] != 0)
            chmax(dp[j + k][i], dp[j][i - 1] + m[k][0]);
        } else {
          if (m[k][0] != 0) chmax(dp[(j + k) % 10][i], dp[j][i - 1] + m[k][1]);
        }
      }
    }
  }
  ll ans = 0;
  for (int i = 0; i < 10; i++) {
    ans = max(dp[i][n], ans);
  }
  cout << ans << endl;
}
