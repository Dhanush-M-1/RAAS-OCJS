#include <bits/stdc++.h>
using namespace std;
const int mxn = 3e5 + 5;
const int mxm = 1e5 + 5;
const int INF = 0x3f3f3f3f;
const int mod = 1e9 + 7;
const double eps = 1e-7;
const double pii = 3.1415926535898;
int gcd(int x, int y) {
  if (y == 0)
    return x;
  else
    return gcd(y, x % y);
}
int qpow(int a, int b) {
  int ans = 1;
  while (b) {
    if (b & 1) ans = ans * a % mod;
    b >>= 1;
    a = a * a % mod;
  }
  return ans;
}
int lowbit(int x) { return (x & (-x)); }
int qmul(int a, int b) {
  int ans = 0;
  while (b) {
    if (b & 1) ans = (ans + a) % mod;
    b >>= 1;
    a = (a + a) % mod;
  }
  return ans;
}
int pos[300005];
vector<int> g[mxn];
int cnt[mxn], fan[mxn];
signed main(void) {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &pos[i]);
    fan[pos[i]] = i;
  }
  for (int i = 1; i <= m; i++) {
    int u, v;
    scanf("%d%d", &u, &v);
    g[v].push_back(u);
  }
  for (int i = 0; i < g[pos[n]].size(); i++) {
    int v = g[pos[n]][i];
    cnt[fan[v]]++;
  }
  int now = n;
  for (int i = n - 1; i >= 1; i--) {
    if (cnt[i] == now - i) {
      now--;
    } else {
      for (int j = 0; j < g[pos[i]].size(); j++) {
        int v = g[pos[i]][j];
        cnt[fan[v]]++;
      }
    }
  }
  printf("%d\n", n - now);
}
