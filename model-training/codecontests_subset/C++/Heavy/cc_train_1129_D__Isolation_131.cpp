#include <bits/stdc++.h>
using namespace std;
template <class X, class Y>
void amax(X &x, const Y &y) {
  if (x < y) x = y;
}
template <class X, class Y>
void amin(X &x, const Y &y) {
  if (x > y) x = y;
}
const int INF = 1e9 + 10;
const long long INFL = (long long)1e18 + 10;
const int MAX = 1e5 + 10;
const int MAXS = 320;
const int MOD = 998244353;
int n, k, sn;
int a[MAX], prv[MAX], last[MAX], dp[MAX], q[MAXS][2 * MAXS];
int c[MAX], sc[MAXS];
int gb(int i) { return (i - 1) / sn + 1; }
int bl(int i) {
  if (i <= n / sn) return sn;
  return n - (n / sn) * sn;
}
pair<int, int> itv(int i) {
  return make_pair((i - 1) * sn + 1, min(i * sn, n));
}
int add(int a, int b) { return (a + b) % MOD; }
int gq(int i, int j) { return q[i][j + MAXS]; }
void uq(int i, int j, int v) { q[i][j + MAXS] = add(q[i][j + MAXS], v); }
void calcq(int i) {
  memset(q[i], 0, 2 * MAXS * sizeof(q[i][0]));
  int l = itv(i).first, r = itv(i).second;
  int t = 0;
  for (int j = r; j >= l; j--) {
    t += c[j];
    uq(i, t, dp[j - 1]);
  }
  for (int j = -bl(i) + 1; j <= bl(i); j++) uq(i, j, gq(i, j - 1));
  sc[i] = t;
}
void process() {
  cin >> n >> k;
  for (int i = 1; i <= n; i++) cin >> a[i];
  sn = max((int)sqrt(n), 1);
  for (int i = 1; i <= n; i++) {
    prv[i] = last[a[i]];
    last[a[i]] = i;
  }
  dp[0] = 1;
  for (int i = 1; i <= n; i++) {
    if (i > 0 && gb(i) > gb(i - 1)) calcq(gb(i - 1));
    if (prv[prv[i]] != 0) {
      c[prv[prv[i]]] = 0;
      if (gb(prv[prv[i]]) < gb(i)) calcq(gb(prv[prv[i]]));
    }
    if (prv[i] != 0) {
      c[prv[i]] = -1;
      if (gb(prv[i]) < gb(i)) calcq(gb(prv[i]));
    }
    c[i] = 1;
    int l = itv(gb(i)).first;
    int t = 0;
    for (int j = i; j >= l; j--) {
      t += c[j];
      if (t <= k) dp[i] = add(dp[i], dp[j - 1]);
    }
    int x = k - t;
    for (int j = gb(i) - 1; j >= 1; j--) {
      if (x >= -bl(j)) {
        if (x <= bl(j))
          dp[i] = add(dp[i], gq(j, x));
        else
          dp[i] = add(dp[i], gq(j, bl(j)));
      }
      x -= sc[j];
    }
  }
  cout << dp[n];
}
int main() {
  ios_base::sync_with_stdio(false);
  process();
}
