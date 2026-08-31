#include <bits/stdc++.h>
using namespace std;
template <typename T, typename U>
inline void chkmax(T& x, U y) {
  if (x < y) x = y;
}
template <typename T, typename U>
inline void chkmin(T& x, U y) {
  if (y < x) x = y;
}
int k, t, a[111], tot, id[111], dp[111][111 * 111], b[111], s, n;
bool cmp(int u, int v) { return b[u] > b[v]; }
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) scanf("%d", &a[i]), tot += a[i];
  for (int i = 0; i < n; i++) scanf("%d", &b[i]), id[i] = i;
  sort(id, id + n, cmp);
  for (int i = 0; i < n; i++) {
    s += b[id[i]];
    if (s >= tot) {
      k = i + 1;
      break;
    }
  }
  for (int i = 0; i <= k; i++)
    for (int j = 0; j < 111 * 111; j++) dp[i][j] = -1e8;
  dp[0][0] = 0;
  for (int i = 0; i < n; i++) {
    for (int j = k; j >= 1; j--)
      for (int l = 0; l < 111 * 111 - b[i]; l++) {
        chkmax(dp[j][l + b[i]], dp[j - 1][l] + a[i]);
      }
  }
  t = 1e8;
  for (int j = tot; j < 111 * 111; j++) chkmin(t, tot - dp[k][j]);
  cout << k << " " << t << endl;
  return 0;
}
